package kr.co.wonder.mypage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.wonder.product.CartDTO;
import kr.co.wonder.product.ProductDTO;

@Repository
public class MypageDAOImpl implements MypageDAO{
	
	@Autowired 
	SqlSession sqlSession;
	
	static final String namespace="kr.co.mypage.myPageMapper";
	@Override
	public int insert(wishlistDTO wishlistdto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".choiceinsert", wishlistdto);
	}
	@Override
	public List<wishlistDTO> getLikeListByUserid(String mem_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".wishlist", mem_id);
	}
	@Override
	public int deleteWishList(wishlistDTO wishlistdto) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + ".deleteOne",wishlistdto);
	}

	@Override
	public wishlistDTO getByCnoWithUserid(wishlistDTO wishlistdto) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".serchingWishlist",wishlistdto);
	}
	@Override
	public List<CartDTO> selectShoppingBasket(String mem_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace +".cartlist", mem_id);
	}
	@Override
	public ProductDTO selectCart(String product_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace +".selectCart", product_id);
	}
	@Override
	public int delectCart(CartDTO cartdto) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace +".delectCart",cartdto);
	}
	
	//판매관련
	@Override
	public List<SaleofGoodsDTO> saleofGoods(String mem_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace +".saleofgoods", mem_id);
	}
	@Override
	public int delSaleHistory(SaleofGoodsDTO salefGoodsDTO) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace +".delsalehistory", salefGoodsDTO);
	}
	@Override
	public List<ProductDTO> SalesCompleted(String mem_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".salescompleted", mem_id);
	}
	@Override
	public int delSaleHistory2(SaleofGoodsDTO saleofGoodsDTO) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace +".delsalehistory2", saleofGoodsDTO);
	}
	//구매관련
	@Override
	public List<BuyofGoodsDTO> buyofGoods(String mem_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace +".buyofgoods", mem_id);
	}
	@Override
	public List<ProductDTO> buyCompleted(String mem_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".buycompleted",mem_id);
	}
	@Override
	public int delbuyHistory(BuyofGoodsDTO buyofgoodsdto) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+".delbuyhistory", buyofgoodsdto);
	}
	@Override
	public int updatebuyHistory2(BuyofGoodsDTO buyofgoodsdto) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".delbuyhistory2",buyofgoodsdto);
	}
	@Override
	public List<ProductDTO> buyselect(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".buyselect", mem_id);
	}
	@Override
	public int buydel(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+".buydel", productdto);
	}
	@Override
	public List<ProductDTO> saleselect(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".saleselect", mem_id);
	}
	@Override
	public int saledel(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+".saledel", productdto);
	}


}
