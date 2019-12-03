package com.example.demo.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.example.demo.dto.HttpRespDto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException authExc) throws IOException, ServletException {
		resp.setStatus(HttpStatus.FORBIDDEN.value());
		HttpRespDto respDto = new HttpRespDto(HttpStatus.FORBIDDEN.value(), authExc.getMessage());
		resp.getOutputStream().println(new ObjectMapper().writeValueAsString(respDto));
	}

}
