package com.hani.s5.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.hani.s5.board.BoardVO;
import com.hani.s5.member.memberFile.MemberFileDAO;
import com.hani.s5.member.memberFile.MemberFileVO;
import com.hani.s5.util.FileSaver;
import com.hani.s5.util.Pager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private MemberFileDAO memberFileDAO;
	@Autowired
	private FileSaver fileSaver; 
	
	public List<MemberVO> memberList(Pager memberPager)throws Exception{
		memberPager.makeRow();
		long totalCount = memberDAO.memberCount(memberPager);
		memberPager.makePage(totalCount);
		return memberDAO.memberList(memberPager);
	}

	public int memberUpdate(MemberVO memberVO)throws Exception{
		return memberDAO.memberUpdate(memberVO);
	}
	
	public int memberDelete(MemberVO memberVO) throws Exception{
		return memberDAO.memberDelete(memberVO);
	}
	
	public MemberVO memberLogin(MemberVO memberDTO)throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}
	
	public int memberJoin(MemberVO memberVO, MultipartFile avatar, HttpSession session)throws Exception{
		//HDD 저장하는 작업 -> resources/memberUpload/
		//1. 파일을 HDD에 저장
		String path = session.getServletContext().getRealPath("/resources/memberUpload");
		System.out.println(path);
		String fileName = fileSaver.saveByUtils(avatar, path);
		
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId(memberVO.getId());
		memberFileVO.setFileName(fileName);
		memberFileVO.setOriName(avatar.getOriginalFilename());
		
		//2. 파일명을 DB에 저장
		int result = memberDAO.memberJoin(memberVO);
		result = memberFileDAO.fileInsert(memberFileVO);
		
		return result; //memberDAO.memberJoin(memberVO);
	}
	
	

	
	public int fileDelete(String id, HttpSession session)throws Exception{
		
		MemberFileVO memberFileVO = memberFileDAO.fileSelect(id);
		
		int result = memberFileDAO.fileDelete(id);
		
		if(result>0) {
			
			result = fileSaver.deleteFile(memberFileVO.getFileName(),session.getServletContext().getRealPath("/resources/memberUpload"));	
			
		}
		return memberFileDAO.fileDelete(id);
	}
	
	public MemberVO memberIdCheck(MemberVO memberVO)throws Exception{
		return memberDAO.memberIdCheck(memberVO);
	}
	
	public int memberDeletes(List<String> list)throws Exception{
		return memberDAO.memberDeletes(list);
	}
	

}
