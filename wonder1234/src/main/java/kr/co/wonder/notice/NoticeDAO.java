package kr.co.wonder.notice;

import java.util.List;





public interface NoticeDAO {

	
	//공지사항목록
	public List<NoticeDTO> noticelist()throws Exception;
	//공지사항 상세조회
	public NoticeDTO noticedetail(int notice_id)throws Exception;

	//1:1문의 작성
	public int inquiryadd(InquiryDTO inquiryDTO)throws Exception; 
	//페이징
	public List<NoticeDTO> listPage(int page) throws Exception;
	
	public List<NoticeDTO> listCriteria(CriteriaVO cri) throws Exception;
	
	public int countPaging(CriteriaVO cri) throws Exception;
	
}
