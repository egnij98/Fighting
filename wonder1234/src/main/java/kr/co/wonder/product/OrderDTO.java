package kr.co.wonder.product;

import lombok.Data;


public class OrderDTO {
	
	
	private int order_id;
	private int order_price; 
	private String order_status; 
	private String order_name; 
	private int  order_phone;
	private String order_address; 
	private String order_address2;
	private String mem_id;
	private String product_id;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public int getOrder_phon() {
		return order_phone;
	}
	public void setOrder_phon(int order_phone) {
		this.order_phone = order_phone;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public String getOrder_address2() {
		return order_address2;
	}
	public void setOrder_address2(String order_address2) {
		this.order_address2 = order_address2;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	@Override
	public String toString() {
		return "OrderDTO [order_id=" + order_id + ", order_price=" + order_price + ", order_status=" + order_status
				+ ", order_name=" + order_name + ", order_phon=" + order_phone + ", order_address=" + order_address
				+ ", order_address2=" + order_address2 + ", mem_id=" + mem_id + ", product_id=" + product_id + "]";
	}
	
	

}
