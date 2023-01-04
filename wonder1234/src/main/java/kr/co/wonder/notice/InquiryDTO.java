package kr.co.wonder.notice;

import lombok.Data;

@Data
public class InquiryDTO {

	private int inquiry_id;
	private String inquiry_title;
	private String inquiry_content;
	private String inquiry_date;
	private String inquiry_sort;
	private String mem_id;
}
