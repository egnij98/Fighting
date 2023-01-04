package kr.co.wonder.member;

import java.util.List;
import java.util.Map;

public interface MemberService {

	//회원가입
		public int addmember(MemberDTO memberDTO) throws Exception;
		
	//아이디 중복체크
		public String idcheck(String mem_id) throws Exception;
			
	// 로그인 처리
		public MemberDTO login(MemberDTO memberDTO) throws Exception;
//		public Map<String,Object> login(Map<String,Object>map) throws Exception;
		
	// 아이디 찾기
		public String idfind(Map<String,Object> map) throws Exception;
	// 아이디 찾기 유효성
		public int idfindcheck(MemberDTO memberDTO) throws Exception;
	
	//비밀번호 찾기
		public int pwsfind(Map<String,Object> map) throws Exception;
		
	// 비밀번호 변경
		public int pwupdate(MemberDTO memberDTO) throws Exception;
	
	// 마이페이지
		public MemberDTO mypage(String id) throws Exception;
	
	// 프로필 수정
		public int profileUpdate(MemberDTO memberDTO) throws Exception;
		
//	//회원탈퇴 비밀번호체크
//		public String pwCheck(String id) throws Exception;
		
	// 회원 탈퇴
		public int memberDelete(MemberDTO memberDTO) throws Exception;
		
		//캐쉬 충전
		public int charge(MemberDTO memberDTO) throws Exception;
		
		//캐쉬충전 내역
		public List<MemberDTO> chargelist(String mem_id) throws Exception;
		
		//캐쉬 출금
		public int withdraw(MemberDTO memberDTO) throws Exception;
		
		//캐쉬출금 내역
		public List<MemberDTO> drawlist(String mem_id) throws Exception;
		
		//회원 검색
		public MemberDTO serchMember(String mem_id) throws Exception;
}
