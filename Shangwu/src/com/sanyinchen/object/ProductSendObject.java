package com.sanyinchen.object;

public class ProductSendObject {

	String user_name;
	String path;
	String product_name;
	String product_other;
	String product_price;
	String product_number;
	String product_money;

	@Override
	public String toString() {
		return "ProductSendObject [user_name=" + user_name + ", path=" + path
				+ ", product_name=" + product_name + ", product_other="
				+ product_other + ", product_price=" + product_price
				+ ", product_number=" + product_number + ", product_money="
				+ product_money + "]";
	}

	public ProductSendObject(String user_name, String path,
			String product_name, String product_other, String product_price,
			String product_number, String product_money) {
		super();
		this.user_name = user_name;
		this.path = path;
		this.product_name = product_name;
		this.product_other = product_other;
		this.product_price = product_price;
		this.product_number = product_number;
		this.product_money = product_money;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_other() {
		return product_other;
	}

	public void setProduct_other(String product_other) {
		this.product_other = product_other;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	public String getProduct_number() {
		return product_number;
	}

	public void setProduct_number(String product_number) {
		this.product_number = product_number;
	}

	public String getProduct_money() {
		return product_money;
	}

	public void setProduct_money(String product_money) {
		this.product_money = product_money;
	}

}
