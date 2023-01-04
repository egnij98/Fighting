package kr.co.wonder.mypage;

import java.util.List;

import kr.co.wonder.product.CartDTO;
import kr.co.wonder.product.ProductDTO;

public interface MypageService  {
	
	// 찜하기 ( 추가 )
	public int insert(wishlistDTO wishlistdto);
	// 찜 목록 확인
	public List<wishlistDTO> getLikeListByUserid(String mem_id);
	// 찜 목록 1개 삭제
	public int deleteWishList(wishlistDTO wishlistdto);
	// 이미 찜한 게시물인지 조회
	public wishlistDTO getByCnoWithUserid(wishlistDTO wishlistdto);
	//장바구니 확인
	public List<CartDTO> selectShoppingBasket(String mem_id);
	//장바구니 목록확인
	public ProductDTO selectCart(String product_id);
	//장바구니 삭제
	public int delectCart(CartDTO cartdto);
	//판매내역 보기
	public List<SaleofGoodsDTO> saleofGoods(String mem_id);
	//판매내역에서 판매완료된거 검색
	public List<ProductDTO> SalesCompleted(String mem_id);
	//판매내역 삭제
	public int delsaleofGoods(SaleofGoodsDTO salefGoodsDTO);
	//판매내역 삭제2
	public int delsaleofGoods2(SaleofGoodsDTO salefGoodsDTO);

	//구매내역 보기
	public List<BuyofGoodsDTO> buyofGoods(String mem_id);
	//구매내역에서 구매완료된거 검색
	public List<ProductDTO> buyCompleted(String mem_id);
	//구매내역 테이블삭제
	public int delbuyHistory(BuyofGoodsDTO buyofgoodsdto);
	//product 테이블에서 삭제안되어서 product_code를 ="삭제" update문
	public int updatebuyHistory2(BuyofGoodsDTO buyofgoodsdto);
	//내가 구매예약 걸어놓은 상품 보기
	public List<ProductDTO> buyselect(String mem_id) throws Exception;
	//내가 구매예약한 상품 취소및삭제
	public int buydel(ProductDTO productdto) throws Exception;
	//내가 판매입찰 걸어놓은 상품 보기
	public List<ProductDTO> saleselect(String mem_id) throws Exception;
	//내가 판매입찰 상품 취소및삭제
	public int saledel(ProductDTO productdto) throws Exception;



}
