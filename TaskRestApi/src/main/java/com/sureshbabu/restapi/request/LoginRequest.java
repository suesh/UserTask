package com.sureshbabu.restapi.request;

import io.swagger.annotations.ApiModelProperty;

public class LoginRequest {
	
	@ApiModelProperty(example = "111", required = true)
	private String userCode;
	@ApiModelProperty(example = "111", required = true)
	private String password;

	public LoginRequest(String userCode, String password) {
		this.userCode = userCode;
		this.password = password;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest [userCode=" + userCode + ", password=" + password + "]";
	}

}
