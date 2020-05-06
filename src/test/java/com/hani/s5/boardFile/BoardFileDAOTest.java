package com.hani.s5.boardFile;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hani.s5.AbstractTestCase;
import com.hani.s5.board.file.BoardFileDAO;
import com.hani.s5.board.file.BoardFileVO;

public class BoardFileDAOTest extends AbstractTestCase {
	
	@Autowired
	private BoardFileDAO boardFileDAO;
	
	
	public void boardFileInsert()throws Exception{
		
		BoardFileVO boardFileVO = new BoardFileVO();
		
		boardFileVO.setNum(1);
		boardFileVO.setFileName("bini2");
		boardFileVO.setOriName("hani2");
		boardFileVO.setBoard(1);
	
		int result = boardFileDAO.fileInsert(boardFileVO);
		assertEquals(1, result);
	}


}
