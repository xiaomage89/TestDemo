package com.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.pojo.People;
import com.demo.pojo.School;

@Controller
public class TowPageController {

	
	@RequestMapping("sessionattributes")
	public String getSessionAttributesValue(){
		return "index";
	}
	
	@ModelAttribute
	public void initModelAttributes( Map<String,Object> map){
		People people = new People(); 
		people.setId("12");
		people.setName("ma");
		people.setSchool(new School("1","2","3"));
		map.put("abc", people);
	}
	
	@RequestMapping("modelattributes")
	public String getmodelattributesValue(@ModelAttribute("abc") People people){
		System.out.println(people.toString());
		return "index";
	}
}
