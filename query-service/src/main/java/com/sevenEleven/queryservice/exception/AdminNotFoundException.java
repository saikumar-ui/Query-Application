package com.sevenEleven.queryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Only Admin can answer")
public class AdminNotFoundException extends Exception {

}
