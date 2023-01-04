package kr.co.wonder.admin;

import lombok.Data;

@Data

public class AdminProductDTO {

	private int product_id;
	private String product_name;
	private String product_desc;
	private String product_cate;
	private String product_code;
	private String product_img;
}
