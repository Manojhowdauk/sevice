package com.service.common.entity;

import org.springframework.http.HttpStatus;

import com.service.common.exception.BaseException;

public class CustomResponse extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1745375102296147870L;

	public CustomResponse(String msg) {
		// this.errorMessage=msg;
		super(msg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HttpStatus getHttpStatuCode() {
		// TODO Auto-generated method stub
		return HttpStatus.UNAUTHORIZED;
	}

}
