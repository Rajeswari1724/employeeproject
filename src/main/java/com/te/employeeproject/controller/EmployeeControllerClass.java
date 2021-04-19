package com.te.employeeproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.employeeproject.bean.Employeedb;
import com.te.employeeproject.dao.EmployeeDAO;
import com.te.employeeproject.service.EmployeeService;

@Controller
public class EmployeeControllerClass {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/login")
	public String loginDisplay() {
		return "loginForm";
	}
	
	@PostMapping("/loginForm")
	public String LoginDetails(int id, String pwd,HttpServletRequest request,ModelMap map) {
		Employeedb employeedb=service.authenticate(id, pwd);
		if(employeedb!=null) {
			HttpSession session= request.getSession(true);
			session.setAttribute("emp", employeedb);
			return "homePage";
		}else {
			map.addAttribute("errmsg", "Invalid Credentials");
		}
		return "loginForm";
		
	}
	
	@GetMapping("/searchForm")
	public String getSearchForm(ModelMap map,HttpSession session) {
		if(session.getAttribute("emp")!=null) {
			return "searchPage";
		}
		return "loginForm";
	}
	@GetMapping("/search")
	public String searcEmp(int id,@SessionAttribute(name="emp",required = false)Employeedb employeedb,ModelMap map) {
		
		if(employeedb!=null) {
			Employeedb employeedb2=service.getEmployee(id);
			if(employeedb2!=null) {
				map.addAttribute("data", employeedb);
			}else {
			map.addAttribute("msg", "Data not found for the id:"+id);
		}
		return"searchPage";
	}else {
		map.addAttribute("errmsg", "Please login first");
		return"loginForm";
			
		}
		
	}
	@GetMapping("/logout")
	public String logout(ModelMap  map,HttpSession session) {
		session.invalidate();
		map.addAttribute("msg", "Logout successfull");
		
		return"loginForm";
		
	}
	@GetMapping("/showDeletePage")
	public String getDeletePage(ModelMap map,@SessionAttribute(name="emp") Employeedb employeedb) {
		if(employeedb!=null) {
			return "deletePage";
		}else {
			map.addAttribute("msg", "Login First");
		}
		return "LoginForm";
	}
	
	@GetMapping("/delete")
	public String delete( int id,ModelMap map, @SessionAttribute(name="emp")Employeedb employeedb) {
		if(employeedb!=null) {
			boolean isdeleted=service.deleteEmpData(id);
			if(isdeleted) {
				map.addAttribute("msg", "Deleted Successfully");
			}
			else {
				map.addAttribute("errmsg", "records not found in db");
			}
			return "deletePage";
		}else {
			map.addAttribute("msg", "Login First");
		}
		return "LoginForm";
		
	}
	
	@GetMapping("/getAllData")
	public String getAlldata(ModelMap map,@SessionAttribute(name="emp")Employeedb employeedb) {
		if(employeedb!=null) {
			List< Employeedb> employeedbs=service.getAllData();
			if(employeedbs!=null) {
				map.addAttribute("data", employeedbs);
			}else {
				map.addAttribute("errmsg", "Records not found");
			}
			return "getAllData";
		}else {
			map.addAttribute("msg", "Please Login first");
			return "loginForm";			
		}
		
		
	}
	
	
	
		
}
