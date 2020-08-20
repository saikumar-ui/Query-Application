package com.sevenEleven.queryservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sevenEleven.queryservice.QueryServiceApplication;

@Entity
@Table(name = "query")
public class Query {

	public static final Logger LOGGER = LoggerFactory.getLogger(QueryServiceApplication.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qr_id")
	Integer id;
	
	@Column(name = "qr_question")
	String question;
	
	@Column(name = "qr_answer")
	String answer;
	
	@Column(name = "qr_status")
	Boolean status;
	
	@Column(name = "qr_answer_status")
	Boolean isAnswered;
	
	@OneToOne
	@JoinColumn(name="qr_us_id")
	User user;

	public Query() {
		super();
	}

	public Query(Integer id, String question, String answer, Boolean status, Boolean isAnswered, User user) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.status = status;
		this.isAnswered = isAnswered;
		this.user = user;
	}

	public Integer getId() {
		LOGGER.info("Inside queryId getter method");
		return id;
	}

	public void setId(Integer id) {
		LOGGER.info("Inside queryId setter method");
		this.id = id;
	}

	public String getQuestion() {
		LOGGER.info("Inside queryQuestion getter method");
		return question;
	}

	public void setQuestion(String question) {
		LOGGER.info("Inside queryQuestion setter method");
		this.question = question;
	}

	public String getAnswer() {
		LOGGER.info("Inside queryAnswer getter method");
		return answer;
	}

	public void setAnswer(String answer) {
		LOGGER.info("Inside queryAnswer setter method");
		this.answer = answer;
	}

	public Boolean getStatus() {
		LOGGER.info("Inside queryStatus getter method");
		return status;
	}

	public void setStatus(Boolean status) {
		LOGGER.info("Inside queryStatus setter method");
		this.status = status;
	}

	public Boolean getIsAnswered() {
		LOGGER.info("Inside queryIsAnswered getter method");
		return isAnswered;
	}

	public void setIsAnswered(Boolean isAnswered) {
		LOGGER.info("Inside queryIsAnswered setter method");
		this.isAnswered = isAnswered;
	}

	public User getUser() {
		LOGGER.info("Inside queryUser getter method");
		return user;
	}

	public void setUser(User user) {
		LOGGER.info("Inside queryUser setter method");
		this.user = user;
	}

	@Override
	public String toString() {
		return "Query [id=" + id + ", question=" + question + ", Answer=" + answer + ", status=" + status
				+ ", isAnswered=" + isAnswered + "]";
	}
	
}
