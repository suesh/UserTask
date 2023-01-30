package com.sureshbabu.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sureshbabu.restapi.exception.CommonException;
import com.sureshbabu.restapi.exception.UserServiceException;
import com.sureshbabu.restapi.model.User;
import com.sureshbabu.restapi.service.UserService;
import com.sureshbabu.restapi.util.ErrorMessages;
import com.sureshbabu.restapi.util.ProjectConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Validated
public class UserController {
	@Autowired
	private UserService mUserService;

	private List<User> list = new ArrayList<>();

	@ApiOperation(value = "This api is used to add User Data", notes = "This api is used to Create User Data ")
	@ApiResponses(value = { @ApiResponse(message = "Data Added Successfully", code = 200, response = User.class),
			@ApiResponse(message = ProjectConstants.CREATED, code = 200, response = User.class),
			@ApiResponse(message = ProjectConstants.BAD_REQUEST, code = 400),
			@ApiResponse(message = ProjectConstants.DATA_NOT_FOUND, code = 404),
			@ApiResponse(message = ProjectConstants.UNSUPPORTED_MEDIA_TYPE, code = 415),
			@ApiResponse(message = ProjectConstants.INTERNAL_SERVER_ERROR, code = 500) })
	
	@PostMapping(value = "/createUser")
	public User createUser(@RequestBody @Valid @NonNull User userDetails) throws Exception {
		if (userDetails.getEmailId().isEmpty()) {
			throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage());
		}

		User createdUserDTO = mUserService.createUser(userDetails);

		return createdUserDTO;
	}

	@ApiOperation(value = "This api is used to GET All User Data", notes = "This api is used to GET All User Data")
	@ApiResponses(value = { @ApiResponse(message = "Data Retrived Successfully", code = 200, response = User.class),
			@ApiResponse(message = ProjectConstants.CREATED, code = 200, response = User.class),
			@ApiResponse(message = ProjectConstants.BAD_REQUEST, code = 400),
			@ApiResponse(message = ProjectConstants.DATA_NOT_FOUND, code = 404),
			@ApiResponse(message = ProjectConstants.UNSUPPORTED_MEDIA_TYPE, code = 415),
			@ApiResponse(message = ProjectConstants.INTERNAL_SERVER_ERROR, code = 500) })
	
	@GetMapping(value = "/getUser")
	public List<User> getUserList() {
		return mUserService.getUsers();
	}

	@ApiOperation(value = "This api is used to GET User Data by using Id", notes = "This api is used to GET User Data by using Id")
	@ApiResponses(value = { @ApiResponse(message = "Data Retrived Successfully", code = 200, response = User.class),
			@ApiResponse(message = ProjectConstants.CREATED, code = 200, response = User.class),
			@ApiResponse(message = ProjectConstants.BAD_REQUEST, code = 400),
			@ApiResponse(message = ProjectConstants.DATA_NOT_FOUND, code = 404),
			@ApiResponse(message = ProjectConstants.UNSUPPORTED_MEDIA_TYPE, code = 415),
			@ApiResponse(message = ProjectConstants.INTERNAL_SERVER_ERROR, code = 500) })

	@GetMapping(value = "/getUserById/{id}")
	public User getUserById( @PathVariable(value = "id") Long userId) {
		User getuserById = mUserService.findById(userId);
		return getuserById;
	}
	
	
	
	@ApiOperation(value = "This api is used to Update User Data by using Id", notes = "This api is used to Update User Data by using Id")
	@ApiResponses(value = { @ApiResponse(message = "Update data Successfully", code = 200, response = User.class),
			@ApiResponse(message = ProjectConstants.CREATED, code = 200, response = User.class),
			@ApiResponse(message = ProjectConstants.BAD_REQUEST, code = 400),
			@ApiResponse(message = ProjectConstants.DATA_NOT_FOUND, code = 404),
			@ApiResponse(message = ProjectConstants.UNSUPPORTED_MEDIA_TYPE, code = 415),
			@ApiResponse(message = ProjectConstants.INTERNAL_SERVER_ERROR, code = 500) })

	@PutMapping("/updateById/{id}")
	public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {
		User updateUserById = mUserService.updateUser(userId, userDetails);
		return updateUserById;

	}

	
	@ApiOperation(value = "This api is used to delete User Data by using Id", notes = "This api is used to delete User Data by using Id")
	@ApiResponses(value = { @ApiResponse(message = "delete data Successfully", code = 200, response = User.class),
			@ApiResponse(message = ProjectConstants.CREATED, code = 200, response = User.class),
			@ApiResponse(message = ProjectConstants.BAD_REQUEST, code = 400),
			@ApiResponse(message = ProjectConstants.DATA_NOT_FOUND, code = 404),
			@ApiResponse(message = ProjectConstants.UNSUPPORTED_MEDIA_TYPE, code = 415),
			@ApiResponse(message = ProjectConstants.INTERNAL_SERVER_ERROR, code = 500) })
	@DeleteMapping("/deleteUser/{id}")
	public CommonException deleteUser(@PathVariable(value = "id") Long userId) {
		CommonException updateUserById = mUserService.deleteUser(userId);

		return updateUserById;
	}

}
