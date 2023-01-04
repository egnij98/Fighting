package kr.co.wonder.product;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.wonder.mypage.OrderHistoryDTO;


@Repository
public class ProductDAOImpI  implements ProductDAO{

	@Autowired 
	SqlSession sqlSession;
	static final String namespace="kr.co.product.productMapper";
	
	
	
	@Override
	
	//상품 목록보기
	public List<ProductDTO> productSelect() throws Exception {
		
		return sqlSession.selectList(namespace+".productselectall");
	}

	//상품 검색보기
	@Override
	public List<ProductDTO> productSearching(ProductDTO productdto) throws Exception {
		
		return sqlSession.selectList(namespace+".productserch", productdto);
	}
	//admin이 올린 상품목록 조회
	@Override
	public List<ProductDTO> adimproduct() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".adimproduct");
	}
	//admin이 올린 상품상세목록 조회
	@Override
	public ProductDTO adimproductdetail(String product_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".adimproductdetail", namespace);
	}
	
	//상푸 상세보기
	@Override
	public ProductDTO productSelectDeail(String product_id) throws Exception {
		
		return sqlSession.selectOne(namespace +".productselectdeail" ,product_id);
	}
	//상품 name로 검색
		@Override
		public ProductDTO productSelectDeail2(String product_name) throws Exception {
			// TODO Auto-generated method stub
			return sqlSession.selectOne(namespace +".productselectdeail2" ,product_name);
		}

	//상품 페이징 처리
	@Override
	public List<ProductDTO> listCriteria(Criteria cri) throws Exception {
	
		return sqlSession.selectList(namespace +".listCriteria" ,cri);
	}
	//상품 개수 구하기
	@Override
	public int countPaging(Criteria cri) throws Exception {
	
		return sqlSession.selectOne(namespace +".countPaging",cri);
	}

	@Override
	public int addCart(CartDTO cartdto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace +".addCart" ,cartdto);
	}

	@Override
	public int countCart(String product_id, String mem_id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product_id", product_id);
		map.put("mem_id", mem_id);
		return sqlSession.selectOne(namespace +".countCart",map);
	}

	@Override
	public int updateCart(CartDTO cartdto) throws Exception {
		return sqlSession.update(namespace + ".updateCart", cartdto);
		
	}

	@Override
	public int paymentMove(OrderDTO orderdto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".paymentmove" ,orderdto);
	}

	@Override
	public List<ProductDTO> productSimila(String product_cate) throws Exception {
		// TODO Auto-generated method stub
		return  sqlSession.selectList(namespace + ".productsimila", product_cate);
	}
	//있는 상품중 제일 가격이 높은 즉시 구매가 
	@Override
	public ProductDTO immediatesale(ProductDTO prodcutdto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".immediatesale", prodcutdto);
	}
	//있는상품중 사이즈별 가격이 높은 즉시 판매가
	@Override
	public ProductDTO immediatesale2(ProductDTO prodcutdto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".immediatesale2", prodcutdto);
	}

	@Override
	public ProductDTO sizeBy(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".sizeby",productdto);
	}

	@Override
	public int purchasebid(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".purchasebid",productdto);
	}
	@Override
	public int purchasebid2(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".purchasebid2",productdto);
	}


	@Override
	public int updatepr(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".updatepr", productdto);
	}

	@Override
	public int insertpr(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".insertpr", productdto);
	}

	@Override
	public int saleupdate(String product_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".saleupdate", product_id);
	}

	@Override
	public int orderhistoryinsert(OrderHistoryDTO orderhistorydto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".orderhistotyinsert", orderhistorydto);
	}

	
	

	

	

	



}
