package kr.co.wonder.admin;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.wonder.member.MemberDTO;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDAO dao;

	@Override
	public int productAdd(AdminProductDTO adminProductDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.productAdd(adminProductDTO);
	}

	@Override
	public List<AdminProductDTO> productList() throws Exception {
		// TODO Auto-generated method stub
		return dao.productList();
	}

	@Override
	public AdminProductDTO productDetail(int product_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.productDetail(product_id);
	}

	@Override
	public int productEdit(AdminProductDTO adminProductDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.productEdit(adminProductDTO);
	}


	@Override
	public int productDelete(int product_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.productDelete(product_id);
	}

	@Override
	public List<AdminMemDTO> memList() throws Exception {
		// TODO Auto-generated method stub
		return dao.memList();
	}

	@Override
	public AdminMemDTO memDetail(int mem_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.memDetail(mem_id);
	}

	@Override
	public int memUpdate(AdminMemDTO adminMemDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.memUpdate(adminMemDTO);
	}
	@Override
	public List<AdminAuctionDTO> auctionList() throws Exception {
		// TODO Auto-generated method stub
		return dao.auctionList();
	}
	@Override
	public AdminAuctionDTO auctionDetail(int ab_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.auctionDetail(ab_id);
	}

	@Override
	public List<AdminAuctionDTO> reportList() throws Exception {
		// TODO Auto-generated method stub
		return dao.reportList();
	}

	@Override
	public int auctionDelete(int ab_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.auctionDelete(ab_id);
	}

	@Override
	public List<AdminNoticeDTO> noticeList() throws Exception {
		// TODO Auto-generated method stub
		return dao.noticeList();
	}

	@Override
	public List<AdminNoticeDTO> sortlist(String notice_sort) throws Exception {
		// TODO Auto-generated method stub
		return dao.sortlist(notice_sort);
	}
	
	@Override
	public int noticeAdd(AdminNoticeDTO adminNoticeDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.noticeAdd(adminNoticeDTO);
	}

	@Override
	public int noticeUpdate(AdminNoticeDTO adminNoticeDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.noticeUpdate(adminNoticeDTO);
	}

	@Override
	public int noticeDelete(int notice_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.noticeDelete(notice_id);
	}

	@Override
	public List<AdminInquiryDTO> inquiryList() throws Exception {
		// TODO Auto-generated method stub
		return dao.inquiryList();
	}

	@Override
	public AdminInquiryDTO inquiryDetail(int inquiry_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.inquiryDetail(inquiry_id);
	}

	@Override
	public int inquirtAnswer(AdminInquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.inquirtAnswer(inquiryDTO);
	}

	@Override
	public int inquiryend(AdminInquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.inquiryend(inquiryDTO);
	}
	//파일업로드
	
	@Override
	public String uploadFile(MultipartFile[] upload) throws Exception{

        //파일이 업로드 될 경로 설정
       
        String projectroot="C:\\class\\springworkspaces\\wonder1234\\src\\main\\webapp\\resources\\images";
        
        //위에서 설정한 경로의 폴더가 없을 경우 생성
        File dir = new File(projectroot);
        if(!dir.exists()) {
            dir.mkdirs();
        }

       
        // 파일 업로드
        for(MultipartFile f : upload) {
            if(!f.isEmpty()) {
                // 기존 파일 이름을 받고 확장자 저장
                String orifileName = f.getOriginalFilename();
                String ext = orifileName.substring(orifileName.lastIndexOf("."));

                // 이름 값 변경을 위한 설정
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
                int rand = (int)(Math.random()*1000);

                // 파일 이름 변경
                String reName = sdf.format(System.currentTimeMillis()) + "_" + ext;

                // 파일 저장
               
                    f.transferTo(new File(projectroot + "/" + reName));
                
                  
                    return reName;
            	}
        }
        return null;
	}

	@Override
	public List<MemberDTO> cashcharge() throws Exception {
		// TODO Auto-generated method stub
		return dao.cashcharge();
	}

	@Override
	public int charge(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.charge(memberDTO);
	}

	@Override
	public int chargedelete(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.chargedelete(memberDTO);
	}



	
}
