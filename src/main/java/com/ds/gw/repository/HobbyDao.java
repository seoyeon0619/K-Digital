package com.ds.gw.repository;

import java.util.List;
import java.util.Map;

import com.ds.gw.dto.HobbyDto;

public interface HobbyDao {
	List<HobbyDto> getHobbyList(HobbyDto dto_h);
}
