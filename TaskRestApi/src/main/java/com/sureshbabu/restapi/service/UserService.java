package com.sureshbabu.restapi.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sureshbabu.restapi.exception.CommonException;
import com.sureshbabu.restapi.exception.UserServiceException;
import com.sureshbabu.restapi.model.User;
import com.sureshbabu.restapi.repo.UserRepo;
import com.sureshbabu.restapi.util.ErrorMessages;

@Service
public class UserService {
	@Autowired
	private UserRepo mUserRepo;

	

	public User createUser(User userDetails) {
		
		
		return mUserRepo.save(userDetails);
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return mUserRepo.findAll();
	}

	public User findById(@Valid Long userId) {
		return mUserRepo.findById(userId)
		.orElseThrow(() ->new UserServiceException(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage() + " " +userId));
		
	}

	public User updateUser(Long userId, User userDetails) {
		
		User user = mUserRepo.findById(userId)
				.orElseThrow(() ->new UserServiceException(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage() + " " +userId));

		user.setEmailId(userDetails.getEmailId());
		user.setLastName(userDetails.getLastName());
		user.setFirstName(userDetails.getFirstName());
		final User updatedUser = mUserRepo.save(user);
		return updatedUser;
	
	}

	public CommonException deleteUser(Long userId) {
		User user = mUserRepo.findById(userId)
				.orElseThrow(() ->new UserServiceException(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage() + " " +userId));
		
		mUserRepo.delete(user);
		CommonException commonException =new CommonException();
		commonException.setStatusCode("SR");
		commonException.setStatusMessage("User Record Deleted successfully");
		return commonException;
	}

}
