package com.yao.dao;

import com.yao.model.Member;

public interface MemberDao {
	public Member getMember(Integer memberId);

	public void createMember(Member member);

}
