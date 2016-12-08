package com.p.annals;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mongodb.BasicDBList;
import com.mongodb.CommandResult;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@Controller
public class test {

	@Autowired
	 private MongoTemplate mongoTemplate;
	/*
	 * 请求jsp页面
	 */
	@RequestMapping(value="getOne.do")
	public ModelAndView getOne(){
		System.out.println("hello mis");
		
		  String jsonSql="{distinct:'person', key:'name'}";
	       CommandResult  commandResult=this.mongoTemplate.executeCommand((DBObject) JSON.parse(jsonSql));
	       System.out.println(1);
	        BasicDBList list = (BasicDBList)commandResult.get("values"); 
            for (int i = 0; i < list.size(); i ++) { 
                System.out.println(list.get(i)); 
            } 
	       System.out.println(2);
		ModelAndView mav=new ModelAndView("WEB-INF/views/test");
		HashMap tm = new HashMap();
		tm.put("test", "2222");
		return new ModelAndView("test");
	}
	
	/*
	 * 请求跳转JSP页面
	 */
	@RequestMapping(value="getOne2.do")
	public String goTo(){
		System.out.println("hello mis");
		
		ModelAndView mav=new ModelAndView("WEB-INF/views/test");
		HashMap tm = new HashMap();
		tm.put("test", "2222");
		return "redirect:/**";
	}
	
	/**
	 * 请求json数据
	 * @return
	 */
	@RequestMapping(value="html/json1.do")
	@ResponseBody
	public Map getData(){
		HashMap tm = new HashMap();
		tm.put("test", "2222");
		System.out.println("hello mir");
		return tm;
	}
}
