package kr.co.wonder;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.co.wonder.product.ProductDTO;
import kr.co.wonder.product.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	@Autowired
	ProductService pservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		List<ProductDTO> product = pservice.adimproduct();
		model.addAttribute("product", product);
		
		return "home";
	}
	@RequestMapping(value = "product/search", method = RequestMethod.GET)
	public String product2(ProductDTO productdto, Model model ) throws Exception {
		List<ProductDTO> product = pservice.productSearching(productdto);
			model.addAttribute("product", product);
		return "product/product";
	}
	//파일 업로드 컨트롤러
	@RequestMapping(value="/upload",method=RequestMethod.POST)
    public String uploadFile(MultipartFile[] upload, HttpServletRequest request) throws Exception{

        //파일이 업로드 될 경로 설정
       
        String projectroot="D:\\springworkspaces\\wonder\\src\\main\\webapp\\resources\\images";
        logger.info(projectroot);
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
                
                    logger.info("업로드성공");
            	}
        }
        return "admin/adminhome";
	}

}	

