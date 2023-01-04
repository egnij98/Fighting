package kr.co.wonder.auction;

import java.io.File;

import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileDownloadControllerThumb {
	// 저장할 파일 위치 지정
	private static final String CURR_IMAGE_REPO_PATH = "C:\\class\\springworkspaces\\image_repo";
	
	@RequestMapping("auction/download")
	//다운로드 할 이미지 파일 이름을 param에 전달
	protected void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "//" + imageFileName;
		File image = new File(filePath);
		
		//확장자를 제외한 원본 이미지 파일의 이름을 가져오기
		//.jpg .png 이런거니까 . 이전의 이름을 가져오기
		int lastindex = imageFileName.lastIndexOf(".");
		String fileName = imageFileName.substring(0, lastindex);
		
		//원본 이미지 파일 이름과 같은 이름의 썸네일 파일에 대한 File 객체 생성하기
		File thumbnail = new File(CURR_IMAGE_REPO_PATH + "//" + "Thumbnailator" + "//" + fileName + ".png");
		
		//원본 이미지 파일을 가로세로 50픽셀인 png형식으로 재 생성 한다.
		
		if(image.exists()) {
			thumbnail.getParentFile().mkdirs();
			Thumbnails.of(image).size(300, 300).outputFormat("png").toFile(thumbnail);
			
		}
		//생성된 썸네일 파일을 브라우저로 전솔
		//버퍼를 이용해서 한번에 8kbyte씩 브라우저로 전송한다.
		FileInputStream in = new FileInputStream(thumbnail);
		byte[] buffer = new byte[1024 * 8];
		while (true) {
			int cnt = in.read(buffer);
			if(cnt == -1) {
				break;
			}
			out.write(buffer, 0, cnt);
		}
		in.close();
		out.close();
	}

}
























