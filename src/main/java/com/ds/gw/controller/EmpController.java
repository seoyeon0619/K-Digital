package com.ds.gw.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.gw.dto.EmpDto;
import com.ds.gw.service.EmpService;

import jakarta.annotation.Resource;

@Controller
public class EmpController {
	
	@Resource(name="empService")
	EmpService empService;
	
	// 사용자 포털로 이동
	@GetMapping("/user")
	public String user_portal() {
		return "user.html";
	}
	
	// insert
	@RequestMapping("/user/save")
	public String save(EmpDto dto, Model model)
	{
		empService.insert(dto);
		return "redirct:/admin_list.html";
	}
	
	// 관리자 포털로 이동
	@RequestMapping("/admin")
	public String getList(EmpDto dto, Model model) throws Exception{
		List<EmpDto> list = empService.getList(dto);
		model.addAttribute("list", list);
		System.out.println(list);
		return "admin_list.html";
	}
	

	
	
	

	
	
	
}
