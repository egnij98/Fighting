/*
 * 
 * mem_id varchar(25) PK 
buyer_date date 
buyer_price int 
buyer_cash int 
product_id varchar(25)
 */

package kr.co.wonder.auction;

import java.util.Date;

import lombok.Data;

@Data
public class AuctionBuyerDTO {
	private String mem_id;
	private Date buyer_date;
	private int buyer_price;
	private int buyer_cash;
	private String product_id;
}
