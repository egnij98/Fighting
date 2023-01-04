package kr.co.wonder.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import kr.co.wonder.member.MemberDTO;

@Repository
public class AdminDAOImpl implements AdminDAO{
	@Autowired
	private SqlSession sqlSession;
	
	static final String namespace = "kr.co.wonder.AdminMapper";

	@Override
	public int productAdd(AdminProductDTO adminProductDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".productadd", adminProductDTO);
	}

	@Override
	public List<AdminProductDTO> productList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".productlist");
	}

	@Override
	public AdminProductDTO productDetail(int product_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".productdetail", product_id);
	}

	@Override
	public int productEdit(AdminProductDTO adminProductDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".productedit", adminProductDTO);
	}

	@Override
	public int productDelete(int product_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+".productdelete", product_id);
	}

	@Override
	public List<AdminMemDTO> memList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".memsearch");
	}

	@Override
	public AdminMemDTO memDetail(int mem_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".memdetail",mem_id);
	}

	@Override
	public int memUpdate(AdminMemDTO adminMemDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".ratingedit",adminMemDTO);
	}
	@Override
	public List<AdminAuctionDTO> auctionList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".auctionlist");
	}
	@Override
	public AdminAuctionDTO auctionDetail(int ab_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".auctiondetail",ab_id);
	}

	@Override
	public List<AdminAuctionDTO> reportList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".reportlist");
	}

	@Override
	public int auctionDelete(int ab_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+".auctiondelete",ab_id);
	}

	@Override
	public List<AdminNoticeDTO> noticeList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".noticelist");
	}

	@Override
	public int noticeAdd(AdminNoticeDTO adminNoticeDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".noticeadd", adminNoticeDTO);
	}
	@Override
	public List<AdminNoticeDTO> sortlist(String notice_sort) throws Exception{
		
		
		return sqlSession.selectList(namespace+".sortlist", notice_sort);
	}

	@Override
	public int noticeUpdate(AdminNoticeDTO adminNoticeDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".noticeedit", adminNoticeDTO);
	}

	@Override
	public int noticeDelete(int notice_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+".noticedelete",notice_id);
	}

	@Override
	public List<AdminInquiryDTO> inquiryList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".inquirylist");
	}

	@Override
	public AdminInquiryDTO inquiryDetail(int inquiry_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".inquirydetail",inquiry_id);
	}

	@Override
	public int inquirtAnswer(AdminInquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".inquiryanswer", inquiryDTO);
	}

	@Override
	public int inquiryend(AdminInquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".inquiryend",inquiryDTO);
	}

	@Override
	public List<MemberDTO> cashcharge() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".cashcharge");
	}

	@Override
	public int charge(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".charge",memberDTO);
	}

	@Override
	public int chargedelete(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".chargedelete", memberDTO);
	}
	
	


	
}
