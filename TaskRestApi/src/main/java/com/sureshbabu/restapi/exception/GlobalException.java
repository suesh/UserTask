package com.sureshbabu.restapi.exception;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sureshbabu.restapi.util.ProjectConstants;


@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalException {
	public static final String EXCEPTION = "Exception";
	public static final String ACCESS_DENIED_EXCEPTION = "Access Denied";

	

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<CommonException> handleConstraintViolationException(ConstraintViolationException e) {
		CommonException commonException = new CommonException();
		e.printStackTrace();
		commonException.setStatusMessage(e.getMessage());
		commonException.setStatusCode(ProjectConstants.STATUS_ERROR_CODE);
//		return new ResponseEntity<CommonException>(commonException, HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(commonException);
		
	}
	

	@ExceptionHandler(value = AccessDeniedException.class)
	public ResponseEntity<CommonException> getException(AccessDeniedException e) {
		CommonException commonException = new CommonException();
		commonException.setStatusMessage(e.getMessage());
		commonException.setStatusCode(ProjectConstants.STATUS_ERROR_CODE);
		return new ResponseEntity<CommonException>(commonException, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(value = SQLException.class)
	public ResponseEntity<CommonException> getException(SQLException e) {
		CommonException commonException = new CommonException();
		commonException.setStatusMessage(e.getMessage());
		commonException.setStatusCode(ProjectConstants.STATUS_ERROR_CODE);
		return new ResponseEntity<CommonException>(commonException, HttpStatus.UNAUTHORIZED);
	}
	

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<CommonException> getException(Exception e) {
		CommonException commonException = new CommonException();
		e.printStackTrace();
		commonException.setStatusMessage(e.getMessage());
		commonException.setStatusCode(ProjectConstants.STATUS_ERROR_CODE);
		return new ResponseEntity<CommonException>(commonException, HttpStatus.BAD_REQUEST);
	}

}
