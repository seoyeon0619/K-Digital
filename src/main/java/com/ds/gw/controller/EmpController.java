package com.ds.gw.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.gw.dto.DeptDto;
import com.ds.gw.dto.EmpDto;
import com.ds.gw.dto.HobbyDto;
import com.ds.gw.service.DeptService;
import com.ds.gw.service.EmpService;
import com.ds.gw.service.HobbyService;

import jakarta.annotation.Resource;

@Controller
public class EmpController {
	
	@Resource(name="empService")
	EmpService empService;
	@Resource(name="deptService")
	DeptService deptService;
	@Resource(name="hobbyService")
	HobbyService hobbyService;
	
	
	// 사용자 포털로 이동
	@RequestMapping(value = "/user")
	public String user_portal(EmpDto dto, DeptDto dto_d, HobbyDto dto_h, Model model) {
		List<DeptDto> list_d = deptService.getDeptList(dto_d);
		System.out.println(list_d);
		model.addAttribute("list_d", list_d);
		return "user.html";
	}
	
	// insert
	@RequestMapping(value = "/user/save")
	public String save(EmpDto dto, Model model)
	{
		empService.insert(dto);
		return "redirct:/admin_list.html";
	}
	
	// 관리자 포털로 이동
	@RequestMapping(value = "/admin")
	public String getEmpList(EmpDto dto, DeptDto dto_d, HobbyDto dto_h, Model model){
		List<EmpDto> list = empService.getEmpList(dto);
		List<DeptDto> list_d = deptService.getDeptList(dto_d);
		List<HobbyDto> list_h = hobbyService.getHobbyList(dto_h);
		
//		EmpDto resultDto = empService.getView(dto);
		
		model.addAttribute("list", list);
		model.addAttribute("list_d", list_d);
		model.addAttribute("list_h", list_h);
//		model.addAttribute("dto", resultDto);
	
		
		return "admin_list.html";
	}
	
//	@RequestMapping(value = "/admin/#{emp_id}")
//	public List<EmpDto> getView(EmpDto dto, Model model) {
//		List<EmpDto> list = empService.getEmpList(dto);
//		EmpDto resultDto = empService.getView(dto);
//		model.addAttribute("dto", resultDto);
//		return list;
//		
//	}
//	
	
	
	

	
	
	

	
	
	
}
