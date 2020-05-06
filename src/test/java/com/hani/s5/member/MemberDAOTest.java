package com.hani.s5.member;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class MemberDAOTest {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void memberJoinTest()throws Exception {
		String id = "";
		String pw = "";
		String name = "";
		int age = 0;
		String phone="";
		String email="";
		
		for(int i=0;i<150;i++) {
		MemberVO memberVO = new MemberVO();
		if(i%3==0) {
			id="bini";
			pw="binini";
			name="bin";
			age = 22;
			phone="01077777777";
			email= id+"@naver.com";
		}else if(i%3==0) {
			id="hani";
			pw="binini";
			name="kimhani";
			age = 7;
			phone="01077774750";
			email=id+"@gmail.com";
		}else {
			id="sunsu";
			pw="binini";
			name="kimsunsu";
			age = 15;
			phone="01047507777";
			email=id+"@daum.net";
		}
		
		memberVO.setId(id+i);
		memberVO.setPw(pw);
		memberVO.setName(name+i);
		memberVO.setAge(age);
		memberVO.setPhone(phone+i);
		memberVO.setEmail(email);
		
		memberDAO.memberJoin(memberVO);
		
		if(i==50 || i==100) {
			Thread.sleep(1000);
			}
		}
	}

}
