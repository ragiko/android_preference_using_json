package com.example.prefarence_with_json;

public class Item {

	private String price;
	private int quantity;
	private int total;

	public Item(String price,  int quantity, int total) {
		this.price = price;
		this.quantity = quantity;
		this.total = total;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
