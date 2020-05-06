package com.hani.s5.member.memberFile;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberFileDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.hani.s5.member.memberFile.MemberFileDAO.";
	
	//1.fileInsert 
	public int fileInsert(MemberFileVO memberFileVO)throws Exception{
		return sqlSession.insert(NAMESPACE+"fileInsert", memberFileVO);
	}
	//2.fileUpdate
	public int fileUpdate(MemberFileVO memberFileVO)throws Exception{
		return sqlSession.update(NAMESPACE+"fileUpdate", memberFileVO);
	}
	
	//3.fileDelete
	public int fileDelete(String id)throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDelete", id);
	}
	
	//4.fileSelect
	public MemberFileVO fileSelect(String id)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"fileSelect",id);
	}
	
}
