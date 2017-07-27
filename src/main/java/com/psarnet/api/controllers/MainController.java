package com.psarnet.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping("/login")
	public ModelAndView loginPage(ModelAndView v){
		  v.setViewName("login");
		  return v;
	}
}
