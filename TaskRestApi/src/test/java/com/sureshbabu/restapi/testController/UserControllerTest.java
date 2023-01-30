package com.sureshbabu.restapi.testController;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sureshbabu.restapi.controller.UserController;
import com.sureshbabu.restapi.model.User;
import com.sureshbabu.restapi.service.UserService;

public class UserControllerTest {

	@InjectMocks // This allows to inject Mock objects.
	UserController userController;
	
	
	@Mock
	UserService userService;

	User userDto;
	
	private final long USER_ID = 1;
	
	@BeforeEach
	void setUp() throws Exception
	{
		/*
		 *  This is needed for Mockito to be able to instantiate the Mock Objects
		 *  and Inject into the userController object
		 */
		MockitoAnnotations.initMocks(this);

		userDto = new User();
		userDto.setId(USER_ID);
		userDto.setFirstName("Suresh");
		userDto.setLastName("babu");
		userDto.setEmailId("Suresh@yahoo.com");
		
		
		
	}
	
	@Test
	void testGetUser()
	{
		// Fake the getUserByUserId method call using mocked userService object
		when(userService.findById(anyLong())).thenReturn(userDto);
		User userRest = userService.findById(USER_ID);
		assertNotNull(userRest);
		assertEquals(USER_ID, userRest.getId());
		assertEquals(userDto.getFirstName(),userRest.getFirstName());
		assertEquals(userDto.getLastName(),userRest.getLastName());
		assertEquals(userDto.getEmailId(),userRest.getEmailId());
		
	}
	
}
