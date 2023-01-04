package kr.co.wonder.admin;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.co.wonder.member.MemberDTO;

public interface AdminService {

		//상품등록
		public int productAdd(AdminProductDTO adminProductDTO) throws Exception;
		//상품목록
		public List<AdminProductDTO> productList() throws Exception;
		//상품상세목록
		public AdminProductDTO productDetail(int product_id) throws Exception; 
		//상품수정
		public int productEdit(AdminProductDTO adminProductDTO) throws Exception;
		//상품삭제
		public int productDelete(int product_id) throws Exception;
		//회원목록
		public List<AdminMemDTO> memList() throws Exception;
		//회원상세목록
		public AdminMemDTO memDetail(int mem_id) throws Exception;
		//회원등급변경
		public int memUpdate(AdminMemDTO adminMemDTO) throws Exception;
		//경매상품목록
		public List<AdminAuctionDTO> auctionList() throws Exception;
		//옥션 상세
		public AdminAuctionDTO auctionDetail(int ab_id) throws Exception;
		//신고된상품목록
		public List<AdminAuctionDTO> reportList() throws Exception;
		//경매상품삭제
		public int auctionDelete(int ab_id) throws Exception;
		//공지사항목록
		public List<AdminNoticeDTO> noticeList() throws Exception;
		//공지사항 종류별 목록
		public List<AdminNoticeDTO> sortlist(String notice_sort) throws Exception;
		//공지사항등록
		public int noticeAdd(AdminNoticeDTO adminNoticeDTO) throws Exception;
		//공지사항수정
		public int noticeUpdate(AdminNoticeDTO adminNoticeDTO) throws Exception;
		//공지사항삭제
		public int noticeDelete(int notice_id) throws Exception;
		//1:1문의 목록
		public List<AdminInquiryDTO> inquiryList() throws Exception; 
		//1:1문의 상세목록
		public AdminInquiryDTO inquiryDetail(int inquiry_id) throws Exception;
		//1:1문의 답변
		public int inquirtAnswer(AdminInquiryDTO inquiryDTO) throws Exception;
		//1:1문의 답변완료
		public int inquiryend(AdminInquiryDTO inquiryDTO) throws Exception;
		//업로드
		public String uploadFile(MultipartFile[] upload) throws Exception;
		//충전신청내역
		public List<MemberDTO> cashcharge() throws Exception;
		//충전신청 승인
		public int charge(MemberDTO memberDTO) throws Exception;
		//충전신청 삭제
		public int chargedelete(MemberDTO memberDTO)throws Exception;
}
