package com.hani.s5.qna;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.hani.s5.AbstractTestCase;


public class QnaDAOTest extends AbstractTestCase {
	
	private QnaDAO qnaDAO;
	
	public void daoIsnull() {
		assertNotNull(qnaDAO);
	}
	
	@Test
	public void daoTest()throws Exception{
		this.boardWriteTest();
	}

	
	
	public void boardWriteTest() throws Exception{
		
		String writer = "";
		String title = "";
		String contents="";
		for(int i=0;i<150;i++) {
		QnaVO qnaVO = new QnaVO();
		if(i%3==0) {
			writer="bini";
			title="Alert";
			contents="Samsung";
		}else if(i%3==0) {
			writer="hani";
			title="computer";
			contents="Apple";
		}else {
			writer="sunsu";
			title="os";
			contents="Linux";
		}
		
		qnaVO.setTitle(title+i);
		qnaVO.setWriter(writer);
		qnaVO.setContents(contents+i);
		
		int result = qnaDAO.boardWrite(qnaVO);
		
		if(i==50 || i==100) {
			Thread.sleep(1000);
			}
		}
		
}
}