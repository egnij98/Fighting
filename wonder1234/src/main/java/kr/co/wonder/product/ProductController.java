package kr.co.wonder.product;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

import com.mysql.cj.log.Log;

import kr.co.wonder.member.MemberDTO;
import kr.co.wonder.member.MemberService;
import kr.co.wonder.mypage.MypageService;
import kr.co.wonder.mypage.OrderHistoryDTO;
import kr.co.wonder.mypage.wishlistDTO;


@Controller
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@Autowired
	MemberService memservice;
	
	
	
	
	@GetMapping(value = "product/productdetail")
	public String productdetail(@RequestParam("product_name") String product_name,@RequestParam("product_cate") String product_cate,Model model) throws Exception {
		ProductDTO dto = pservice.productSelectDeail2(product_name);
		ProductDTO price = pservice.immediatesale(dto);
		List<ProductDTO> prcate = pservice.productSimila(product_cate);
		if(price!=null ) {
			if(price.getProduct_code().equals("판매완료")) {
				price.setProduct_price("0");
				model.addAttribute("price", price);
			}else {
				model.addAttribute("price", price);
			}	
		}else {
			price.setProduct_code("판매중");
			model.addAttribute("price", price);
		}
		model.addAttribute("cate", prcate);
		model.addAttribute("dto", dto);
		return "product/productdetail";
	}
	
	
	@PostMapping(value = "/product/insertcart")
	public String addCart(@ModelAttribute CartDTO cartdto, HttpSession session,HttpServletRequest htp,Model model) throws Exception {
		//String member_id = (String) session.getAttribute("member_id");
		String member_id = "1234";
		int cart= 0;
		String product_id = cartdto.getProduct_id();
		String product_cate = htp.getParameter("product_cate");
		cartdto.setMem_id(member_id);
		cartdto.setProduct_id(product_id);
		cartdto.setCart_count((Integer.parseInt(htp.getParameter("amount"))));
		cartdto.setCart_id(0);
		
		int count = pservice.countCart(product_id,member_id);
		
		if(count >0 ) {
			pservice.updateCart(cartdto);
			cart=1;
			model.addAttribute("cart", cart);
		}else {
			pservice.addCart(cartdto);
			cart=2;
			model.addAttribute("cart", cart);
		}
			
		return "redirect:product/productdetail?product_id=" + product_id+"&"+ "product_cate="+product_cate;
	}
	@GetMapping(value = "product/paymentmove")
	public ModelAndView paymentMove(@RequestParam("product_name") String product_name,@RequestParam("price") String product_price) throws Exception {
		ModelAndView mav = new ModelAndView();
		ProductDTO product = pservice.productSelectDeail2(product_name);
		//String member_id = (String) session.getAttribute("member_id");
		String member_id = "1234";
		MemberDTO member = memservice.serchMember(member_id);
		System.out.println(member);
		mav.addObject("member", member);
		mav.addObject("product", product);
		mav.addObject("price", product_price);
		mav.setViewName("product/paymentmove");
		return mav;

	}
	@PostMapping(value = "/product/paymentmove")
	public String paymentMove(OrderDTO orderdto) throws Exception {

		pservice.paymentMove(orderdto);
		pservice.saleupdate(orderdto.getProduct_id());

		OrderHistoryDTO orderhis = new OrderHistoryDTO();
		orderhis.setMem_id(orderdto.getMem_id());
		orderhis.setProduct_id(orderdto.getProduct_id());
		orderhis.setOrder_id(orderdto.getOrder_id());
		pservice.orderhistoryinsert(orderhis);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/mypage")
	public ModelAndView mypage(HttpSession sess) {
		String mem_id =(String) sess.getAttribute("mem_id");
		ModelAndView mav = new ModelAndView();
		mav.addObject("mem_id", mem_id);
		mav.setViewName("mypage/mypage");
		return mav;
	}
	@RequestMapping(value = "product/order")
	public ModelAndView order(HttpSession sess, ProductDTO productdto) throws Exception {
		ModelAndView mav = new ModelAndView();
		//String mem_id =(String) sess.getAttribute("mem_id");
		String mem_id = "1234";
		MemberDTO member = memservice.serchMember(mem_id);
		System.out.println(productdto);
		ProductDTO detail =pservice.productSelectDeail2(productdto.getProduct_name());
		List<ProductDTO> product = new ArrayList<ProductDTO>();
		ProductDTO pr =new ProductDTO();
		
		if(productdto.getProduct_cate().equals("신발")) {
			for(int i = 230; i<=290;) {
				productdto.setProduct_name(detail.getProduct_name());
				productdto.setProduct_size(String.valueOf(i));
				pr = pservice.sizeBy(productdto);
				if(pr==null) {
					
					ProductDTO pr2 =new ProductDTO();
					pr2.setProduct_name(detail.getProduct_name());
					pr2.setProduct_size(String.valueOf(i));
					pr2.setProduct_price("구매입찰");
					product.add(pr2);
				}else {
					product.add(pr);
				}
				i+=10;
			}
		}else if(productdto.getProduct_cate().equals("상의")) {
			for(int i = 0; i<4;i++) {
				String size=null;
				switch (i) {
				case 0:
					size="S";
					break;
				case 1:
					size="M";
					break;
				case 2:
					size="L";
					break;
	
				case 3:
					size="XL";
					break;
				}
				productdto.setProduct_name(detail.getProduct_name());
				productdto.setProduct_size(size);
				pr = pservice.sizeBy(productdto);
				if(pr==null) {
					
					ProductDTO pr2 =new ProductDTO();
					pr2.setProduct_name(detail.getProduct_name());
					pr2.setProduct_size(size);
					pr2.setProduct_price("구매입찰");
					product.add(pr2);
					
				}else {
					product.add(pr);
				}
			}
		}else if((productdto.getProduct_cate().equals("하의"))) {
			for(int i = 27; i<34;i++) {
				productdto.setProduct_size(String.valueOf(i));
				pr = pservice.sizeBy(productdto);
				productdto.setProduct_name(detail.getProduct_name());
				if(pr==null) {
					ProductDTO pr2 =new ProductDTO();
					pr2.setProduct_name(detail.getProduct_name());
					pr2.setProduct_size(String.valueOf(i));
					pr2.setProduct_price("구매입찰");
					product.add(pr2);
				}else {
					product.add(pr);
				}
			}
			
		}
		mav.addObject("sizebuy",product );
		mav.addObject("product", detail);
		mav.setViewName("product/order");
		return mav;
	}
	
	@GetMapping(value = "product/purchasebid")
	public ModelAndView purchasebid1(@RequestParam("product_name") String product_name,@RequestParam("product_size") String product_size) throws Exception {
		ModelAndView mav = new ModelAndView();

		ProductDTO product = pservice.productSelectDeail2(product_name);
		product.setProduct_size(product_size);
		
		//String member_id = (String) session.getAttribute("member_id");
		String member_id = "1234";
		MemberDTO member = memservice.serchMember(member_id);
		mav.addObject("member", member);
		mav.addObject("product", product);

		mav.setViewName("product/purchasebid");
		return mav;

	}
	@PostMapping(value = "product/purchasebid")
	public String purchasebid(ProductDTO productdto) throws Exception {

		pservice.purchasebid(productdto);
		
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "product/sale")
	public ModelAndView sale(HttpSession sess, ProductDTO productdto) throws Exception {
		ModelAndView mav = new ModelAndView();
		//String mem_id =(String) sess.getAttribute("mem_id");
		String mem_id = "1234";
		MemberDTO member = memservice.serchMember(mem_id);

		ProductDTO detail =pservice.productSelectDeail2(productdto.getProduct_name());
		List<ProductDTO> product = new ArrayList<ProductDTO>();
		ProductDTO pr =new ProductDTO();
		
		if(productdto.getProduct_cate().equals("신발")) {
			for(int i = 230; i<=290;) {
				productdto.setProduct_name(detail.getProduct_name());
				productdto.setProduct_size(String.valueOf(i));
				pr = pservice.immediatesale2(productdto);
				if(pr==null) {
					ProductDTO pr2 =new ProductDTO();
					pr2.setProduct_name(detail.getProduct_name());
					pr2.setProduct_size(String.valueOf(i));
					pr2.setProduct_price("판매입찰");
					product.add(pr2);
				}else {
					product.add(pr);
				}
				i+=10;
			}
		}else if(productdto.getProduct_cate().equals("상의")) {
			for(int i = 0; i<4;i++) {
				String size=null;
				switch (i) {
				case 0:
					size="S";
					break;
				case 1:
					size="M";
					break;
				case 2:
					size="L";
					break;
	
				case 3:
					size="XL";
					break;
				}
				productdto.setProduct_name(detail.getProduct_name());
				productdto.setProduct_size(size);
				productdto.setProduct_code("구매예약");
				pr = pservice.immediatesale2(productdto);
				if(pr==null) {
					ProductDTO pr2 =new ProductDTO();
					pr2.setProduct_name(detail.getProduct_name());
					pr2.setProduct_size(size);
					pr2.setProduct_price("판매입찰");
					product.add(pr2);
				}else {
					product.add(pr);
				}
			}
		}else if((productdto.getProduct_cate().equals("하의"))) {
			for(int i = 27; i<34;i++) {
				productdto.setProduct_name(detail.getProduct_name());
				productdto.setProduct_size(String.valueOf(i));
				pr = pservice.immediatesale2(productdto);
				if(pr==null) {
					
					ProductDTO pr2 =new ProductDTO();
					pr2.setProduct_name(detail.getProduct_name());
					pr2.setProduct_size(String.valueOf(i));
					pr2.setProduct_price("판매입찰");
					product.add(pr2);
				}else {
					product.add(pr);
				}
			}
			
		}
		
				mav.addObject("sizebuy",product );
				mav.addObject("product", detail);
				mav.setViewName("product/sale");
				return mav;
	}
	
	@GetMapping(value = "product/saleinsert")
	public ModelAndView saleinsert(@RequestParam("product_name") String product_name,@RequestParam("product_size") String product_size,@RequestParam("price") String product_price) throws Exception {
		ModelAndView mav = new ModelAndView();
		ProductDTO product = pservice.productSelectDeail2(product_name);
		//String member_id = (String) session.getAttribute("member_id");
		String member_id = "1234";
		MemberDTO member = memservice.serchMember(member_id);
		mav.addObject("member", member);
		mav.addObject("product", product);
		mav.addObject("size",product_size);
		mav.addObject("price",product_price);
		mav.setViewName("product/saleinsert");
		return mav;

	}
	@ResponseBody
	@PostMapping(value = "product/saleinsert")
	public String saleinsert(ProductDTO productdto, HttpServletRequest hsr,String price) throws Exception {
		System.out.println("asdasd");
		System.out.println(price);
		System.out.println(productdto.getProduct_name());
		System.out.println(productdto);
		//jsp->컨트롤러 로 넘어올때 한글이 깨지면서 넘어옴 수정해야댐
		productdto.setProduct_price(price);
		//product테이블에 판매입찰 추가
		pservice.purchasebid2(productdto);
		
		return price;
	}
	@GetMapping(value = "product/buyinsert")
	public ModelAndView buyinsert(@RequestParam("product_name") String product_name,@RequestParam("product_size") String product_size,@RequestParam("price") String product_price) throws Exception {
		ModelAndView mav = new ModelAndView();
		ProductDTO product = pservice.productSelectDeail2(product_name);
		//String member_id = (String) session.getAttribute("member_id");
		String member_id = "1234";
		MemberDTO member = memservice.serchMember(member_id);
		mav.addObject("member", member);
		mav.addObject("product", product);
		mav.addObject("size",product_size);
		mav.addObject("price",product_price);
		mav.setViewName("product/buyinsert");
		return mav;

	}
	@ResponseBody
	@PostMapping(value = "product/buyinsert")
	public String buyinsert(ProductDTO productdto, HttpServletRequest hsr,String price) throws Exception {
		System.out.println("asdasd");
		System.out.println(price);
		System.out.println(productdto.getProduct_name());
		System.out.println(productdto);
		//jsp->컨트롤러 로 넘어올때 한글이 깨지면서 넘어옴 수정해야댐
		productdto.setProduct_price(price);
		//product테이블에 판매입찰 추가
		pservice.purchasebid2(productdto);
		
		return price;
	}
	
}
	
	
	


	

