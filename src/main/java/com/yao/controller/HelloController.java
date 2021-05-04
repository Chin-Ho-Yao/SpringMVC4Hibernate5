package com.yao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yao.model.Member;
import com.yao.service.MemberService;

@Controller
public class HelloController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/SpringMVC4Hibernate5")
	public String hello() {
		System.out.println("helloHibernate(From SpringMVC4Hibernate5 HelloController.java)");

		Member member = memberService.getMember(2);
		
		System.out.println("MemberName is "+member.getMemberName());
	    System.out.println("RegisterTime is "+member.getRegisterTime());
	    
	    return "hello";
		
	}
	
	
	
}
