package com.yao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yao.dao.MemberDao;
import com.yao.model.Member;

@Service("memberService")
@Transactional // 存取映射必須加上交易管理注釋，用來確定這筆資料處理完成都沒報錯才回處理，如果中間有錯誤就不會動到資料庫
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public Member getMember(Integer memberId) {
		return memberDao.getMember(memberId);
	}

	@Override
	public Member createMember(Member member) {
		memberDao.createMember(member);
		Member memberResult = this.getMember(member.getMemberId());//回傳的結果是用剛剛傳入的memberidget回來
		return memberResult;//回傳給前端用
	}

}
