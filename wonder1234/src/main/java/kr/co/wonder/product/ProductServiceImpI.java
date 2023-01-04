package kr.co.wonder.product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.wonder.mypage.OrderHistoryDTO;

@Service
public class ProductServiceImpI implements ProductService{

	@Autowired
	ProductDAO dao;
	
	@Override
	public List<ProductDTO> productSelect() throws Exception {
		// TODO Auto-generated method stub
		return dao.productSelect();
	}
	@Override
	public List<ProductDTO> adimproduct() throws Exception {
		// TODO Auto-generated method stub
		return dao.adimproduct();
	}

	@Override
	public ProductDTO adimproductdetail(String product_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.adimproductdetail(product_id);
	}

	@Override
	public ProductDTO productSelectDeail(String product_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.productSelectDeail(product_id);
	}
	@Override
	public ProductDTO productSelectDeail2(String product_name) throws Exception {
		// TODO Auto-generated method stub
		return dao.productSelectDeail2(product_name);
	}

	@Override
	public List<ProductDTO> productSearching(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return dao.productSearching(productdto);
	}
	

	

	@Override
	public List<ProductDTO> listCriteria(Criteria cri) throws Exception {

		return dao.listCriteria(cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {

		return dao.countPaging(cri);
	}

	@Override
	public int addCart(CartDTO cartdto) throws Exception {

		return dao.addCart(cartdto);
	}

	@Override
	public int countCart(String product_id, String mem_id) throws Exception {

		return dao.countCart(product_id, mem_id);
	}

	@Override
	public int updateCart(CartDTO cartdto) throws Exception {

		return dao.updateCart(cartdto);
	}

	@Override
	public int paymentMove(OrderDTO orderdto) throws Exception {
		// TODO Auto-generated method stub
		return dao.paymentMove(orderdto);
	}

	@Override
	public List<ProductDTO> productSimila(String product_cate) throws Exception {
		// TODO Auto-generated method stub
		return dao.productSimila(product_cate);
	}

	@Override
	public ProductDTO immediatesale(ProductDTO prodcutdto) throws Exception {
		// TODO Auto-generated method stub
		return dao.immediatesale(prodcutdto);
	}
	@Override
	public ProductDTO immediatesale2(ProductDTO prodcutdto) throws Exception {
		// TODO Auto-generated method stub
		return dao.immediatesale2(prodcutdto);

	}
	@Override
	public ProductDTO sizeBy(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return dao.sizeBy(productdto);
	}

	@Override
	public int purchasebid(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return dao.purchasebid(productdto);
	}
	@Override
	public int purchasebid2(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return dao.purchasebid2(productdto);
	}

	

	@Override
	public int updatepr(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return dao.updatepr(productdto);
	}

	@Override
	public int insertpr(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertpr(productdto);
	}

	@Override
	public int saleupdate(String product_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.saleupdate(product_id);
	}

	@Override
	public int orderhistoryinsert(OrderHistoryDTO orderhistotydto) throws Exception {
		// TODO Auto-generated method stub
		return dao.orderhistoryinsert(orderhistotydto);
	}


	

	

	

	



}
