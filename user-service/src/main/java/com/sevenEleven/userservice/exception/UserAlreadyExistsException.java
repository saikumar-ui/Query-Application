package com.sevenEleven.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User already exists. login to continue.")
public class UserAlreadyExistsException extends Exception {

}
