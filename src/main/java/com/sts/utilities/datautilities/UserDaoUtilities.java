package com.sts.utilities.datautilities;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sts.domain.UserForm;
import com.sts.dao.UserDao;

@Repository("userDao")
public class UserDaoUtilities implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	   

	public void userRegister(UserForm user) {
		this.sessionFactory.getCurrentSession().save(user);		
	}

}
