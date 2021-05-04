package com.yao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yao.dao.MemberDao;
import com.yao.model.Member;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	 public Member getMember(Integer memberId) {
		    return memberDao.getMember(memberId);
		  }

	

	
	


	
	
	
}
