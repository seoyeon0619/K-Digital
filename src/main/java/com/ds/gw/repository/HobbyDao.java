package com.ds.gw.repository;

import java.util.List;

import com.ds.gw.dto.HobbyDto;

public interface HobbyDao {
	List<HobbyDto> getHobbyList(HobbyDto dto_h);
}
