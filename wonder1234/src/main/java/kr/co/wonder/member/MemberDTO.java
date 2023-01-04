package kr.co.wonder.member;
	/*
	 * mem_id varchar(45) PK 
	mem_password varchar(45) 
	mem_name varchar(45) 
	mem_address1 varchar(45) 
	mem_address2 varchar(45) 
	mem_nickname varchar(45) 
	mem_homenum int 
	mem_phonenum int 
	mem_email1 varchar(45) 
	mem_email2 varchar(45) 
	mem_gender varchar(45) 
	mem_birth datetime 
	mem_cash int 
	mem_emailcert varchar(45) 
	mem_hint varchar(45) 
	mem_rating int 
	mem_first datetime 
	mem_login datetime 
	mem_logout datetime 
	product_id varchar(45)
	 */

import lombok.Data;

@Data

// product_id 삭제
// email2 삭제
// 힌트를 위한 질문 : hint1
// 			답변 : hint2 추가
	public class MemberDTO {
		private String mem_id;
		private String mem_password;
		private String mem_name;
		private String mem_address;
		private String mem_address1;
		private String mem_address2;
		private String mem_nickname;
		private int mem_homenum;
		private int mem_phonenum;
		private String mem_email1;
		private String mem_gender;
		private String mem_birth;
		private String mem_cash;
		private String mem_hint1;
		private String mem_hint2;
		private String mem_first;
		private int mem_rating;
		private String mem_charge;
		private String mem_amount;
		private String mem_chargedate;
		private String mem_withdraw;
		private String mem_amount1;
		private String mem_drawdate;
	}
		
		
		
		

