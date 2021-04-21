package com.te.employeeproject.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class Cookies {
	@GetMapping("/cookiesPage")
	public String getCookie() {
		return "cookiePage";
		
	}
	@GetMapping("/createCookies")
	public String createCookie(HttpServletResponse response, ModelMap map) {
		Cookie cookie= new Cookie("EmpName", "kauser");
		response.addCookie(cookie);
		map.addAttribute("msg", "Cookie created Successfully");
		return "cookiePage";
	}
	
	@GetMapping("/showCookies")
	public String shoeCookie(@CookieValue(name="EmpName", required = false)String string, ModelMap map ) {
		map.addAttribute("emsg",string);
		return "cookiePage";
	}

}
