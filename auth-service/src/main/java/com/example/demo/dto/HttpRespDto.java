package com.example.demo.dto;

import org.springframework.http.HttpStatus;

public class HttpRespDto {

	private Integer status;
	private String message;

	public HttpRespDto() {
		this.status = HttpStatus.OK.value();
		this.message = "OK";
	}

	public HttpRespDto(Integer status, String message) {
		this.status = status;
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
