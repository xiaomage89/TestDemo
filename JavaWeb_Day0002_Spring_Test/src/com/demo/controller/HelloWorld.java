package com.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import com.demo.pojo.People;
import com.demo.pojo.School;

@Controller
@SessionAttributes(value={"name","name1"})
public class HelloWorld {
	
		@RequestMapping(value = "hello")
		public String hello(){
			System.out.println("hello");
			return "success";
			
		}
		@RequestMapping(value="method",method=RequestMethod.GET)
		public String method(){
			return "success";
		}
		@RequestMapping(value="params",method=RequestMethod.GET,params={"name=majj","age=12"})
		public String params(){
			return "success";
		}
		@RequestMapping(value="headers",headers={"accept=text/html"})
		public String headers(){
			return "success";
		}
		
		@RequestMapping(value="pathvar/{id}")
		public String pathVariable(@PathVariable(value = "id") String id ){
			System.out.println(id);
			return "success";
		}
		
		@RequestMapping(value="methodGet/{id}",method=RequestMethod.GET)
		public String methodGet(@PathVariable(value = "id") String id){
			System.out.println(id);
			return "success";
		}
		
		@RequestMapping(value="methodPost",method=RequestMethod.POST)
		public String methodGet(){
			System.out.println("Post请求，新建信息");
			return "success";
		}
		
		@RequestMapping(value="methodDelete/{id}",method=RequestMethod.POST)
		public String methodDelete(@PathVariable(value = "id" )String id){
			System.out.println("Post请求 Delete ，删除信息" + id);
			System.out.println("Http协议 只有get post，springMvc里面有delete update; "
					+ "HiddenHttpMethodFilter 请求控制器转换：post请求，method里面值，转换delete update 没有认为post ");
			return "success";
		}
		
		@RequestMapping(value="methodUpdate/{id}",method=RequestMethod.POST)
		public String methodUpdate(@PathVariable(value = "id" )String id){
			System.out.println("Post请求 update，删除信息" + id);
			System.out.println("Http协议 只有get post，springMvc里面有delete update; "
					+ "HiddenHttpMethodFilter 请求控制器转换：post请求，method里面值，转换delete update 没有认为post ");

			return "success";
		}
		/**
		 * @RequestParam  参数传递
		 * @param id
		 * @param name
		 * @return
		 */
		@RequestMapping(value="postparams",method=RequestMethod.POST)
		public String postparams(@RequestParam(value = "id",required=true)String id1,String name,String name1){
			System.out.println("id" + id1);
			System.out.println("name" +name);
			System.out.println("name1" +name1);
			return "success";
		}
		
		
		@RequestMapping(value="postClass",method=RequestMethod.POST)
		public String postClass(People people){
			System.out.println(people.toString());
			List<School> schoolList = new ArrayList<School>();
			schoolList.add(people.getSchool());
			School school = new School();
			school.setSchoolname("122");
			schoolList.add(school);
			people.setSchoolList(schoolList );
			return "success";
		}
		
		@RequestMapping(value="getheader")
		public String getheader(@RequestHeader("Referer") String Referer){
			System.out.println(Referer);
			return "success";
		}
		
		@RequestMapping(value="getCookie")
		public String getCookie(@CookieValue("JSESSIONID") String a){
			System.out.println(a);
			return "success";
		}
		
		@RequestMapping(value="getServletAPI")
		public String getServletAPI(HttpServletRequest request,HttpServletResponse response ){
			System.out.println(request);
			System.out.println(response);
			return "success";
		}
		
		@RequestMapping(value="getModelandView")
	public ModelAndView getModelandView() {
		ModelAndView mv = new ModelAndView();
		
		// request 里面赋值
		mv.addObject("name", "Majj");

		// 类
		People user = new People();
		user.setId("123");
		user.setName("nihao");
		mv.addObject("user", user);

		// List
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("c++");
		list.add("oracle");
		mv.addObject("bookList", list);

		// Map
		Map<String, String> map = new HashMap<String, String>();
		map.put("zhangsan", "北京");
		map.put("lisi", "上海");
		map.put("wangwu", "深圳");
		mv.addObject("map", map);

		mv.setViewName("success");
		
		return mv;
	}
		
	@RequestMapping(value="getMap")
	public String getMap( Map<String, String> map) {
		map.put("name", "majj")	;
		map.put("name1", "majj1")	;
		return "success";
		}
	
	@RequestMapping(value="getModel")
	public String getModel(Model model) {
		model.addAttribute("name", "majj");
		model.addAttribute("name1", "majj1");
		return "success";
	}
	
	@RequestMapping(value="getModelMap")
	public String getModelMap(ModelMap modelMap) {
		modelMap.addAttribute("name", "majj");
		modelMap.addAttribute("name1", "majj1");
		return "success";
	}
}

