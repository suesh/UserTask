package com.sureshbabu.restapi.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sureshbabu.restapi.util.JwtClaimsData;
import com.sureshbabu.restapi.util.JwtUtils;
import com.sureshbabu.restapi.util.ProjectConstants;

import io.jsonwebtoken.Claims;

@Component
public class JwtInterceptor implements HandlerInterceptor {

	@Autowired
	private JwtUtils jwtUtils;

	private JwtClaimsData jwtClaimsData;

	private String LOGIN_URI = "login";
	private String SWAGGER_URI = "swagger";
	private String ERROR_URI = "error";

	public JwtInterceptor(JwtClaimsData jwtClaimsData) {
		this.jwtClaimsData = jwtClaimsData;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String auth = request.getHeader(ProjectConstants.HEADER_AUTHORIZATION);

		List<String> urlList = new ArrayList<>();
		urlList.add(LOGIN_URI);
		urlList.add(SWAGGER_URI);
		urlList.add(ERROR_URI);

		if (!urlList.stream().anyMatch(a -> request.getRequestURI().matches("(.*)" + a + "(.*)"))) {

			jwtUtils.verify(auth);

			Claims claims = jwtUtils.verify(auth);

			jwtClaimsData.setUserName(claims.get(ProjectConstants.CLAIM_USER_NAME).toString());
//			jwtClaimsData.setUserType(claims.get(ProjectConstants.CLAIM_USER_TYPE).toString());
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
