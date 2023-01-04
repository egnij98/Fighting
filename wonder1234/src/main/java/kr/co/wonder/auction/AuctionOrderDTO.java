/*
 * product_id varchar(25) PK 
mem_id varchar(25) 
ab_id varchar(25)
 */
package kr.co.wonder.auction;

import lombok.Data;

@Data
public class AuctionOrderDTO {
	private String product_id;
	private String mem_id;
	private String ab_id;
	

}
