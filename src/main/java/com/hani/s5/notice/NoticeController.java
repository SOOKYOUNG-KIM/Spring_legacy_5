package com.hani.s5.notice;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hani.s5.board.BoardVO;
import com.hani.s5.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard()throws Exception{
		return "notice";
	}
	
	@RequestMapping(value = "noticeSelect", method = RequestMethod.GET)
	public ModelAndView boardSelect(long num) throws Exception{
		 BoardVO boardVO = noticeService.boardSelect(num);
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("vo", boardVO);
		 mv.setViewName("board/boardSelect");
		 return mv;
		
	}
	
	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public ModelAndView boardList(Pager pager, ModelAndView mv) throws Exception{
		System.out.println("Kind:"+pager.getKind());
		System.out.println("Search:"+pager.getSearch());
		
		List<BoardVO> ar = noticeService.boardList(pager);
		System.out.println(pager.getTotalPage());
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String boardWrite() throws Exception{
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(NoticeVO noticeVO, ModelAndView mv, MultipartFile [] files) throws Exception{
		
		int result = noticeService.boardWriter(noticeVO, files);
		if(result>0){
			mv.setViewName("redirect:./noticeList");
		}else {
			mv.addObject("result","Write Fail");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/result");
			
		}
		
	return mv;
		
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public String boardUpdate(long num, Model model) throws Exception{
		BoardVO boardVO = noticeService.boardSelect(num);
		model.addAttribute("vo", boardVO);
		/* 파일갯수 보내주기 */
		NoticeVO noticeVO = (NoticeVO)boardVO;
		model.addAttribute("size", noticeVO.getBoardFileVOs().size());

		return "board/boardUpdate";
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String boardUpdate(NoticeVO noticeVO, MultipartFile [] files) throws Exception{
	
		int result = noticeService.boardUpdate(noticeVO, files);
		String path="";
		if(result>0) {
			path = "redirect:./noticeList";
		}else {
			path = "redirect:./noticeSelect?num="+noticeVO.getNum();
		}
		
	return path;
	}
	
	@RequestMapping(value = "noticeDelete", method = RequestMethod.GET)
	public ModelAndView boardDelete(long num, ModelAndView mv) throws Exception{
		int result = noticeService.boardDelete(num);
		if(result>0) {
			mv.addObject("result","Delete Success");
		}else {
			mv.addObject("result","Delete Fail");	
		}
		
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		
	return mv;
	}

}
