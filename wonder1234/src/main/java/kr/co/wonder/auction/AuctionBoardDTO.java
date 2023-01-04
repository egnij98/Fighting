/*
ab_id varchar(25) PK 
ab_title varchar(20) 
ab_date date 
ab_limit date 
ab_currentprice int 
ab_startprice int 
ab_minimumprice int 
ab_endprice int 
ab_category varchar(45) 
ab_delete varchar(45) 
ab_content varchar(60)
 */

package kr.co.wonder.auction;


import lombok.Data;

@Data
public class AuctionBoardDTO {
	private String ab_id;
	private String ab_title;
	private String ab_date;
	private String ab_limit;
	private int ab_currentprice;
	private int ab_startprice;
	private int ab_minimumprice;
	private int ab_endprice;
	private String ab_category;
	private int ab_delete;
	private String ab_content;
	private int ab_pricerise;
	private String product_img;
	private String mem_id;

	

}
