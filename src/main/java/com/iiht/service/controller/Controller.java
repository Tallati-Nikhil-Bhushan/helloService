package com.iiht.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/service")
public class Controller {
	
	@Autowired
	Environment environment;
	
	public String welcome() {
		String port = 	environment.getProperty("server.port");
		return port;
	}
	
	@GetMapping
	public String confirm() {
		return "Connected _____ Responding";
	}
	
	@GetMapping("/factorial/{num}")
	public int factorial(@PathVariable int num) {
		int res = 1;
		while(num>0) {
			res = res * num;
			num--;
		}
		
		return res;
	}
}
