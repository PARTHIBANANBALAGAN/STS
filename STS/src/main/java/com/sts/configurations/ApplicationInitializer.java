package com.sts.configurations;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.sts.configurations.HibernateConfigurations;
import com.sts.configurations.WebMvcConfigurations;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		return new Class[] { HibernateConfigurations.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		return new Class[] { WebMvcConfigurations.class };
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] { "/" };
	}
}
