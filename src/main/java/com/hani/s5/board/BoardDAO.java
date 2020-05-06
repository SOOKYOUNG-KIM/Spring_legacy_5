package com.hani.s5.board;

import java.util.List;
import java.util.Map;

import com.hani.s5.util.Pager;

public interface BoardDAO {
	
	//멤버변수로 상수만을 가짐
	//추상메서드만을 멤버로 가짐
	//public abstract 
	//생략해도 자동으로 만들어짐
	
	//Count
	public long boardCount(Pager pager) throws Exception;

	//List 
	public List<BoardVO> boardList(Pager pager) throws Exception;		//여기가지가 추상메서드

	//select
	public BoardVO boardSelect(long num) throws Exception;
	
	//Insert
	public int boardWrite(BoardVO boardVO) throws Exception;
	
	//Update
	public int boardUpdate(BoardVO boardVO)throws Exception;
	
	//Delete
	public int boardDelete(long num)throws Exception;
	
	//hit update
	public int hitUpdate(long num)throws Exception;
}
