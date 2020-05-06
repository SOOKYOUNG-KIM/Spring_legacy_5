package com.hani.s5.board.file;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BoardFileDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.hani.s5.board.file.BoardFileDAO.";
	
	//1.Insert
	public int fileInsert(BoardFileVO boardFileVO)throws Exception{
		return sqlSession.insert(NAMESPACE+"fileInsert", boardFileVO);
	}
	
	//2.Select
	public BoardFileVO fileSelect(BoardFileVO boardFileVO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"fileSelect", boardFileVO);
	}
	
	//3.Delete
	public int fileDelete(BoardFileVO boardFileVO)throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDelete", boardFileVO);
	}
	
	//4. List
	public List<BoardFileVO> fileList(Long num)throws Exception{
		return sqlSession.selectList(NAMESPACE+"fileList",num);
	}
	
	//5.Deletes
	public int fileDeletes(Long num)throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDeletes", num);
	}

}
