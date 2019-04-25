package com.hankook.web.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hankook.web.dao.TestDAO;
import com.hankook.web.service.TestService;
import com.hankook.web.vo.TokenVO;

@Service("testService")
public class TestServiceImpl implements TestService {
	
	@Resource(name="Web/TestDAO")
	private TestDAO testDAO;
	
	@Override
	public String selectToken(TokenVO vo) throws Exception {
		return testDAO.selectToken(vo);
	}
	
	
	
/*
	@Override
	public List<Map<String, Object>> selectVehicleStatus(Map<String, Object> param) throws Exception {
		return mainMapper.selectVehicleStatus(param);
	}

	@Override
	public List<Map<String, Object>> selectServiceResultSummary(Map<String, Object> param) throws Exception {
		return mainMapper.selectServiceResultSummary(param);
	}

	@Override
	public Map<String, Object> selectWorkOrder(Map<String, Object> param) throws Exception {
		return mainMapper.selectWorkOrder(param);
	}

	@Override
	public List<Map<String, Object>> selectServiceResource(Map<String, Object> param) throws Exception {
		return mainMapper.selectServiceResource(param);
	}
	
	@Override
	public Map<String, Object> selectServiceResourceChild(Map<String, Object> param) throws Exception {
		return mainMapper.selectServiceResourceChild(param);
	}

	@Override
	public List<Map<String, Object>> selectVehicleMileage(Map<String, Object> param) throws Exception {
		return mainMapper.selectVehicleMileage(param);
	}

	@Override
	public List<Map<String, Object>> selectTireMounted(Map<String, Object> param) throws Exception {
		return mainMapper.selectTireMounted(param);
	}
	
	@Override
	public List<Map<String, Object>> selectTireStock(Map<String, Object> param) throws Exception {
		return mainMapper.selectTireStock(param);
	}

	@Override
	public Map<String, Object> selectVehicleIns(Map<String, Object> param) throws Exception {
		return mainMapper.selectVehicleIns(param);
	}

	@Override
	public Map<String, Object> selectOrder(Map<String, Object> param) throws Exception {
		return mainMapper.selectOrder(param);
	}
*/

}