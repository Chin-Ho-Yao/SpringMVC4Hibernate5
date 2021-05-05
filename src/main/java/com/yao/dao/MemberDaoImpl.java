package com.yao.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yao.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Member getMember(Integer memberId) {
		return sessionFactory.getCurrentSession().get(Member.class, memberId);
	}

	@Override
	public void createMember(Member member) {
		sessionFactory.getCurrentSession().persist(member);
	}

}
