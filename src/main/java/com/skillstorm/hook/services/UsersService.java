package com.skillstorm.hook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.hook.data.UsersRepository;
import com.skillstorm.hook.models.LoginResponse;
import com.skillstorm.hook.models.Users;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	public Users login(String username,String password) {
		Users userLogin = usersRepository.findByUsernameAndPassword(username,password);
		if (userLogin != null) {
			return userLogin;
		}else {
			return null;
		}
	}
	public Users getUserInfo(String username) {
		Users userInfo = usersRepository.findByUsername(username);
		if (userInfo != null) {
			return userInfo;
		}else {
			return null;
		}
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Users add(Users user) {
		Users userCheck = usersRepository.findByUsername(user.getUsername());
		if(userCheck != null) {
			return null;
			}else {
			Users addedUser = usersRepository.save(user);
			return addedUser;
		}
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Users increment(Users user) {
		Users userCheck = usersRepository.findByUsername(user.getUsername());
		userCheck.setGoalsCompleted( userCheck.getGoalsCompleted()+1);
		if(userCheck != null) {
			Users addedUser = usersRepository.save(userCheck);
			return addedUser;
			}else {
			return null;
		}
	}
}
