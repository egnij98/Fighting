package kr.co.wonder.notice;

import lombok.Data;

@Data
public class NoticeDTO {
	private int notice_id;
	private String notice_title;
	private String notice_sort;
	private String notice_content;
	private String notice_date;
}
