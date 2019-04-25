package com.hankook.api.entity;

import javax.persistence.*;

@Entity
public class TokenEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private String arena_token;
	private String user_id;
	private String user_nm;
	private String user_eng_nm;

	public TokenEntity() {}
	
	public TokenEntity(  final String arena_token
						, final String user_id
						, final String user_nm
						, final String user_eng_nm
						) {
		this.arena_token		= arena_token;
		this.user_id 		= user_id;
		this.user_nm 		= user_nm;
		this.user_eng_nm 	= user_eng_nm;
	}

	public String getArena_token() {
		return arena_token;
	}

	public void setArena_token(String arena_token) {
		this.arena_token = arena_token;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	public String getUser_eng_nm() {
		return user_eng_nm;
	}

	public void setUser_eng_nm(String user_eng_nm) {
		this.user_eng_nm = user_eng_nm;
	}

	@Override
	public String toString() {
		//Override 않 할 경우 헤더 정보만 보임.
		return ""	//"\n"
				+ "TokenEntity ["
				+ "arena_token=" + arena_token
				+ ",user_id=" + user_id
				+ ",user_nm=" + user_nm
				+ ",user_eng_nm=" + user_eng_nm
				+ "]"
				;
	}
	
	
}
