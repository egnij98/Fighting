/*
 * AuctionPageVO pag.getPage() : 현재 페이지 번호
 * AuctionPageVO pag.getPerPageNum() : 한 페이지당 보여줄 게시글의 갯수
 * int totalCount : 총 게시글 수
 * int endPage : 화면에 보여질 마지막 페이지 번호, 끝 페이지 번호
 * int startPage : 화면에 보여질 첫번째 페이지 번호, 시작 페이지 번호
 * boolean prev : 이전 버튼 생성 여부
 * boolean next : 다음 버튼 생성 여부
 * int displayPageNum : 화면 하단에 보여지는 페이지 버튼의 수
 */
package kr.co.wonder.auction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class AuctionPageMaker {
	private static final Logger logger = LoggerFactory.getLogger(AuctionController.class);
	
	private AuctionPageVO pag;
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 5;
	
	public AuctionPageVO getPag() {
		return pag;
	}
	
	public void setPag(AuctionPageVO pag) {
		this.pag = pag;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//총 게시글 수를 셋팅할때 calcData() 메서드를 호출하여 페이징 관련 버튼 계산을 한다.
		calcData();
	}

	//페이징의 버튼들을 생성하는 계산식. 끝 페이지 번호, 시작 페이지 번호, 이전, 다음 버튼들을 구한다.
	private void calcData() {
		// TODO Auto-generated method stub
		//끝 페이지 번호 = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 갯수) * 화면에 보여질 페이지 번호의 갯수
		endPage = (int)(Math.ceil(pag.getPage() / (double) displayPageNum) * displayPageNum);
		//시작 페이지 번호 = (끝 페이지 번호 - 화면에 보여질 페이지 번호의 갯수) + 1
		startPage = (endPage - displayPageNum) + 1;
		if(startPage <= 0) startPage = 1; //책과는 다른 점
		//마지막 페이지 번호 = 총 게시글 수 / 한 페이지당 보여줄 게시글의 갯수
		int tempEndPage = (int)(Math.ceil(totalCount / (double) pag.getPerPageNum()));
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		//이전 버튼 생성 여부 = 시작 페이지 번호 == 1 ? false : true
		prev = startPage == 1 ? false : true;
		//다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 갯수 < 총 게시글의 수 ? true: false
		next = endPage * pag.getPerPageNum() < totalCount ? true : false;
		
	}
	
	public String makeQuery(int page) {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", pag.getPerPageNum())
				.build();
		
		logger.info(uriComponents.toString());
		
		return uriComponents.toUriString();
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public boolean isPrev() {
		return prev;
	}
	
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	
	public boolean isNext() {
		return next;
	}
	
	public void setNext(boolean next) {
		this.next = next;
	}
	
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

}



















