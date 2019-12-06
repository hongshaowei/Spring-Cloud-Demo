package com.example.demo.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.dto.HttpRespDto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth) throws IOException, ServletException {
		System.out.println(((UserDetails)auth.getPrincipal()).getUsername());
		resp.getOutputStream().print(new ObjectMapper().writeValueAsString(new HttpRespDto()));
	}

}
