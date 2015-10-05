package com.sample.employeeInfo.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController implements Serializable{

	
     
     @RequestMapping(value = { "/"}, method = RequestMethod.GET)
 	public ModelAndView welcomePage() {
    	 ModelAndView model = new ModelAndView();
    	 model.setViewName("login");
    	 return model;
     }
     @RequestMapping(value = { "/welcome"}, method = RequestMethod.GET)
     public ModelAndView homePage(HttpServletRequest request, HttpServletResponse response) {
    	 ModelAndView model = new ModelAndView();
    	 model.setViewName("welcome");
    	 return model;
     }
     

 
	
	
}
