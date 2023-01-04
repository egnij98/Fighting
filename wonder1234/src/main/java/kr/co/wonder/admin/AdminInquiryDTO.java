package kr.co.wonder.admin;

import lombok.Data;

@Data
public class AdminInquiryDTO {

	private int inquiry_id;
	private String inquiry_content;
	private String inquiry_date;
	private String inquiry_state;
	private int mem_id;
	private String mem_name;
	private String inquiry_title;
}
