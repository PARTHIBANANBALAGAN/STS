package com.sts.dao;

import com.sts.domain.UserForm;

public interface LoginDao {
	public boolean isValidate(UserForm login); 
}
