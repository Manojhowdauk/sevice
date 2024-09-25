package com.service.common.exception;

import org.springframework.http.HttpStatus;

public class RecordExistException extends BaseException {

	private static final long serialVersionUID = -4362221577979174398L;

	public RecordExistException(final String msg) {
		super(msg);
	}

	@Override
	public HttpStatus getHttpStatuCode() {
		return HttpStatus.OK;
	}

}
