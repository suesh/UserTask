package com.sureshbabu.restapi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sureshbabu.restapi.exception.GlobalException;
import com.sureshbabu.restapi.request.LoginRequest;
import com.sureshbabu.restapi.response.CommonResponse;
import com.sureshbabu.restapi.util.JwtUtils;
import com.sureshbabu.restapi.util.ProjectConstants;

@Service
public class LoginService {

	@Autowired
	private JwtUtils mJwtUtils;

	public ResponseEntity<CommonResponse> getLogin(LoginRequest loginRequest) throws Exception {

		CommonResponse commonResponse = new CommonResponse();
		if (loginRequest.getUserCode().trim().isEmpty() || loginRequest.getUserCode() == null) {
			commonResponse.setStatusCode(ProjectConstants.STATUS_ERROR_CODE);
			commonResponse.setStatusMessage("Enter Valid User Name");
		} else if (loginRequest.getPassword().trim().isEmpty() || loginRequest.getPassword() == null) {
			commonResponse.setStatusCode(ProjectConstants.STATUS_ERROR_CODE);
			commonResponse.setStatusMessage("Enter Valid Password");
		} else {

			commonResponse.setStatusCode(ProjectConstants.STATUS_SUCCESS_CODE);
			commonResponse.setStatusMessage("Login Success");

			if (commonResponse == null)
				throw new Exception(GlobalException.EXCEPTION);
			else {
				if (commonResponse.getStatusCode().equals(ProjectConstants.STATUS_SUCCESS_CODE)) {
					Map<String, Object> map = new HashMap<>();
					map.put(ProjectConstants.KEY_ACCESS_TOKEN, mJwtUtils.generateToken(loginRequest));

					commonResponse.setData(map);
				}
			}


		}

		return new ResponseEntity<CommonResponse>(commonResponse, HttpStatus.OK);
	}

	public ResponseEntity<CommonResponse> getPrivateAPI(LoginRequest loginRequest) {
		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setStatusCode(ProjectConstants.STATUS_SUCCESS_CODE);
		commonResponse.setStatusMessage("Valid Private Api");
		return new ResponseEntity<CommonResponse>(commonResponse, HttpStatus.OK);
	}
}
