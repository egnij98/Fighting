package kr.co.wonder.auction;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.wonder.auction.AuctionBoardReplyDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AuctionController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuctionController.class);
	@Autowired
	AuctionService auctionservice;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */



	@RequestMapping(value = "auction/auctionmain", method = RequestMethod.GET)
	public String auction() {
		
		
		return "auction/auctionmain";
	}
	
	@RequestMapping(value ="auction/auctionproduct", method = RequestMethod.GET)
	public String auctionproduct() {
		
		
		return "auction/auctionproduct";
	}

	//경매 상품 읽기 매핑
	@RequestMapping(value ="auction/auctionproductdetail", method = RequestMethod.GET)
	public void auctionproductdetail(@RequestParam("ab_id") String ab_id, Model model) throws Exception{
		//logger.info(ab_id);
		logger.info("확인2");

		logger.info("ab_id"+ ab_id);
		AuctionBoardDTO auctionBoardDTO = auctionservice.auctionproductdetail(ab_id);

		logger.info(""+ auctionBoardDTO);
		model.addAttribute("auctionproductdetail", auctionBoardDTO);
	}
	@RequestMapping(value ="auction/auctionproductdetail", method = RequestMethod.POST)
	public String auctionproductdetail(AuctionBoardDTO dto,HttpSession session) throws Exception{
		AuctionBid bid = new AuctionBid();
		int total =dto.getAb_currentprice()+dto.getAb_pricerise();
		bid.setMem_id("admin");//세션에서 아이디값 가져올곳
		bid.setTotal(total);
		bid.setAb_id(dto.getAb_id());
		logger.info(""+bid);
		logger.info(""+dto);
		if(total <= auctionservice.pricecheck(dto.getAb_id())) {
			
			return "redirect:/auction/auctionproductdetail?ab_id="+dto.getAb_id();
		}
		logger.info(""+bid);
		auctionservice.updatebid(bid);
		return "redirect:/auction/auctionproductdetail?ab_id="+dto.getAb_id();
			}
//	@RequestMapping(value = "/auctionproductdetail2", method = RequestMethod.GET)
//	public void auctionproductidetail2(@RequestParam("ab_id") String ab_id, Model model) throws Exception{
//		
//		model.addAttribute(auctionservice.auctionproductdetail2(ab_id));
//	}
		
//		//댓글 목록
//		List<AuctionBoardReplyDTO> list = auctionservice.auctionproductdetail1(ab_id);
//		model.addAttribute("list", list);
//		
//		//경매 상품 읽기 매핑
//		@RequestMapping(value ="/auctionproductdetail", method = RequestMethod.GET)
//		public String auctionproductdetail(@RequestParam("ab_id") String ab_id, Model model) throws Exception{
//			//logger.info(ab_id);
//			logger.info("확인2");
//			
//			AuctionBoardDTO auctionBoardDTO = auctionservice.auctionproductdetail(ab_id);
//			logger.info("ab_id"+ ab_id);
//			model.addAttribute("auctionproductdetail", auctionBoardDTO);
//			
////		//댓글 목록
////		List<AuctionBoardReplyDTO> list = auctionservice.auctionproductdetail1(ab_id);
////		model.addAttribute("list", list);
////		
//			return "auctionproductdetail";
//	}
	
	//상품 등록 매핑
	@RequestMapping(value ="auction/auctionaddproduct", method = RequestMethod.GET)
	public String auctionaddproduct() {
		logger.info("====get auctionaddproduct=====");
		ModelAndView mav = new ModelAndView();
		mav.addObject("AuctionboardDTO", mav);
		return "auction/auctionaddproduct";
	}
	//상품 등록 저장
	@PostMapping(value ="auction/auctionaddproduct")
	public String auctionaddproduct(AuctionBoardDTO auctionBoardDTO, HttpServletRequest request,@RequestPart(value="img") MultipartFile[] upload) throws Exception{
		logger.info("====post auctionaddproduct=====");
		logger.info("====auctionBoardDTO=====>"+auctionBoardDTO);
		request.setCharacterEncoding("utf-8");
		String img=auctionservice.uploadFile(upload);
		auctionBoardDTO.setProduct_img(img);
		int r = auctionservice.auctionaddproduct(auctionBoardDTO);
		return "redirect:auctionlist";
	}
	//상품 수정
	@RequestMapping(value ="auction/auctionproductupdate", method = RequestMethod.GET)
	public String auctionproductupdate(@RequestParam("ab_id") String ab_id, Model model)throws Exception {
		AuctionBoardDTO auctionBoardDTO = auctionservice.auctionproductdetail(ab_id);
		model.addAttribute("auctionproductdetail", auctionBoardDTO);
		logger.info("ab_id" + ab_id);
		
		return "auction/auctionproductupdate";
	}
	//상품 수정 저장
	@RequestMapping(value="auction/auctionproductupdate", method = RequestMethod.POST)
	public String auctionproductupdate(AuctionBoardDTO auctionBoardDTO, RedirectAttributes rttr, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		logger.info(""+auctionBoardDTO);
		int r =auctionservice.auctionproductupdate(auctionBoardDTO);
		rttr.addFlashAttribute("msg", "수정성공!");
		logger.info(""+r);
		return "redirect:auctionlist";
	}
		
//	//상품 삭제
//	@RequestMapping(value ="/auctionproductdelete", method = RequestMethod.POST)
//	public String auctionproductdelete(@RequestParam("ab_id")String ab_id,AuctionPageVO pag,RedirectAttributes rttr)throws Exception {
//		
//		 auctionservice.auctionproductdelete(ab_id);
//		
//		
//			rttr.addAttribute("page", pag.getPage());
//			rttr.addAttribute("perPageNum", pag.getPerPageNum());
//			rttr.addFlashAttribute("msg", "상품이 삭제 되었습니다.");
//			return "redirect:auctionlist";
//		
//	}
		
	//상품 삭제
	@RequestMapping(value ="auction/auctionproductdelete", method = RequestMethod.GET)
	public String auctionproductdelete(@RequestParam("ab_id")String ab_id, RedirectAttributes rttr)throws Exception {
		int r = auctionservice.auctionproductdelete(ab_id);
		
		if (r>0 ) {
			//성공하면 상품 리스트로 이동
			rttr.addFlashAttribute("msg", "상품이 삭제 되었습니다.");
			return "redirect:auctionlist";
		}
		//실패하면 상품 상세보기로 이동
		return "redirect:auction/auctionproductdetail?ab_id" + ab_id;
	}
//	//게시글 페이징
//	@RequestMapping(value = "/auctionlist", method = RequestMethod.GET)
//	public ModelAndView openauctionlist(AuctionPageVO pag) throws Exception {
//		
//		
//		ModelAndView mav = new ModelAndView();
//		AuctionPageMaker auctionPageMaker = new AuctionPageMaker();
//		auctionPageMaker.setPag(pag);
//		auctionPageMaker.setTotalCount(10);
//		logger.info("jjjjjj :" + auctionPageMaker);
//		
//		List<Map<String, AuctionBoardDTO>> list = auctionservice.list(pag);
//		mav.addObject("list", list);
//		mav.addObject("auctionPageMaker", auctionPageMaker);
//		return mav;
//		
//	}


	//게시글 페이징 이거
	@RequestMapping(value = "auction/auctionlist", method = RequestMethod.GET)
	public void auctionlist(AuctionPageVO pag, Model model) throws Exception {
		
		model.addAttribute("list", auctionservice.listAuctionPageMaker(pag));
		AuctionPageMaker auctionPageMaker = new AuctionPageMaker();
		auctionPageMaker.setPag(pag);
		auctionPageMaker.setTotalCount(40);
		logger.info("jjjjjj :" + pag.getPerPageNum());
		
		auctionPageMaker.setTotalCount(auctionservice.contPaging(pag));
		
		model.addAttribute("auctionPageMaker", auctionPageMaker);
	}
	
//	//게시글 페이징+검색
//		@RequestMapping(value = "auction/auctionlistSearch", method = RequestMethod.GET)
//		public void auctionlistSearch(AuctionPageVO pag, Model model) throws Exception {
//			
//			model.addAttribute("list", auctionservice.listAuctionPageMaker(pag));
//			AuctionPageMaker auctionPageMaker = new AuctionPageMaker();
//			auctionPageMaker.setPag(pag);
//			auctionPageMaker.setTotalCount(40);
//			logger.info("jjjjjj :" + pag.getPerPageNum());
//			
//			auctionPageMaker.setTotalCount(auctionservice.contPaging(pag));
//			
//			model.addAttribute("auctionPageMaker", auctionPageMaker);
//		}
//	

	
//	//게시글 토탈 페이징
//	@RequestMapping(value = "/auctionlist", method = RequestMethod.GET)
//	public void totalauctionlist(@ModelAttribute("pag")AuctionPageVO pag, Model model)throws Exception{
//		
//		logger.info(pag.toString());
//		
//		model.addAttribute("list", auctionservice.listAuctionPageMaker(pag));
//		AuctionPageMaker auctionpageMaker = new AuctionPageMaker();
//		auctionpageMaker.setPag(pag);
//		
//	}

}



