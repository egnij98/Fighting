package kr.co.wonder.mypage;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.wonder.product.CartDTO;
import kr.co.wonder.product.ProductDAO;
import kr.co.wonder.product.ProductDTO;

@Service
public class MypageServiceImpl implements MypageService{
	
	@Autowired
	MypageDAO mdao;

	@Override
	public int insert(wishlistDTO wishlistdto) {
		// TODO Auto-generated method stub
		return mdao.insert(wishlistdto);
	}

	@Override
	public List<wishlistDTO> getLikeListByUserid(String mem_id) {
		return mdao.getLikeListByUserid(mem_id);
	}

	@Override
	public int deleteWishList(wishlistDTO wishlistdto) {
		// TODO Auto-generated method stub
		return mdao.deleteWishList(wishlistdto);
	}

	@Override
	public wishlistDTO getByCnoWithUserid(wishlistDTO wishlistdto) {
		// TODO Auto-generated method stub
		return mdao.getByCnoWithUserid(wishlistdto);
	}

	@Override
	public List<CartDTO> selectShoppingBasket(String mem_id) {
		// TODO Auto-generated method stub
		return mdao.selectShoppingBasket(mem_id);
	}

	@Override
	public ProductDTO selectCart(String product_id) {
		// TODO Auto-generated method stub
		return mdao.selectCart(product_id);
	}

	@Override
	public int delectCart(CartDTO cartdto) {
		// TODO Auto-generated method stub
		return mdao.delectCart(cartdto);
	}

	@Override
	public List<SaleofGoodsDTO> saleofGoods(String mem_id) {
		// TODO Auto-generated method stub
		return mdao.saleofGoods(mem_id);
	}
	@Override
	public int delsaleofGoods2(SaleofGoodsDTO salefGoodsDTO) {
		// TODO Auto-generated method stub
		return mdao.delSaleHistory2(salefGoodsDTO);
	}
	@Override
	public int delsaleofGoods(SaleofGoodsDTO salefGoodsDTO) {
		return mdao.delSaleHistory(salefGoodsDTO);
	}

	@Override
	public List<BuyofGoodsDTO> buyofGoods(String mem_id) {
		// TODO Auto-generated method stub
		return mdao.buyofGoods(mem_id);
	}

	@Override
	public List<ProductDTO> SalesCompleted(String mem_id) {
		return mdao.SalesCompleted(mem_id);
	}

	@Override
	public List<ProductDTO> buyCompleted(String mem_id) {
		// TODO Auto-generated method stub
		return mdao.buyCompleted(mem_id);
	}

	@Override
	public int delbuyHistory(BuyofGoodsDTO buyofgoodsdto) {
		// TODO Auto-generated method stub
		return mdao.delbuyHistory(buyofgoodsdto);
	}

	@Override
	public int updatebuyHistory2(BuyofGoodsDTO buyofgoodsdto) {
		// TODO Auto-generated method stub
		return mdao.updatebuyHistory2(buyofgoodsdto);
	}
	@Override
	public List<ProductDTO> buyselect(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return mdao.buyselect(mem_id);
	}
	@Override
	public int buydel(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return mdao.buydel(productdto);
	}

	@Override
	public List<ProductDTO> saleselect(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return mdao.saleselect(mem_id);
	}

	@Override
	public int saledel(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return mdao.saledel(productdto);
	}

	



}
