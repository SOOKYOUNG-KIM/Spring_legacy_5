package com.hani.s5.memberFile;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hani.s5.AbstractTestCase;
import com.hani.s5.member.memberFile.MemberFileDAO;
import com.hani.s5.member.memberFile.MemberFileVO;

public class MemberFileDAOTest extends AbstractTestCase{
	
	@Autowired
	private MemberFileDAO memberFileDAO;
	
	@Test
	public void memberFileInsert() throws Exception{
		
		MemberFileVO memberFileVO = new MemberFileVO();
		
		memberFileVO.setId("gg");
		memberFileVO.setFileName("bini");
		memberFileVO.setOriName("hani");
		
		int result = memberFileDAO.fileInsert(memberFileVO);
		assertEquals(1, result);
	}
	
	
}
