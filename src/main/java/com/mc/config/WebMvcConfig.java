package com.mc.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMvcConfig {
	@Bean
	public HandlerMapping welcomeHandlerMapping() {
		SimpleUrlHandlerMapping handlerMapping=null;
		Properties mappings=null;
		mappings=new Properties();
		mappings.setProperty("/welcome-config.htm","viewAnnotationController");
		handlerMapping=new SimpleUrlHandlerMapping();
		handlerMapping.setMappings(mappings);
		return handlerMapping;
	}
	@Bean
	public Controller viewAnnotationController() {
		ParameterizableViewController viewController=null;
		viewController=new ParameterizableViewController();
		viewController.setViewName("welcome-config");
		
		return viewController;
	}
	@Bean
	public ViewResolver viewAnnotationResolver() {
		InternalResourceViewResolver viewResolver=null;
		viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}
