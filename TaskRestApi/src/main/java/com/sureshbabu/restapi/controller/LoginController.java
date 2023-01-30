package com.sureshbabu.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sureshbabu.restapi.model.User;
import com.sureshbabu.restapi.request.LoginRequest;
import com.sureshbabu.restapi.response.CommonResponse;
import com.sureshbabu.restapi.service.LoginService;
import com.sureshbabu.restapi.util.JwtClaimsData;
import com.sureshbabu.restapi.util.ProjectConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class LoginController {
	@Autowired
	private LoginService mLoginService;
	
	
	@ApiOperation(value = "This api is used to Create Token", notes = "This api is used to Create Token ")
	@ApiResponses(value = { @ApiResponse(message = "Data Added Successfully", code = 200, response = CommonResponse.class),
			@ApiResponse(message = ProjectConstants.CREATED, code = 200, response = CommonResponse.class),
			@ApiResponse(message = ProjectConstants.BAD_REQUEST, code = 400),
			@ApiResponse(message = ProjectConstants.DATA_NOT_FOUND, code = 404),
			@ApiResponse(message = ProjectConstants.UNSUPPORTED_MEDIA_TYPE, code = 415),
			@ApiResponse(message = ProjectConstants.INTERNAL_SERVER_ERROR, code = 500) })
	
	
	
	@PostMapping(value = ProjectConstants.URL_LOGIN)
	public ResponseEntity<CommonResponse> getLogin(@RequestBody LoginRequest data) throws Exception {
		return mLoginService.getLogin(data);
	}

}
