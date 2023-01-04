package kr.co.wonder.notice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	NoticeDAO dao;

	@Override
	public List<NoticeDTO> noticelist() throws Exception {
		// TODO Auto-generated method stub
		return dao.noticelist();
	}

	@Override
	public int inquiryadd(InquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.inquiryadd(inquiryDTO);
	}

	@Override
	public List<NoticeDTO> listCriteria(CriteriaVO cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(CriteriaVO cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}

	@Override
	public NoticeDTO noticedetail(int notice_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.noticedetail(notice_id);
	}
}
