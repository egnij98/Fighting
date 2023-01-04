package kr.co.wonder.mypage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.cj.log.Log;

import kr.co.wonder.HomeController;
import kr.co.wonder.member.MemberDTO;
import kr.co.wonder.member.MemberService;
import kr.co.wonder.product.CartDTO;
import kr.co.wonder.product.ProductDTO;


@Controller
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	MypageService mservice;
	@Autowired
	MemberService service;
	
	//프로필 수정 폼
	@RequestMapping (value = "mypage/profileUpdateView", method=RequestMethod.GET)
 	public String profileUpdateView() throws Exception {
		
		
	return "mypage/profileUpdateView";
	}
	
	//프로필 수정
	@RequestMapping(value="mypage/profileUpdate", method=RequestMethod.POST)
	public String profileUpdate(MemberDTO memberDTO, HttpSession session,HttpServletRequest request) throws Exception{
		logger.info("수정내용"+memberDTO);
		int r = service.profileUpdate(memberDTO);
		 session.invalidate();
		logger.info("변경"+r);
			return "redirect:/";
	}
	
	//회원탈퇴 뷰
	@RequestMapping(value="mypage/deleteView", method=RequestMethod.GET)
	public String deleteView()throws Exception{
		
		return "mypage/deleteView";
	}
	
	//회원탈퇴
	@RequestMapping(value="memberDelete", method=RequestMethod.POST)
	public String memberDelete(MemberDTO memberDTO, RedirectAttributes rttr, HttpSession session)throws Exception{
			
		MemberDTO user = (MemberDTO) session.getAttribute("user");
		
		String sessionPass = user.getMem_password();
		
		String DTOpass= memberDTO.getMem_password();
		
		if(!(sessionPass.equals(DTOpass))) {
			logger.info("안됨");
			rttr.addAttribute("msg", false);
			return "redirect:deleteView";
		}
		
		service.memberDelete(memberDTO);
		session.invalidate();
		logger.info("회원탈퇴완료");
		rttr.addAttribute("msg","그동안 이용해주셔서 감사합니다.");
		return "redirect:/";
	}
	
	//캐쉬충전 뷰
		@RequestMapping(value="mypage/cashChargeView", method=RequestMethod.GET)
		public String cashCharge()throws Exception{
			
			return "mypage/cashChargeView";
		}
	
	//캐쉬충전
		
		@RequestMapping(value="mypage/charge",method=RequestMethod.POST)
		public String charge(MemberDTO memberDTO,HttpSession session) throws Exception{
			MemberDTO user = (MemberDTO) session.getAttribute("user");
			memberDTO.setMem_id(user.getMem_id());
			int r = service.charge(memberDTO);
			logger.info(""+memberDTO);
			return "mypage/mypage";
		}
			
	//캐쉬충전 내역
		@ResponseBody
		@RequestMapping(value="mypage/chargelist",method=RequestMethod.POST)
		public List<MemberDTO> chargelist(MemberDTO memberDTO,HttpSession session) throws Exception{
			MemberDTO user=(MemberDTO) session.getAttribute("user");
			memberDTO.setMem_id(user.getMem_id());
			logger.info("내역"+service.chargelist(memberDTO.getMem_id()));
			
			return service.chargelist(memberDTO.getMem_id());
		}
		
		//캐쉬출금 뷰
				@RequestMapping(value="mypage/cashWithdrawView", method=RequestMethod.GET)
				public String cashWithdraw()throws Exception{
					
					return "mypage/cashWithdrawView";
				}
		
		//캐쉬출금
		
				@RequestMapping(value="mypage/withdraw",method=RequestMethod.POST)
				public String withdraw(MemberDTO memberDTO,HttpSession session) throws Exception{
					MemberDTO user = (MemberDTO) session.getAttribute("user");
					memberDTO.setMem_id(user.getMem_id());
				
					
					int r = service.withdraw(memberDTO);
					logger.info(""+memberDTO);
//					if(r < 0) {
//						logger.info("출금할 캐쉬가 부족합니다");
//						return "mypage/cashWithdrawView";
//					}
				
					return "mypage/mypage";
				}
					
			//캐쉬출금 내역
				@ResponseBody
				@RequestMapping(value="mypage/drawlist",method=RequestMethod.POST)
				public List<MemberDTO> drawlist(MemberDTO memberDTO,HttpSession session) throws Exception{
					MemberDTO user=(MemberDTO) session.getAttribute("user");
					memberDTO.setMem_id(user.getMem_id());
					logger.info("내역"+service.drawlist(memberDTO.getMem_id()));
					
					return service.drawlist(memberDTO.getMem_id());
				}
			
				@GetMapping(value = "product/wishlistinsert")
				public String whishlistInsert(wishlistDTO wishlistdto,@RequestParam("product_name") String product_name,@RequestParam("product_cate") String product_cate, HttpSession session, Model model) {
					//String member_id = session.getAttribute("member_id")
					String member_id = "1234";
						wishlistdto.setMem_id(member_id);
						wishlistdto.setProduct_name(product_name);
						wishlistdto.setWish_id(0);
						wishlistDTO wishlist = mservice.getByCnoWithUserid(wishlistdto);
						System.out.println(wishlistdto);
						int result=0;
						if(wishlist==null) {
						mservice.insert(wishlistdto);
						result=1;
						}
						System.out.println("추가안함");
						model.addAttribute("result", result);
						System.out.println(result);

					return "redirect:productdetail?product_name="+product_name+"&"+"product_cate="+product_cate;
				}
				@RequestMapping(value = "mypage/cart")
				public ModelAndView cart(CartDTO cartdto, HttpSession sess) {
					//String mem_id =(String) sess.getAttribute("mem_id");
					String mem_id = "1234";
					ModelAndView mav = new ModelAndView();
					List<CartDTO> cart =mservice.selectShoppingBasket(mem_id);
					List<ProductDTO> selectCart= new ArrayList<ProductDTO>();
					for(int i = 0; i<cart.size(); i++) {
						String cartpr = cart.get(i).getProduct_id();
						System.out.println(cartpr);
						ProductDTO pr =mservice.selectCart(cartpr);	
						selectCart.add(pr);
					}
					System.out.println(cart);
					mav.addObject("cart", cart);
					mav.addObject("selectCart", selectCart);
					mav.setViewName("mypage/cart");
					
					return mav;
				}
				@ResponseBody
				@PostMapping(value = "mypage/cart/delectCart")
				public String deleteCart(HttpSession session,
					     @RequestParam(value = "chbox[]") List<String> chArr, CartDTO cart) throws Exception {
					 
					 //String mem_id = session.getAttribute("mem_id");
					 //String userId = member.getmem_Id();
					String mem_id = "1234";
					
					 int result = 0;
					 int cartNum = 0;
					 
					 if(mem_id != null) {
					  cart.setMem_id(mem_id);
					  
					  for(String i : chArr) {   
					   cartNum = Integer.parseInt(i);
					   cart.setCart_id(cartNum);
					   mservice.delectCart(cart);
					  }   
					  result = 1;
					 }  
					 return "redirect:mypage/cart";  
					}
				@RequestMapping(value = "mypage/wishlist")
				public ModelAndView wishlist(wishlistDTO wishlistdto, HttpSession sess) {
					//String mem_id =(String) session.getAttribute("mem_id");
					String mem_id = "1234";
					ModelAndView mav = new ModelAndView();
					List<wishlistDTO> wishlist =mservice.getLikeListByUserid(mem_id);
					List<ProductDTO> selectCart= new ArrayList<ProductDTO>();
					for(int i = 0; i<wishlist.size(); i++) {
						String wishlistpr = wishlist.get(i).getProduct_name();
						System.out.println(wishlistpr);
						ProductDTO pr =mservice.selectCart(wishlistpr);	
						selectCart.add(pr);
					}
					mav.addObject("cart", wishlist);
					mav.addObject("selectCart", selectCart);
					mav.setViewName("mypage/wishlist");
					
					return mav;
				}
				@ResponseBody
				@PostMapping(value = "mypage/wishlist/delectwishlist")
				public String deleteWishlist(HttpSession session,
					     @RequestParam(value = "chbox[]") List<String> chArr, wishlistDTO wishlist) throws Exception {
					 
					 //String mem_id = session.getAttribute("mem_id");
					 //String userId = member.getmem_Id();
					String mem_id = "1234";
					
					 int result = 0;
					 int wish_id = 0;
					 
					 if(mem_id != null) {
						 wishlist.setMem_id(mem_id);
					  
					  for(String i : chArr) {   
					   wish_id = Integer.parseInt(i);
					   wishlist.setWish_id(wish_id);
					   mservice.deleteWishList(wishlist);
					  }   
					  result = 1;
					 }  
					 return "redirect:mypage/wishlist";  
					}
				
				@RequestMapping(value = "mypage/buyofgoods")
				public ModelAndView buyofGoods(BuyofGoodsDTO buyofgoodsdto, HttpSession sess) {
					//String mem_id =(String) session.getAttribute("mem_id");
					String mem_id = "1234";
					ModelAndView mav = new ModelAndView();
					List<BuyofGoodsDTO> buy =mservice.buyofGoods(mem_id);
					List<ProductDTO> selectCart= new ArrayList<ProductDTO>();
					for(int i = 0; i<buy.size(); i++) {
						String buyofgoods = buy.get(i).getProduct_name();
						System.out.println("구매내역 들옴");
						System.out.println(buyofgoodsdto);
						ProductDTO pr =mservice.selectCart(buyofgoods);	
						selectCart.add(pr);
					}
					mav.addObject("cart", buy);
					mav.addObject("selectCart", selectCart);
					mav.setViewName("mypage/buyofgoods");
					
					return mav;
				}
				@ResponseBody
				@PostMapping(value = "mypage/buyofgoods/delbuyhistory")
				public String delbuyhistory(HttpSession session,
					     @RequestParam(value = "chbox[]") List<String> chArr, BuyofGoodsDTO buyofgoodsdto) throws Exception {
					 
					 //String mem_id = session.getAttribute("mem_id");
					 //String userId = member.getmem_Id();
					String mem_id = "1234";
					
					 
					 if(mem_id != null) {
						 buyofgoodsdto.setMem_id(mem_id);
					  
					  for(String i : chArr) { 
						  buyofgoodsdto.setProduct_name(i);
						  mservice.delbuyHistory(buyofgoodsdto);
						  mservice.updatebuyHistory2(buyofgoodsdto);
					  }   
					 }  
					 return "redirect:mypage/saleofgoods";  
					}
				@RequestMapping(value = "mypage/saleofgoods")
				public ModelAndView saleofGoods(SaleofGoodsDTO saleofGoodsdto, HttpSession sess) {
					//String mem_id =(String) session.getAttribute("mem_id");
					String mem_id = "1234";
					ModelAndView mav = new ModelAndView();
					List<SaleofGoodsDTO> sale =mservice.saleofGoods(mem_id);
					List<ProductDTO> selectSale= new ArrayList<ProductDTO>();

					selectSale =mservice.SalesCompleted(mem_id);

					mav.addObject("cart", sale);
					mav.addObject("selectCart", selectSale);
					mav.setViewName("mypage/saleofgoods");
					
					return mav;
				}
				@ResponseBody
				@PostMapping(value = "mypage/saleofgoods/delsalehistory")
				public String delsalehistory(HttpSession session,
					     @RequestParam(value = "chbox[]") List<String> chArr, SaleofGoodsDTO saleofGoodsdto) throws Exception {
					 
					 //String mem_id = session.getAttribute("mem_id");
					 //String userId = member.getmem_Id();
					String mem_id = "1234";
					
					 int result = 0;
					 
					 if(mem_id != null) {
						 saleofGoodsdto.setMem_id(mem_id);
					  
					  for(String i : chArr) { 
						  saleofGoodsdto.setProduct_name(i);
						  mservice.delsaleofGoods(saleofGoodsdto);
						  mservice.delsaleofGoods2(saleofGoodsdto);
					  }   
					  result = 1;
					 }  
					 return "redirect:mypage/saleofgoods";  
					}
				@GetMapping(value = "mypage/buyselect")
				public String saleinsert(HttpSession session,Model model) throws Exception {
					//String mem_id =(String) session.getAttribute("mem_id");
					String mem_id = "1234";
					List<ProductDTO> product = mservice.buyselect(mem_id);
					System.out.println(product);
					model.addAttribute("product", product);
					
					
				
					return "mypage/buyselect";
				}
				@RequestMapping(value = "mypage/buyselect")
				public ModelAndView buyselect(HttpSession session) throws Exception {
					//String mem_id =(String) session.getAttribute("mem_id");
					String mem_id = "1234";
					ModelAndView mav = new ModelAndView();
					List<ProductDTO> product = mservice.buyselect(mem_id);
					mav.addObject("product", product);
					mav.setViewName("mypage/buyselect");
					
					return mav;
				}
				@ResponseBody
				@PostMapping(value = "mypage/buyselect/buydel")
				public String buydel(HttpSession session,
					     @RequestParam(value = "chbox[]") List<String> chArr, ProductDTO productdto) throws Exception {
					 System.out.println("삭제 들어옴");
					 //String mem_id = session.getAttribute("mem_id");
					 //String userId = member.getmem_Id();
					String mem_id = "1234";
					 if(mem_id != null) {
						 productdto.setMem_id(mem_id);
					  for(String i : chArr) {   
					   productdto.setProduct_id(i);
					   mservice.buydel(productdto);
					  }   
					 } 
					 return "redirect:/";  
					}
				
				@RequestMapping(value = "mypage/saleselect")
				public ModelAndView saleselect1(HttpSession session) throws Exception {
					//String mem_id =(String) session.getAttribute("mem_id");
					String mem_id = "1234";
					ModelAndView mav = new ModelAndView();
					List<ProductDTO> product = mservice.saleselect(mem_id);
					mav.addObject("product", product);
					mav.setViewName("mypage/saleselect");
					
					return mav;
				}
				@ResponseBody
				@PostMapping(value = "mypage/saleselect/saledel")
				public String saledel1(HttpSession session,
					     @RequestParam(value = "chbox[]") List<String> chArr, ProductDTO productdto) throws Exception {
					 System.out.println("삭제 들어옴");
					 //String mem_id = session.getAttribute("mem_id");
					 //String userId = member.getmem_Id();
					String mem_id = "1234";
					 if(mem_id != null) {
						 productdto.setMem_id(mem_id);
					  for(String i : chArr) {   
					   productdto.setProduct_id(i);
					   mservice.saledel(productdto);
					  }   
					 } 
					 return "redirect:/";  
					}

				

	
}
	

