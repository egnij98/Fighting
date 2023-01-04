package kr.co.wonder.notice;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.wonder.HomeController;
import kr.co.wonder.admin.AdminProductDTO;
import kr.co.wonder.member.MemberDTO;


@Controller
public class NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	 @Autowired
	 NoticeService service;
	 
	 
	@RequestMapping(value="notice/inquiry",method=RequestMethod.GET)
	public String inquiry(Model model,HttpServletRequest request)throws Exception {
		InquiryDTO inquiryDTO= new InquiryDTO();
		model.addAttribute("InquiryDTO", inquiryDTO);
		HttpSession session = request.getSession();
		MemberDTO user = new MemberDTO();
	    user=(MemberDTO) session.getAttribute("user");
	    logger.info(""+user);
	    if(user == null) {
	    	 return "redirect:/member/login";
	    }
		return "notice/inquiry";
	}
	@RequestMapping(value="notice/inquiryadd", method=RequestMethod.POST)
	public String inquiryadd(InquiryDTO inquiryDTO,HttpServletRequest request,HttpSession session) throws Exception{
		request.setCharacterEncoding("utf-8");
		session = request.getSession();
		MemberDTO user = new MemberDTO(); 
		user =(MemberDTO)session.getAttribute("user");
		inquiryDTO.setMem_id(user.getMem_id());
		
		logger.info("등록:"+inquiryDTO);
		int r = service.inquiryadd(inquiryDTO);
		
		return "redirect:/";
	}
	//리스트매핑
	@RequestMapping(value="notice/notice", method= RequestMethod.GET)
	public String noticelist(@ModelAttribute("cri")CriteriaVO cri,Model model)throws Exception{
		logger.info(cri.toString());
		cri.setNotice_sort("공지사항");
		model.addAttribute("list", service.listCriteria(cri));
		PageMakerVO pageMaker	= new PageMakerVO();
		pageMaker.setCri(cri);
				
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker",pageMaker);
		
		return "notice/noticelist";
	}
	@RequestMapping(value="notice/event", method= RequestMethod.GET)
	public String eventlist(@ModelAttribute("cri")CriteriaVO cri,Model model)throws Exception{
		logger.info(cri.toString());
		cri.setNotice_sort("이벤트");
		model.addAttribute("list", service.listCriteria(cri));
		PageMakerVO pageMaker	= new PageMakerVO();
		pageMaker.setCri(cri);
				
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker",pageMaker);
		
		return "notice/eventlist";
	}
	@RequestMapping(value="notice/update", method= RequestMethod.GET)
	public String updatelist(@ModelAttribute("cri")CriteriaVO cri,Model model)throws Exception{
		logger.info(cri.toString());
		cri.setNotice_sort("업데이트");
		model.addAttribute("list", service.listCriteria(cri));
		PageMakerVO pageMaker	= new PageMakerVO();
		pageMaker.setCri(cri);
				
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker",pageMaker);
		
		return "notice/updatelist";
	}
	@RequestMapping(value="notice/noticedetail", method= RequestMethod.GET)
	public String noticedetail(@RequestParam("notice_id")int notice_id,Model model)throws Exception{
		
		NoticeDTO noticeDTO = service.noticedetail(notice_id);
		
		model.addAttribute("Notice",noticeDTO);
		
		
		return "notice/noticedetail";
	}
}
