
package com.te.employeeproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestDeligationController {
	
	@GetMapping("/redirect")
	public String redirectRequest() {
		return "redirect:http://youtube.com";
		
	}
	
	@GetMapping("/forward")
	public String forwardRequest() {
		return "forward:login";
		
	}

}
