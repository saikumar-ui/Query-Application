package com.sevenEleven.appuserservice.service;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.sevenEleven.appuserservice.model.User;
import com.sevenEleven.appuserservice.repository.UserRepository;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@RefreshScope
public class AuthenticationService {

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Value("${user.service.name: default service}")
	private String applicationName;
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public Map<String, String> authenticate(String authHeader) {
		Map<String, String> tokens = new HashMap<String, String>();
		String email = getUser(authHeader);
		String token = generateJwt(email);
		tokens.put("token", token);
		User user = userRepository.findByEmail(email);
		tokens.put("username", user.getUsername());
		tokens.put("role", user.getRole());
		return tokens;
	}

	private String getUser(String authHeader) {
		String encodedCredentials = authHeader.split(" ")[1];
		byte[] credentials = Base64.getDecoder().decode(encodedCredentials);
		String user = new String(credentials).split(":")[0];
		return user;
	}

	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		// Set the token issue time as current time
		builder.setIssuedAt(new Date());
		// Set the token expiry as 20 minutes from now
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		return token;
	}
	
	@Transactional
	public void signup(User user) {		
		Application application = eurekaClient.getApplication(applicationName);
		InstanceInfo appInstance = application.getInstances().get(0);
		String url = "http://" + appInstance.getIPAddr() + ":" + appInstance.getPort() + "/signup";
		restTemplate.postForObject(url, user, String.class);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}