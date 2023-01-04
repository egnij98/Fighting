package kr.co.wonder.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired
  private SqlSession sqlsession;
	private static final String namespace="kr.co.wonder.memberMapper";
	
	//회원가입
	@Override
	public int addmember(MemberDTO memberDTO) throws Exception {
	
			return sqlsession.insert(namespace+".addmember", memberDTO);
		
		
	}
	//아이디 중복 체크

	@Override
	public String idcheck(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace+".idcheck", mem_id);
	}

	// 로그인 처리
	
	@Override
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		
		return sqlsession.selectOne(namespace+".login", memberDTO);
	}
//	@Override
//	public Map<String,Object> login(Map<String,Object> map) throws Exception {
//		// TODO Auto-generated method stub
//		return sqlsession.selectOne(namespace+".login", map);
//	}

	// 아이디 찾기

	@Override
	public String idfind(Map<String,Object> map) throws Exception {
		// TODO Auto-generated method stub

		return sqlsession.selectOne(namespace+".idfind", map);
	}
	// 아이디 찾기 유효성검사
	@Override
	public int idfindcheck(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlsession.selectOne(namespace+".idfindcheck", memberDTO);
	}

	// 비밀번호 찾기
	@Override
	public int pwsfind(Map<String,Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace+".pwfind", map);
	}
	// 비밀번호 수정
	@Override
	public int pwupdate(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace+".pwupdate", memberDTO);
	}
	// 마이페이지
	@Override
	public MemberDTO mypage(String id) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace+".mypage", id);
	}
	// 프로필 수정
	@Override
	public int profileUpdate(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace+".profileUpdate", memberDTO);
	}

//	//회원탈퇴 비밀번호체크
//	@Override
//	public String pwCheck(String id) throws Exception {
//		// TODO Auto-generated method stub
//		return sqlsession.selectOne(namespace+".pwCheck", id);
//	}
	// 회원탈퇴
	@Override
	public int memberDelete(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.delete(namespace+".memberDelete", memberDTO);
	}

	// 캐쉬충전
	@Override
	public int charge(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace+".charge", memberDTO);
	}
	// 캐쉬충전 내역
	@Override
	public List<MemberDTO> chargelist(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".chargelist",mem_id);
	}

	@Override
	public MemberDTO serchMember(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace+".serchmember", mem_id);
	}

	// 캐쉬출금 
	@Override
	public int withdraw(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace+".withdraw", memberDTO);
	}
	// 캐쉬출금 내역
	@Override
	public List<MemberDTO> drawlist(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".drawlist", mem_id);
	}

	
	
	
	

	

	
	
	
	

	
	

}
