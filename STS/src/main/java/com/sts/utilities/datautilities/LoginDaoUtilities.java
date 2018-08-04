package com.sts.utilities.datautilities;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sts.domain.UserForm;
import com.sts.dao.LoginDao;

@Repository
public class LoginDaoUtilities implements LoginDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public boolean isValidate(UserForm login)
	{
		boolean status=false;
		UserForm loginform=(UserForm)sessionFactory.getCurrentSession().createQuery("from UserForm where name='"+login.getName()+"' and password='"+login.getPassword()+"'").uniqueResult();
		if(loginform!=null)
		{
			status=true;
		}
		return status;
	}

}
