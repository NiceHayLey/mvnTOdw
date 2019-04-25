package com.hankook.api.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.hankook.api.entity.ResultEntity;

@RestController
public class ApiBaseController {

	private static final Logger logger = LoggerFactory.getLogger(ApiBaseController.class);
	
	/**
	 * ContentsEntity return값 세팅
	 * @param ent
	 * @return
	 */
	public ResponseEntity<ResultEntity> returnEntitySet(ResultEntity ent, ApiReturnCode apiRtn){

		ent.setResult_code(apiRtn.getRtnCode());
		ent.setResult_messege(apiRtn.getRtnMessage());
		
		String code = apiRtn.getRtnCode();
		
		HttpStatus status;
		
		if( "000".equals(code) ){
			status = HttpStatus.OK;
		}else if( "9".equals(code.substring(0, 1)) ){
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}else{
			status = HttpStatus.BAD_REQUEST;
		}
		
		//ResponseEntity<ResultEntity> rent = new ResponseEntity<ResultEntity>(ent, HttpStatus.OK);
		ResponseEntity<ResultEntity> rent = new ResponseEntity<ResultEntity>(ent, status);
		
		logger.info("/* --- Api ResultEntity : rent : --- */" );
		logger.info(rent.toString() );
		logger.info("/* --- Api ResultEntity : rent : --- */" );
		
		return rent;
	}
	
	/**
	 * result code, result message 세팅
	 * 
	 * @param ent
	 * @param apiRtn
	 * @return
	 */
	public ResultEntity setResultMessage(ResultEntity ent, ApiReturnCode apiRtn){
		ent.setResult_code(apiRtn.getRtnCode());
		ent.setResult_messege(apiRtn.getRtnMessage());
		return ent;
	}
	
	/**
	 * 
	 * @param param
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void viewParam( Map<String, Object> param ) throws Exception {
		Set set = param.entrySet();
		Iterator iterator = set.iterator();
		System.out.println("hashMap Key : hashMap Value");
		while(iterator.hasNext()){
			Map.Entry entry = (Map.Entry)iterator.next();
			String key = (String)entry.getKey();
			String value = (String)entry.getValue();
			System.out.println(key + ":" + value);
		}
	}
	
	/**
	 * 
	 * @param OS_NAME
	 * @return
	 */
	public static boolean isWindows(String OS_NAME) {
		return (OS_NAME.indexOf("WIN") >= 0);
	}
	/**
	 * 
	 * @param OS_NAME
	 * @return
	 */
	public static boolean isNix(String OS_NAME) {
		return (OS_NAME.indexOf("NIX") >= 0 || OS_NAME.indexOf("NUX") >= 0 || OS_NAME.indexOf("AIX") > 0 );
	}
	
	
}
