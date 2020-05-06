package com.hani.s5.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hani.s5.board.BoardVO;
import com.hani.s5.notice.NoticeVO;
import com.hani.s5.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() throws Exception {
		return "qna";
	}
	
	
	//1.List
	@GetMapping("qnaList")	//@GetMapping - method가 Get이라는 뜻 
	public ModelAndView boardList(Pager pager, ModelAndView mv) throws Exception{
		List<BoardVO> ar = qnaService.boardList(pager);
		mv.setViewName("board/boardList");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		return mv;
	}
	
	//2.Insert
	@GetMapping("qnaWrite")
	public String boardWrite() throws Exception{
		return "board/boardWrite";
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView boardWrite(NoticeVO noticeVO, ModelAndView mv, MultipartFile [] files) throws Exception{
		int result = qnaService.boardWriter(noticeVO, files);
		if(result>0){
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.addObject("result","Write Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/result");
		}
		return mv;
		
	}

	//3.Select
	@GetMapping("qnaSelect")
	public ModelAndView boardSelect(long num, ModelAndView mv) throws Exception{
		 BoardVO boardVO = qnaService.boardSelect(num);
		 mv.addObject("vo", boardVO);
		 mv.setViewName("board/boardSelect");
		 return mv;
		
	}
	
	//4. Reply
	@GetMapping("qnaReply")
	public ModelAndView boardReply(ModelAndView mv, long num)throws Exception{
		mv.addObject("num", num);
		mv.setViewName("board/boardReply");
		return mv;
	}
	
	@PostMapping("qnaReply")
	public ModelAndView boardReply(ModelAndView mv, QnaVO qnaVO)throws Exception{
		int result = qnaService.boardReply(qnaVO);
		if(result>0){
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.addObject("result","Reply Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	
	
	//5.Update
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.GET)
	public String boardUpdate(long num, Model model) throws Exception{
		BoardVO boardVO = qnaService.boardSelect(num);
		model.addAttribute("vo", boardVO);
		return "board/boardUpdate";
	}
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public String boardUpdate(QnaVO qnaVO, ModelAndView mv, MultipartFile [] files) throws Exception{
		int result = qnaService.boardUpdate(qnaVO, files);
		String path="";
		if(result>0) {
			path = "redirect:./qnaList";
		}else {
			path = "redirect:./qnaSelect?num="+qnaVO.getNum();
		}
	return path;
	}
	
	//6.Delete
	@RequestMapping(value = "qnaDelete", method = RequestMethod.GET)
	public ModelAndView boardDelete(long num, ModelAndView mv) throws Exception{
		int result = qnaService.boardDelete(num);
		if(result>0) {
			mv.addObject("result","Delete Success");
		}else {
			mv.addObject("result","Delete Fail");	
		}
		
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		
	return mv;
	}

}
