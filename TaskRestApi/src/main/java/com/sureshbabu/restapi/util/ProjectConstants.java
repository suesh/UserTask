package com.sureshbabu.restapi.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

public class ProjectConstants {
	public static final String STATUS_SUCCESS_CODE = "SR";
	public static final String STATUS_ERROR_CODE = "ER";

	public static final String URL_LOGIN = "/login";
	public static final String URL_PRIVATE_API = "/api";
	
	public static final String URL_USER_ADD = "/add";
	public static final String URL_USER_GET_ALL = "/getAll";
	
	public static final String URL_CREATE_USER = "/createUser";
	
	public static final String URL_GET_USER = "/getUser";
	
	public static final String URL_GET_USERBYID = "/getUserById/{id}";

	public static final String CLAIM_USER_NAME = "UserName";
	public static final String CLAIM_USER_TYPE = "UserType";

	public static final String KEY_ACCESS_TOKEN = "accessToken";

	public static final String HEADER_AUTHORIZATION = "authorization";

	public static final String QUERY_PARAM_USER_CODE = "userCode";
	public static final String QUERY_PARAM_PASSWORD = "password";
	public static final String QUERY_PARAM_USER_ROLE = "userRole";

	public static final String PROCEDURE_USER = "test_jpa";
	public static final String PROCEDURE_AS_SP_CASE_DETAILS = "AS_SP_CASE_DETAILS";

	public static final String SP_KEY_STATUS_CODE = "STATUSCODE";
	public static final String SP_KEY_STATUS_MESSAGE = "STATUSMESSAGE";
	public static final String SP_KEY_DATA = "DATA";
	
	public static final String  host = "localhost:8080";


	
	public static final String CREATED = "Created";
	public static final String BAD_REQUEST = "Bad Request";
	public static final String DATA_NOT_FOUND = "Data Not Found";
	public static final String UNSUPPORTED_MEDIA_TYPE = "Unsupported media type";
	public static final String INTERNAL_SERVER_ERROR = "Internal server error";
	
	
	
}
