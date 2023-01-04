package kr.co.wonder.notice;

import java.util.List;


import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class NoticeDAOImpl implements NoticeDAO{
	@Autowired
	private SqlSession sqlSession;
	
	static final String namespace = "kr.co.wonder.NoticeMapper";

	@Override
	public List<NoticeDTO> noticelist() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".noticelist");
	}

	@Override
	public int inquiryadd(InquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".inquiryadd", inquiryDTO);
	}

	@Override
	public List<NoticeDTO> listPage(int page) throws Exception{
		
		if(page<=0) {
			page=1;
		}
		page=(page-1)*10;
		return sqlSession.selectList(namespace + ".listPage",page);
				
	}

	@Override
	public List<NoticeDTO> listCriteria(CriteriaVO cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".listCriteria", cri);
	}

	@Override
	public int countPaging(CriteriaVO cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".countPaging", cri);
	}

	@Override
	public NoticeDTO noticedetail(int notice_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".noticedetail", notice_id);
	}


}
