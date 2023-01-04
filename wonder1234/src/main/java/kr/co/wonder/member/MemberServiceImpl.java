package kr.co.wonder.member;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.naming.ldap.ManageReferralControl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	private SqlSessionTemplate userSqlSessin;
	// 회원가입
	@Override
	public int addmember(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.addmember(memberDTO);
	}
	//아이디 중복체크
	@Override
	public String idcheck(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		
		return dao.idcheck(mem_id);
	}
	// 로그인 처리
	
	@Override
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		
		return dao.login(memberDTO);
	}

	
	//아이디 찾기
	
	@Override
	public String idfind(Map<String,Object> map) throws Exception {
		// TODO Auto-generated method stub
		return dao.idfind(map);
	}
	//아이디 찾기 유효성
	@Override
	public int idfindcheck(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.idfindcheck(memberDTO);
	}
	
	//비밀번호 찾기 및 변경
	@Override
	public int pwsfind(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return dao.pwsfind(map);
	}
	// 비밀번호 수정
	@Override
	public int pwupdate(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.pwupdate(memberDTO);
	}
	
	//마이페이지
	@Override
	public MemberDTO mypage(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.mypage(id);
	}
	
	// 프로필 수정
	@Override
	public int profileUpdate(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.profileUpdate(memberDTO);
	}
	

	
	//회원탈퇴
	@Override
	public int memberDelete(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberDelete(memberDTO);
	}
	
	//캐쉬 충전
	@Override
	public int charge(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.charge(memberDTO);
	}
	
	//캐쉬충전내역
	@Override
	public List<MemberDTO> chargelist(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.chargelist(mem_id);
	}
	
	
	@Override
	public MemberDTO serchMember(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.serchMember(mem_id);
	}
	
	//캐쉬 출금
	@Override
	public int withdraw(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.withdraw(memberDTO);
	}
	
	//캐쉬출금내역
	@Override
	public List<MemberDTO> drawlist(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.drawlist(mem_id);
	}
	
	

	
	



}
