package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Jstlview {

	@RequestMapping(value="jstlview")
	public String getTest(){
		
		return "languageEnCh";
	}
	
	@RequestMapping("myView")
	public String getView(){
		return "myView";
	}
}
