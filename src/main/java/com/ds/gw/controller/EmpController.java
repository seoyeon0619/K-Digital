package com.ds.gw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.gw.dto.DeptDto;
import com.ds.gw.dto.EmpDto;
import com.ds.gw.dto.EmpHobbyDto;
import com.ds.gw.dto.HobbyDto;
import com.ds.gw.service.DeptService;
import com.ds.gw.service.EmpHobbyService;
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
	@Resource(name="emphobbyService")
	EmpHobbyService emphobbyService;
	
	
	// 사용자 포털로 이동
	@RequestMapping(value = "/user")
	public String user_portal(EmpDto dto, EmpHobbyDto dto_eh,Model model) {
		model.addAttribute("EmpDto", dto);
		model.addAttribute("EmpHobbyDto", dto_eh);
		return "/user";
	}
	
	// insert 값 저장
	@RequestMapping(value = "/user/save")
	public String save(EmpDto dto, DeptDto dto_d, EmpHobbyDto dto_eh,  Model model) {
		empService.insert(dto);
		//emphobbyService.insert_eh(dto_eh);
		//if문 써서 취미개수가 1개면 그냥 추가
		//만약에 여러개면 Split 써서 나눠서 추가
		return "redirect:/admin";
	}
	
	// 관리자자 포털로 이동
	@RequestMapping(value = "/admin")
	public String admin_portal() {
		return "/admin_list";
	}
	
	// 사용자 리스트 가져오기
	@ModelAttribute("list")
	public List<EmpDto> getEmpList(EmpDto dto){
		List<EmpDto> list = empService.getEmpList(dto);
		return list;
	}
	
	// 부서 리스트 가져오기
	@ModelAttribute("list_d")
	public List<DeptDto> getDeptList(DeptDto dto_d) {
		List<DeptDto> list_d = deptService.getDeptList(dto_d);
		return list_d;
	}
	
	// 취미 리스트 가져오기
	@ModelAttribute("list_h")
	public List<HobbyDto> getHobbyList(HobbyDto dto_h) {
		List<HobbyDto> list_h = hobbyService.getHobbyList(dto_h);
		return list_h;
	}
	
	// 사원의 취미 리스트 가져오기
	@ModelAttribute("list_eh")
	public List<EmpHobbyDto> getEmpHobbyList(EmpHobbyDto dto_eh) {
		List<EmpHobbyDto> list_eh = emphobbyService.getEmpHobbyList(dto_eh);
		return list_eh;
	}

	@RequestMapping(value = "/admin/view/{emp_id}")
	public String getView(@PathVariable("emp_id") String emp_id, EmpDto dto, DeptDto dto_d, EmpHobbyDto dto_eh, Model model) {
		EmpDto resultDto = empService.getView(dto);
		DeptDto resultDto_d = deptService.getDeptView(dto_d);
		EmpHobbyDto resultDto_eh = emphobbyService.getEmpHobbyView(dto_eh);
		
		model.addAttribute("dto", resultDto);
		model.addAttribute("dto_d", resultDto_d);
		model.addAttribute("dto_eh", resultDto_eh);
		return "admin_view/{emp_id}";
	}
	
	@PutMapping("/admin/update/{emp_id}")
	public String update(@PathVariable("emp_id") String emp_id, EmpDto dto, DeptDto dto_d, EmpHobbyDto dto_eh) {
		empService.update(dto);
		return "redirect:/admin/view/{emp_id}";
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/delete")
	public Map<String, String> delete(EmpDto dto)
	{
		Map<String, String> resultMap = new HashMap<String, String>();
		empService.delete(dto);
		resultMap.put("result", "success");
		return resultMap;
	}
	
	
	
	
	
	
	
	
	

	
	
	

	
	
	
}
