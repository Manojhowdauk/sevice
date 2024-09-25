package com.service.common.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.service.common.entity.CustomResponse;
import com.service.common.exception.BaseException;
import com.service.common.exception.RecordNotFoundException;
import com.service.common.exception.RecordExistException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ RecordExistException.class, com.service.common.exception.RecordAlreadyExist.class })
	protected ResponseEntity<Object> handleRecordExistException(final BaseException exe) {
		exe.getHttpStatuCode();
		final ApiResponseBody apiError = new ApiResponseBody(HttpStatus.OK, false);
		apiError.setMessage(exe.getMessage());
		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(final ApiResponseBody apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	@ExceptionHandler({ CustomResponse.class })
	protected ResponseEntity<Object> handleCompanyApproval(final BaseException exe) {
		exe.getHttpStatuCode();
		final ApiResponseBody apiError = new ApiResponseBody(HttpStatus.OK, false);
		apiError.setMessage(exe.getMessage());
		return buildResponseEntity(apiError);
	}

	@ExceptionHandler({ RecordNotFoundException.class })
	protected ResponseEntity<Object> handleRecordNotFoundException(final BaseException exe) {
		exe.getHttpStatuCode();
		final ApiResponseBody apiError = new ApiResponseBody(HttpStatus.OK, false);
		apiError.setMessage(exe.getMessage());
		return buildResponseEntity(apiError);
	}
}
