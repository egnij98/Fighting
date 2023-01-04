package kr.co.wonder.member;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.wonder.HomeController;

import kr.co.wonder.member.MemberDTO;
import kr.co.wonder.member.MemberService;


@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	MemberService service;
	
	
	 
	//회원가입 페이지
	@RequestMapping (value ="member/addMember", method=RequestMethod.GET)
	public String addmember(MemberDTO memberDTO) throws Exception{
		logger.info("addmember");
	
	return "member/addMember";
	} //end
	
	
	
	// 회원가입 DB저장
	@RequestMapping(value="member/addMember2", method = RequestMethod.POST)
	public String addMem(MemberDTO memberDTO) throws Exception {
		logger.info("memberDTO="+memberDTO);
		ModelAndView mav = new ModelAndView();
		
		//service 회원추가 메소드
		 int r= service.addmember(memberDTO);
		
		return "member/login";
	}
		
	// 아이디 중복체크
	@ResponseBody
	@RequestMapping(value = "idCheck",method = RequestMethod.GET)
		public String idcheck(@RequestParam("mem_id") String mem_id) throws Exception{
	logger.info("msg : " + mem_id);
	
	return service.idcheck(mem_id);
}
		
	//로그인

	@RequestMapping (value = "member/login", method=RequestMethod.GET)
			public String login() {
			
			return "member/login";
	}
	
	@RequestMapping(value = "member/loginProc", method=RequestMethod.POST)
		public String login(MemberDTO memberDTO, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		request.setCharacterEncoding("utf-8");
		logger.info("post login");
		
		HttpSession session = request.getSession();
		
		MemberDTO user = service.login(memberDTO);
		logger.info("data : " + user);
		if(user == null) {
			
			rttr.addFlashAttribute("msg", "아이디 또는 비밀번호를 확인해주세요");
			return "redirect:login";
		}else if(user.getMem_rating() != 99 ){
			session.setAttribute("user", user);
			return "redirect:/";
		}else if(user.getMem_rating() == 99){
			return "redirect:/admin/adminhome";
		}
		
		return "redirect:/";
	}
		
	

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		session.invalidate();
		logger.info("로그아웃되었습니다");
		
		return "redirect:/";
		
	}
	
	// 아이디찾기 폼
	@RequestMapping(value = "member/idfindView", method=RequestMethod.GET)
		public String idfindView() throws Exception{
			logger.info("아이디찾기");
			return "member/idfindView";
	}
	
	// 아이디찾기
	@RequestMapping (value = "member/idfind", method=RequestMethod.POST)
		 	public ModelAndView idfind(@RequestParam("mem_name")String mem_name,@RequestParam("mem_phonenum")int mem_phonenum, Map<String,Object> map, 
		 			Model model, HttpServletRequest request ) throws Exception {
				request.setCharacterEncoding("utf-8");
				logger.info("mem_name,"+"mem_phonenum"+mem_name+mem_phonenum);
					map.put("mem_name", mem_name);
					map.put("mem_phonenum", mem_phonenum);
				ModelAndView mav = new ModelAndView();
				String id= service.idfind(map);
				mav.setViewName("member/idfind");
				mav.addObject("id", id);
				
					
					logger.info("id="+service.idfind(map));
					return mav;
					} // end of idfind
					
		// 비밀번호 찾기 폼
	@RequestMapping(value = "member/pwsFindView", method=RequestMethod.GET)
	public String pwsFindView() throws Exception{
		logger.info("비밀번호찾기");
		return "member/pwsFindView";
	}
		
	// 비밀번호 수정
	@RequestMapping(value="member/pwsfind", method=RequestMethod.POST)
		public String pwsfind(@RequestParam("mem_id")String mem_id,@RequestParam("mem_hint1")String mem_hint1,Map<String,Object>map,Model model,
				@RequestParam("mem_hint2") String mem_hint2) throws Exception{
				logger.info(mem_id+mem_hint1+mem_hint2);
				map.put("mem_id", mem_id);
				map.put("mem_hint1", mem_hint1);
				map.put("mem_hint2", mem_hint2);
				
				int r = service.pwsfind(map);
				if(r==0) {
					model.addAttribute("msg", "아이디또는 힌트를 확인해주세요");
					
					return "member/pwsFindView";	
				} 
				model.addAttribute("map",map);
				logger.info(""+map);
				return "member/pwupdate";
		
	}
		// 비밀번호 저장
		@RequestMapping(value="member/pwupdate", method = RequestMethod.POST)
		public String pwupdate(@RequestParam("mem_id")String mem_id, @RequestParam("mem_password")String mem_password, MemberDTO memberDTO,HttpSession session,
			RedirectAttributes rttr, HttpServletRequest request)throws Exception{
			request.setCharacterEncoding("utf-8");
			
			memberDTO.setMem_id(mem_id);
			memberDTO.setMem_password(mem_password);
			int r=service.pwupdate(memberDTO);
			
			logger.info(""+mem_id+mem_password);
			session.invalidate();
			rttr.addFlashAttribute("result", "updateOK");
			return "member/login";
//			int r = service.pwupdate(memberDTO);
//			if (r == 0) {
//				rttr.addFlashAttribute("msg", "수정 성공");
//				logger.info("성공");
//				return "login";
//				
//			}else {
//				
//				return "redirect:pwsFindView";
//			}
			
		}
	
		//마이페이지 프로필 보기
		@RequestMapping(value="mypage/mypage", method=RequestMethod.GET)
		public String mypage(MemberDTO memberDTO, Model model,HttpSession session) throws Exception{
			logger.info("진입");
			String id= (String) session.getAttribute("mem_id");
			MemberDTO user = service.mypage(id);
			model.addAttribute("user", service.mypage(id));
			
			
			
			return "mypage/mypage";
		}
		

	


}
