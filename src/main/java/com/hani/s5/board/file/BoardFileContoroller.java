package com.hani.s5.board.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/boardFile/**")
public class BoardFileContoroller {
	
	@Autowired
	private BoardFileService boardFileService;
	
	@PostMapping("fileInsert")
	public ModelAndView fileInsert(MultipartFile files)throws Exception{
		ModelAndView mv = new ModelAndView();
		String fileName = boardFileService.fileInsert(files);
		mv.addObject("result", fileName);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@PostMapping("summerDelete")
	public ModelAndView fileDelete(String fileName)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardFileService.fileDelete(fileName);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	
	
	@PostMapping("fileDelete")
	public ModelAndView fileDelete(BoardFileVO boardFileVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = boardFileService.fileDelete(boardFileVO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	
	
	
	@GetMapping("fileDown")
	public ModelAndView fileDown(BoardFileVO boardFileVO)throws Exception {
		ModelAndView mv = new ModelAndView();
		boardFileVO	= boardFileService.fileSelect(boardFileVO);
		mv.addObject("file", boardFileVO);
		mv.setViewName("fileDown");
		return mv;
	}
	
	
	
	
	
}
