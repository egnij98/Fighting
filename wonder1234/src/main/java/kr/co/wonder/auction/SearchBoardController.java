package kr.co.wonder.auction;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class SearchBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
	
	@Inject
	private AuctionService auctionservice;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void auctionproductdetail(@ModelAttribute("pag") SearchCriteria cri, Model model) throws Exception{
		
		logger.info(cri.toString());
		
		model.addAttribute("list", auctionservice.listAuctionPageMaker(cri));
		
		AuctionPageMaker auctionPageMaker = new AuctionPageMaker();
		auctionPageMaker.setPag(cri);
		
		auctionPageMaker.setTotalCount(auctionservice.contPaging(cri));
		
		model.addAttribute("auctionPageMaker", auctionPageMaker);
	}

}
