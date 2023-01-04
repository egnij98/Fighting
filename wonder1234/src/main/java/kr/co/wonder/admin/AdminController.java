package kr.co.wonder.admin;

import java.io.UnsupportedEncodingException;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import kr.co.wonder.HomeController;
import kr.co.wonder.member.MemberDTO;

/**
 * Handles requests for the application home page.
 */
@Controller

public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	 @Autowired
	 AdminService service;
	
	@RequestMapping(value="admin/adminhome",method=RequestMethod.GET)
	public String adminhome() {
		
		return "admin/adminhome";
	}
	@RequestMapping(value="admin/productadd",method=RequestMethod.GET)
	public String productadd(Model model) {
		AdminProductDTO adminProductDTO= new AdminProductDTO();
		model.addAttribute("AdminProductDTO", adminProductDTO);
		return "admin/productadd";
	}
	@RequestMapping(value="admin/productadd",method=RequestMethod.POST)
	public String Productadd(AdminProductDTO AdminProductDTO,HttpServletRequest request,@RequestPart(value="img") MultipartFile[] upload) throws Exception {
		 	request.setCharacterEncoding("utf-8");
		   String img=service.uploadFile(upload);
		   AdminProductDTO.setProduct_img(img);
		   logger.info("내용 : " + AdminProductDTO);
		  int r = service.productAdd(AdminProductDTO);
		  
		
		return "redirect:adminhome";
	
	}
	
	@RequestMapping(value="admin/productlist",method=RequestMethod.GET)
	public String productlist(Model model) throws Exception {
		  logger.info("=========list=========");
	      ModelAndView mav = new ModelAndView();
	      
	      model.addAttribute("list",service.productList());
	      
		return "admin/productlist";
	}
	@RequestMapping(value="admin/productedit",method=RequestMethod.GET)
	public String productupdate(@RequestParam("product_id")int product_id,Model model) {
		logger.info("="+product_id);
		AdminProductDTO AdminProductDTO= new AdminProductDTO();
		AdminProductDTO.setProduct_id(product_id);
		model.addAttribute("AdminProductDTO", AdminProductDTO);
		logger.info("="+AdminProductDTO);
		return "admin/productedit";
	}
	
	
	@RequestMapping(value="admin/productedit",method=RequestMethod.POST)
	public String Productedit(AdminProductDTO AdminProductDTO,HttpServletRequest request) throws Exception {
		 	request.setCharacterEncoding("utf-8");
		  logger.info("내용 : " + AdminProductDTO);
		   
		  int r = service.productEdit(AdminProductDTO);
		  
		
		return "redirect:productdetail?product_id=" + AdminProductDTO.getProduct_id();
	
	}
	@RequestMapping(value="admin/productdetail",method=RequestMethod.GET)
	public String productdetail(@RequestParam("product_id") int product_id, Model model) throws Exception {
		logger.info("product_id="+product_id);
		AdminProductDTO AdminProductDTO = service.productDetail(product_id);
		
		model.addAttribute("AdminProductDTO",AdminProductDTO);
		
		return "admin/productdetail";
		
	}
    
	@RequestMapping(value="admin/productdelete",method = RequestMethod.GET)
	public String delete(@RequestParam("product_id") int product_id, RedirectAttributes rttr) throws Exception {
		logger.info("삭제하자"+product_id);
		
		int r = service.productDelete(product_id);
		
		if(r > 0) {
			rttr.addFlashAttribute("msg","글삭제에 성공하였습니다.");
			return "redirect:productlist";
		}
		return "redirect:productdetail?product_id=" + product_id;
	}
	
	
	@RequestMapping(value="admin/memlist",method=RequestMethod.GET)
	public String memsearch(Model model) throws Exception {
		logger.info("회원조회");
		ModelAndView mav = new ModelAndView();
		model.addAttribute("list",service.memList());
		return "admin/memlist";  
	}
	@RequestMapping(value="admin/memdetail",method=RequestMethod.GET)
	public String memdetail(@RequestParam("mem_id") int mem_id, Model model) throws Exception {
		logger.info("mem_id="+mem_id);
		AdminMemDTO AdminMemDTO = service.memDetail(mem_id);
		
		model.addAttribute("AdminMemDTO",AdminMemDTO);
		logger.info(AdminMemDTO+"");
		return "admin/memdetail";
	}
	@RequestMapping(value="admin/ratingedit",method=RequestMethod.POST)
	public String ratingedit(AdminMemDTO adminMemDTO, RedirectAttributes rttr)throws Exception {
		logger.info("등급변경"+adminMemDTO);
		int r = service.memUpdate(adminMemDTO);
		return "redirect:memlist";
	}
	@RequestMapping(value="admin/auctionlist",method=RequestMethod.GET)
	public String auctionlist(Model model) throws Exception {
		  logger.info("=========list=========");
	      ModelAndView mav = new ModelAndView();
	      
	      model.addAttribute("list",service.auctionList());
	      
		return "admin/auctionlist";
	}
	@RequestMapping(value="admin/auctiondetail",method=RequestMethod.GET)
	public String auctiondetail(@RequestParam("ab_id") int ab_id, Model model)throws Exception {
		logger.info("ab_id="+ab_id);
		AdminAuctionDTO adminAuctionDTO = service.auctionDetail(ab_id);
		
		model.addAttribute("AdminAuctionDTO",adminAuctionDTO);
		logger.info(adminAuctionDTO+"");
		
		
		return "admin/auctiondetail";
	}
	
	@RequestMapping(value="admin/reportlist",method=RequestMethod.GET)
	public String reportlist(Model model) throws Exception {
		  logger.info("=========list=========");
	      ModelAndView mav = new ModelAndView();
	      
	      model.addAttribute("list",service.reportList());
	      
		return "admin/reportlist";
	}
	@RequestMapping(value="admin/auctiondelete",method=RequestMethod.GET)
	public String auctiondelete(@RequestParam("ab_id")int ab_id, RedirectAttributes rttr)throws Exception {
		
		int r= service.auctionDelete(ab_id);
		rttr.addFlashAttribute("msg","삭제완료.");
		return "redirect:auctionlist";
	}
	@RequestMapping(value="admin/noticeadd",method=RequestMethod.GET)
	public String noticeadd(Model model) {
		AdminNoticeDTO adminNoticeDTO= new AdminNoticeDTO();
		List<String> sortList= new ArrayList<String>();
		sortList.add(0,"공지사항");
		sortList.add(1,"이벤트");
		sortList.add(2,"업데이트");
		model.addAttribute("sortList", sortList);
		model.addAttribute("AdminNoticeDTO", adminNoticeDTO);
		
		return "admin/noticeadd";
	}
	@RequestMapping(value="admin/noticeadd",method=RequestMethod.POST)
	public String Noticeadd(AdminNoticeDTO AdminNoticeDTO,HttpServletRequest request) throws Exception {
		 	request.setCharacterEncoding("utf-8");
		  logger.info("내용 : " + AdminNoticeDTO);
		   
		  int r = service.noticeAdd(AdminNoticeDTO);
		  
		
		return "redirect:noticelist";
	
	}
	@RequestMapping(value="admin/noticelist",method=RequestMethod.GET)
	public String noticelist(Model model) throws Exception {
		logger.info("=========noticelist=========");
		ModelAndView mav = new ModelAndView();
		
		model.addAttribute("list",service.noticeList());
		
	    
		logger.info(""+model.toString());
		return "admin/noticelist";
	}
	@ResponseBody
	@RequestMapping(value="admin/sortlist" , method = RequestMethod.POST)
	public List<AdminNoticeDTO> sortlist(@RequestParam("notice_sort") String sort) throws Exception{
		logger.info(sort);
		return service.sortlist(sort);
	}
	
	@RequestMapping(value="admin/inquiry",method=RequestMethod.GET)
	public String inquirylist(Model model) throws Exception {
		logger.info("=========inquirylist=========");
	      ModelAndView mav = new ModelAndView();
	      
	      model.addAttribute("list",service.inquiryList());
		return "admin/inquiry";
	}
	
	@RequestMapping(value="admin/inquirydetail",method=RequestMethod.GET)
	public String inquirydetail(@RequestParam("inquiry_id") int inquiry_id, Model model) throws Exception {
		logger.info("inquiry_id="+inquiry_id);
		AdminInquiryDTO inquiryDTO = service.inquiryDetail(inquiry_id);
		
		model.addAttribute("inquiryDTO",inquiryDTO);
		logger.info(inquiryDTO+"");
		return "admin/inquirydetail";
	}
	
	@RequestMapping(value="admin/inquiryanswer",method=RequestMethod.GET)
	public String Inquiryanswer(@RequestParam("inquiry_id")int inquiry_id, @RequestParam("mem_id")int mem_id, Model model) throws Exception {
		logger.info(""+inquiry_id+mem_id);
		AdminInquiryDTO InquiryDTO=new AdminInquiryDTO();
		InquiryDTO.setInquiry_id(inquiry_id);
		int r = service.inquiryend(InquiryDTO);
		
		AdminInquiryDTO inquiryDTO= new AdminInquiryDTO();
		inquiryDTO.setMem_id(mem_id);
		model.addAttribute("inquiryDTO",inquiryDTO);
		logger.info(""+inquiryDTO);
		return "admin/inquiryanswer";
	}
	
	@RequestMapping(value="admin/inquiryanswer",method=RequestMethod.POST)
	public String inquiryanswer(AdminInquiryDTO inquiryDTO,HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		logger.info("내용"+inquiryDTO);
		int r = service.inquirtAnswer(inquiryDTO);
		
		
		return "redirect:inquiry";
	}
	@ResponseBody
	@RequestMapping(value="/noticedelete" , method = RequestMethod.POST)
	public int deleteReply(@RequestParam("notice_id")int notice_id) throws Exception {
	logger.info(""+notice_id);
	return service.noticeDelete(notice_id);
	}
	
	@ResponseBody
	@RequestMapping(value="/noticeedit" , method = RequestMethod.POST)
	public int editReply(AdminNoticeDTO adminNoticeDTO) throws Exception {
	
	return service.noticeUpdate(adminNoticeDTO);
	}
	//캐쉬충전
	@RequestMapping(value="admin/cashcharge",method=RequestMethod.GET)
	public String cashcharge(Model model) throws Exception {
		logger.info("충전신청내역");
		ModelAndView mav = new ModelAndView();
		model.addAttribute("list",service.cashcharge());
		return "admin/cashcharge";  
	}
	@RequestMapping(value="admin/charge", method = RequestMethod.GET)
	public String charge(MemberDTO memberDTO, HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		
		int r = service.charge(memberDTO);
		return "redirect:/admin/cashcharge";
	}
	@RequestMapping(value="admin/chargedelete", method= RequestMethod.GET)
	public String chargedelete(MemberDTO memberDTO, HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		int r =service.chargedelete(memberDTO);
		return "redirect:/admin/cashcharge";
	}

}
