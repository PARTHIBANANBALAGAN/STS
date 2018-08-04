package com.sts.utilities.serviceutilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sts.dao.LoginDao;
import com.sts.domain.UserForm;
import com.sts.service.LoginService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceUtilities implements LoginService{
	
	@Autowired
	private LoginDao loginDao;
	
	public boolean isValidate(UserForm login)
	{
		return loginDao.isValidate(login);
	}
}
