package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ResourceController {
	
	@GetMapping("/checkAuth")
	public Map<String, String> checkAuth(HttpServletRequest req) {
		System.out.println(req.getCookies());
		
		Map<String, String> rtn = new HashMap<>();
		rtn.put("status", "200");
		rtn.put("message", "OK");
		return rtn;
	}
	
}
