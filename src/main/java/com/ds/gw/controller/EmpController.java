package com.ds.gw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {

	@RequestMapping(value = "/main")
	public String home(){
		return "index";
	}
	
	
}
