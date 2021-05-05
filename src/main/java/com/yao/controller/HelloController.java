package com.yao.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
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
		System.out.println("MemberName is " + member.getMemberName());
		System.out.println("RegisterTime is " + member.getRegisterTime());
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("MemberName", MemberName);
		mv.addObject("RegisterTime", RegisterTime);
		return mv;
	}
	// 這邊不懂
	
	@RequestMapping(value = "/createMember", method = {
			RequestMethod.POST }, produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	public String createMember(HttpServletRequest request, @RequestBody String receiveJSONString) {
		System.out.println("createMember(From SpringMVC4Hibernate5 HelloController.java)");
		String resultString = null;
		
		// 轉換收到的request
		JSONObject receiveJsonObject = new JSONObject(receiveJSONString);// 跟前端溝通的語言 postman會用到JSON
		Integer memberId = receiveJsonObject.optInt("member_id");// optInt從外面拿進來 遇到null不會報錯，getInt從外面拿進來遇到null 會報錯
		String memberEmail = receiveJsonObject.optString("member_email");
		String memberName = receiveJsonObject.optString("member_name");
		String password = receiveJsonObject.optString("password");

		// 將轉換的requset塞到新增的model
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberEmail(memberEmail);
		member.setMemberName(memberName);
		member.setPassword(password);
		Timestamp timestampDate = new Timestamp(new Date().getTime());// ？？？這邊不懂
		member.setRegisterTime(timestampDate);
		member.setLoginTime(timestampDate);
		member.setUpdateTime(timestampDate);

		Member memberResult = memberService.createMember(member);
		resultString = this.writeValueAsString(memberResult);
		System.out.println(resultString);

		return resultString;

	}

	// ？？？？這邊要幹嘛
	public static String writeValueAsString(Object object) {// ？？？不懂
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(object);
		} catch (IOException e) {
			System.out.println("IOException :" + e.getMessage());
		}
		return jsonString;
	}

}
