package com.service.common.exception;

import org.springframework.http.HttpStatus;

public class RecordAlreadyExist extends BaseException {

	private static final long serialVersionUID = 1035567739424125356L;

	public RecordAlreadyExist(String entityKey) {
		super("" + entityKey);
	}

	@Override
	public HttpStatus getHttpStatuCode() {
		return HttpStatus.OK;
	}

}
