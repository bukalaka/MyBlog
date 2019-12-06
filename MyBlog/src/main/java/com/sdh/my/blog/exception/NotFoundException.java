package com.sdh.my.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 1059133033@qq.com
 * @createdTime 2019年12月3日
 * @description 
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7527432682123242217L;

	public NotFoundException() {

	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String message,Throwable cause) {
		super(message,cause);
	}
}

