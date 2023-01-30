package com.sureshbabu.restapi.util;

public class JwtClaimsData {
	private String userName;

	public JwtClaimsData() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "JwtClaimsData [userName=" + userName + "]";
	}

}
