package com.hankook.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hankook.web.service.TestService;
import com.hankook.web.vo.TokenVO;

@RequestMapping(value = "/web")
@Controller
public class WebController {
	
	private Logger logger = LoggerFactory.getLogger(WebController.class);


	//@Autowired
    @Resource(name="testService")
	private TestService tService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/selectToken.do", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> selectToken(TokenVO vo, Model model) throws Exception {
		logger.info(">>>selectToken.do");
		
		HashMap<String, Object> res = new HashMap<String, Object>();
		
		System.out.println("TokenVO:" + vo.getUserId());
		
		String resResult = "";
		try {
			String ddd = tService.selectToken(vo);
			resResult = ddd;
		} catch (Exception e) {
			resResult = "N";
		}
		
		res.put("result", resResult);		 
		logger.info("resResult:" + resResult);
		
		return res;
	}
	
}
