package com.ds.gw.repository;

import java.util.List;

import com.ds.gw.dto.DeptDto;

public interface DeptDao {
	List<DeptDto> getDeptList(DeptDto dto_d);
	DeptDto getDeptView(DeptDto dto_d);
}
