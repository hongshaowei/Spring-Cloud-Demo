package com.example.demo.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.example.demo.dto.HttpRespDto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException authExc) throws IOException, ServletException {
		resp.setStatus(HttpStatus.UNAUTHORIZED.value());
		HttpRespDto respDto = new HttpRespDto(HttpStatus.UNAUTHORIZED.value(), authExc.getMessage());
		resp.getOutputStream().println(new ObjectMapper().writeValueAsString(respDto));
	}

}
