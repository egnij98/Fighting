package kr.co.wonder.auction;

import java.util.List;
import java.util.Map;

import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuctionDAOImpl implements AuctionDAO{
	@Autowired
	private SqlSession sqlSession;
	
	static final String Namespace = "kr.co.wonder.auctionMapper";

//	@Override
//	public List<AuctionBoardDTO> list() throws Exception {
//		// TODO Auto-generated method stub
//		return sqlSession.selectList(Namespace + ".auctionlist");
//	}

	@Override
	public AuctionBoardDTO auctionproductdetail(String ab_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace + ".auctionproductdetail", ab_id);
	}

	@Override
	public int auctionaddproduct(AuctionBoardDTO auctionBoardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(Namespace + ".auctionaddproduct", auctionBoardDTO);
	}

	@Override
	public int auctionproductupdate(AuctionBoardDTO auctionBoardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(Namespace + ".auctionproductupdate", auctionBoardDTO);
	}

	@Override
	public int auctionproductdelete(String ab_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(Namespace + ".auctionproductdelete", ab_id);
	}

	@Override
	public List<AuctionBoardDTO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuctionBoardDTO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		if(page <= 0) {
			page = 1;
		}
		
		page = (page - 1) * 6;
		
		return sqlSession.selectList(Namespace + ".listPage", page);
	}

	@Override
	public List<AuctionBoardDTO> listAuctionPageMaker(AuctionPageVO pag) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace+".AuctionPageVO", pag);
	}

	@Override
	public int contPaging(AuctionPageVO pag) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace+".countPaging", pag);
	}

	@Override
	public AuctionBoardDTO auctionproductdetail2(String ab_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace+".auctionproductdetail2", ab_id);
	}

	@Override
	public int pricecheck(String ab_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace+".pricecheck", ab_id);
	}

	@Override
	public int updatebid(AuctionBid auctionBid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(Namespace+".updatebid", auctionBid);
	}

//	@Override
//	public List<AuctionBoardDTO> listPage(int page) throws Exception {
//		// TODO Auto-generated method stub
//		if(page <= 0) {
//			page = 1;
//		}
//		
//		page = (page - 1) * 6;
//		
//		return sqlSession.selectList(Namespace + ".listPage", page);
//	}
//	
//	@Override
//	public List<AuctionBoardDTO>list(AuctionPageVO pag) {
//		// TODO Auto-generated method stub
//		return sqlSession.selectList(Namespace + ".auctionlist", pag);
//	}


//	@Override
//	public List<AuctionBoardReplyDTO> auctionproductdetail1(String ab_id) throws Exception {
//		// TODO Auto-generated method stub
//		return sqlSession.selectList(Namespace+".auctionproductdetail1", ab_id);
//	}

}
