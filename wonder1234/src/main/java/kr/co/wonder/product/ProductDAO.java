package kr.co.wonder.product;

import java.util.List;


import kr.co.wonder.mypage.OrderHistoryDTO;



public interface ProductDAO {
	
	//상품목록처리 메소드
	public List<ProductDTO> productSelect() throws Exception;
	//admin이 올린 상품목록 조회
	public List<ProductDTO> adimproduct() throws Exception;
	//admin이 올린 상품상세목록 조회
	public  ProductDTO adimproductdetail(String product_id) throws Exception;
	//상품 상세페이지 처리
	public  ProductDTO productSelectDeail(String product_id) throws Exception;
	//상품 name으로 검색
	public  ProductDTO productSelectDeail2(String product_name) throws Exception;
	//상품 검색 처리
	public List<ProductDTO> productSearching(ProductDTO productdto) throws Exception; 
	//상품 개수조회
	public int countPaging(Criteria cri) throws Exception;
	//상품 페이징 처리후 리스트
	public List<ProductDTO> listCriteria(Criteria cri) throws Exception;
	//장바구니 추가
	public int addCart(CartDTO cartdto) throws Exception;
	//장바구니에 동일한 상품 체크
	public int countCart(String product_id,String mem_id) throws Exception;
	//장바구니에 동일한 상품 존재하면 수정
	public int updateCart(CartDTO cartdto) throws Exception;
	//상품추가
	public int paymentMove(OrderDTO orderdto) throws Exception;
	//같은브랜드 다른상품 찾기
	public List<ProductDTO> productSimila(String product_cate)throws Exception;
	//있는상품중 제일 가격이 높은 즉시 구매가
	public ProductDTO immediatesale(ProductDTO prodcutdto) throws Exception;
	//있는상품중 사이즈별 제일 가격이 높은 즉시 구매가
	public ProductDTO immediatesale2(ProductDTO prodcutdto) throws Exception;
	//사이즈별 구매 가격
	public ProductDTO sizeBy(ProductDTO productdto) throws Exception;
	//구매입찰신청 product 테이블에넣는 메소드
	public int purchasebid(ProductDTO productdto) throws Exception;
	//판매입찰신청 product 테이블에넣는 메소드
	public int purchasebid2(ProductDTO productdto) throws Exception;
	//구매 예약상품을 판매자가 생겨 구매 한사람 update문
	public int updatepr(ProductDTO productdto) throws Exception;
	//판매자는 판매완료라는 insert문 
	public int insertpr(ProductDTO productdto) throws Exception;
	
	//판매중인상품을 판매완료로 바꿔주는 메소드(주문이 완료된상태)
	public int saleupdate(String product_id) throws Exception;
	//주문한 상품의 주문자 정보와 상품정보를 orderhistoty에 추가
	public int orderhistoryinsert(OrderHistoryDTO orderhistotydto) throws Exception;
	
}
