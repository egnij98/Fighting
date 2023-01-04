package kr.co.wonder.admin;

import lombok.Data;

@Data
public class AdminNoticeDTO {
	private int notice_id;
	private String notice_title;
	private String notice_sort;
	private String notice_content;
}
