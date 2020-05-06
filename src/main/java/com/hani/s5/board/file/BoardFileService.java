package com.hani.s5.board.file;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hani.s5.util.FileSaver;

@Service
public class BoardFileService {
	
	@Autowired
	private BoardFileDAO boardFileDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileSaver fileSaver;
	
	
	public String fileInsert(MultipartFile files)throws Exception{
		//1. HDD에 저장
		String path = servletContext.getRealPath("/resources/summer");
		System.out.println(path);
		path = fileSaver.saveByStream(files, path);
		path = servletContext.getContextPath()+"/resources/summer/"+path;
		return path;
		
	}
	
	public int fileDelete(String fileName)throws Exception{
		//1. HDD 삭제
		String path = servletContext.getRealPath("/resources/summer");
		return fileSaver.deleteFile(fileName, path);
		
	}
	
	
	
	public BoardFileVO fileSelect(BoardFileVO boardFileVO)throws Exception{
		return boardFileDAO.fileSelect(boardFileVO);
	}
	
	public int fileDelete(BoardFileVO boardFileVO)throws Exception{
		boardFileVO = boardFileDAO.fileSelect(boardFileVO);

		int result = boardFileDAO.fileDelete(boardFileVO);
		//1. HDD 삭제
		String board = "uploadnotice";
		if(boardFileVO.getBoard()==2) {
			board = "uploadqna";
		}
		
		String path = servletContext.getRealPath("/resources/"+board);
		
		fileSaver.deleteFile(boardFileVO.getFileName(), path);
		
		
		//2. DB 삭제
		
		
		return result;
	}
	
	public List<BoardFileVO> fileList(Long num)throws Exception{
		return boardFileDAO.fileList(num);
	}
	
	

}
