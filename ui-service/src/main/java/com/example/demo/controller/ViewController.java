package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.consumercontroller.AppConsumer;

@Controller
public class ViewController {
	
	@Autowired
	private AppConsumer appConsumer;

	@GetMapping("/index")
	public String showIndex(Principal principal, Model model) {
		model.addAttribute("userId", principal.getName());
		model.addAttribute("apps", appConsumer.fetchAppsById(principal.getName()));
		return "index";
	}
}
