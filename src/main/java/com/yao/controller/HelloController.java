package com.yao.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yao.model.Member;
import com.yao.service.MemberService;

@Controller
public class HelloController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/SpringMVC4Hibernate5")
	public ModelAndView hello() {
		System.out.println("helloHibernate(From SpringMVC4Hibernate5 HelloController.java)");

		Member member = memberService.getMember(2);
		String MemberName = member.getMemberName();
		Date RegisterTime = member.getRegisterTime();
		System.out.println("MemberName is "+member.getMemberName());
	    System.out.println("RegisterTime is "+member.getRegisterTime());
	    ModelAndView mv = new ModelAndView("hello");
	    mv.addObject("MemberName", MemberName);
	    mv.addObject("RegisterTime", RegisterTime);
	    return mv;
		
	}
	
	
	
}
