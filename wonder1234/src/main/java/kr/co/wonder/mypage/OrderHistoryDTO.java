package kr.co.wonder.mypage;

import lombok.Data;

@Data
public class OrderHistoryDTO {
	
	private int id_orderhistory;
	private String mem_id;
	private int order_id;
	private String product_id;
	
	

	
}
