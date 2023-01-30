package com.sureshbabu.restapi.response;

public class CommonResponse {
	private String statusCode;
	private String statusMessage;
	private Object data;


	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
	@Override
	public String toString() {
		return "CommonResponse [statusCode=" + statusCode + ", statusMessage=" + statusMessage + ", data=" + data
				+ "]";
	}
}
