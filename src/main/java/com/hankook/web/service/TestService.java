package com.hankook.web.service;

import java.util.List;
import java.util.Map;

import com.hankook.web.vo.TokenVO;

public interface TestService {
	
	String selectToken(TokenVO vo) throws Exception;
	
	/*
	List<Map<String, Object>> selectVehicleStatus(Map<String, Object> param) throws Exception;
	
	List<Map<String, Object>> selectServiceResultSummary(Map<String, Object> param) throws Exception;
	
	Map<String, Object> selectWorkOrder(Map<String, Object> param) throws Exception;
	
	List<Map<String, Object>> selectServiceResource(Map<String, Object> param) throws Exception;
	
	Map<String, Object> selectServiceResourceChild(Map<String, Object> param) throws Exception;
	
	List<Map<String, Object>> selectVehicleMileage(Map<String, Object> param) throws Exception;
	
	List<Map<String, Object>> selectTireMounted(Map<String, Object> param) throws Exception;
	
	List<Map<String, Object>> selectTireStock(Map<String, Object> param) throws Exception;
	
	Map<String, Object> selectVehicleIns(Map<String, Object> param) throws Exception;
	
	Map<String, Object> selectOrder(Map<String, Object> param) throws Exception;
	*/
}