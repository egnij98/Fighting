package kr.co.wonder.product;

import lombok.Data;

public class CartDTO {
	
	private int cart_id; 
	private int cart_count; 
	private String mem_id; 
	private String product_id;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getCart_count() {
		return cart_count;
	}
	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
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
		return "CartDTO [cart_id=" + cart_id + ", cart_count=" + cart_count + ", mem_id=" + mem_id + ", product_id="
				+ product_id + "]";
	} 
	
	
}
