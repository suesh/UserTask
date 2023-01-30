package com.sureshbabu.restapi.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sureshbabu.restapi.util.JwtClaimsData;

@Component
public class ConfigInterceptor implements WebMvcConfigurer {

	@Autowired
	private JwtInterceptor jwtInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor);
	}

	@Bean
	@RequestScope
	public JwtClaimsData getJwtClaimsData() {
		return new JwtClaimsData();
	}

	@Bean
	public JwtInterceptor getJwtInterceptor() {
		return new JwtInterceptor(getJwtClaimsData());
	}

}
