package com.ds.gw.service;

import java.util.List;

import com.ds.gw.dto.EmpHobbyDto;

public interface EmpHobbyService {
	List<EmpHobbyDto> getEmpHobbyList(EmpHobbyDto dto_eh);
	List<EmpHobbyDto> getEmpHobbyView(EmpHobbyDto dto_eh);
	void insert_eh(EmpHobbyDto dto_eh);
	void update_eh(EmpHobbyDto dto_eh);
	void delete_eh(EmpHobbyDto dto_eh);
}
