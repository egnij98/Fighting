package kr.co.wonder.auction;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jdk.internal.org.jline.utils.Log;

@Service
public class AuctionServiceImpl implements AuctionService{

	@Autowired
	AuctionDAO dao;
	
//	@Override
//	public List<AuctionBoardDTO> list() throws Exception {
//		// TODO Auto-generated method stub
//		return dao.list();
//	}


	@Override
	public AuctionBoardDTO auctionproductdetail(String ab_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.auctionproductdetail(ab_id);
	}
	
	
	@Override
	public int auctionaddproduct(AuctionBoardDTO auctionBoardDTO) throws Exception {
		// TODO Auto-generated method stub

		return dao.auctionaddproduct(auctionBoardDTO);
		
	}


	@Override
	public int auctionproductupdate(AuctionBoardDTO auctionBoardDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.auctionproductupdate(auctionBoardDTO);
	}


	@Override
	public int auctionproductdelete(String ab_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.auctionproductdelete(ab_id);
	}


	@Override
	public List<AuctionBoardDTO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}


	@Override
	public List<AuctionBoardDTO> listAuctionPageMaker(AuctionPageVO pag) throws Exception {
		// TODO Auto-generated method stub
		return dao.listAuctionPageMaker(pag);
	}


	@Override
	public List<AuctionBoardDTO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		return dao.listPage(page);
	}


	@Override
	public int contPaging(AuctionPageVO pag) throws Exception {
		// TODO Auto-generated method stub
		return dao.contPaging(pag);
	}


	@Override
	public AuctionBoardDTO auctionproductdetail2(String ab_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.auctionproductdetail2(ab_id);
	}


	@Override
	public int pricecheck(String ab_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.pricecheck(ab_id);
	}


	@Override
	public int updatebid(AuctionBid auctionBid) throws Exception {
		// TODO Auto-generated method stub
		return dao.updatebid(auctionBid);
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



	
}
