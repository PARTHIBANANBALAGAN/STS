package com.sts.utilities.serviceutilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sts.dao.UserDao;
import com.sts.service.UserService;
import com.sts.domain.UserForm;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceUtilities implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional(readOnly = false)
	public void userRegister(UserForm user) {
		userDao.userRegister(user);		
	}

}
