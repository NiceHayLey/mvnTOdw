package com.hankook.web.vo;

/**
 * 
 * @author hanta
 *
 */
public class TokenVO {

	private String userId;
	private String token;
	private String userNm;
	private String userEngNm;
	private String regDt;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserEngNm() {
		return userEngNm;
	}
	public void setUserEngNm(String userEngNm) {
		this.userEngNm = userEngNm;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	

}
