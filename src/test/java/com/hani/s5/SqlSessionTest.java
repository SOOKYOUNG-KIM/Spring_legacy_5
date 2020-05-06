package com.hani.s5;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hani.s5.notice.NoticeDAO;

public class SqlSessionTest extends AbstractTestCase {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void sqlTest()throws Exception {
		assertNotNull(sqlSession);
	}
	

	

}
