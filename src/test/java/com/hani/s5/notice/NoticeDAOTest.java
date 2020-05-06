package com.hani.s5.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hani.s5.AbstractTestCase;
import com.hani.s5.board.BoardVO;

public class NoticeDAOTest extends AbstractTestCase {
	
	@Autowired
	private NoticeDAO noticeDAO;

	public void daoIsnull() {
		assertNotNull(noticeDAO);
	}
	
	@Test
	public void daoTest() throws Exception {
		this.boardWriteTest();
	}

	public void boardWriteTest() throws Exception{
		
		String writer = "";
		String title = "";
		String contents="";
		for(int i=0;i<150;i++) {
		NoticeVO noticeVO = new NoticeVO();
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
		noticeVO.setTitle(title+i);
		noticeVO.setWriter(writer);
		noticeVO.setContents(contents+i);
		int result = noticeDAO.boardWrite(noticeVO);
		if(i==50 || i==100) {
			Thread.sleep(1000);
			}
		}

	}
	

	public void boardDeleteTest() throws Exception{
		int result = noticeDAO.boardDelete(15);
		assertNotEquals(0, result);
	}
	

	public void boardUpdateTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("title update");
		noticeVO.setContents("contents update");
		noticeVO.setNum(13);
		
		int result = noticeDAO.boardUpdate(noticeVO);
		assertEquals(1, result);
	}
	
	
	public void hitUpdate() throws Exception{
		int result = noticeDAO.hitUpdate(17);
		assertEquals(1, result);
	}

	
	public BoardVO boardSelectTest() throws Exception{
		BoardVO boardVO = noticeDAO.boardSelect(14);
		return boardVO;
	}
	
	
//	public List<BoardVO> boardListTest()throws Exception{
//		return noticeDAO.boardList();
//	}

}
