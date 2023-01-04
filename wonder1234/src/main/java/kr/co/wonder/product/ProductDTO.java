package kr.co.wonder.product;

import java.util.Date;

import lombok.Data;


@Data
public class ProductDTO {
	
	private String product_id;
	private String product_name;
	private	String product_price;
	private String product_desc;
	private Date product_date;
	private String product_hits;
	private String product_size;
	private String product_auction;
	private String product_cate;
	private String product_code;
	private String mem_id;
	private String product_img;
	
	
}
