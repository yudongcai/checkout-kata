package com.supermarket.domain;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	
	private List<String> items = new ArrayList<String>();
	
	private double totalPrice;
	
	public void addItem(String itemName) {
		this.items.add(itemName);
	}
	
	public List<String> getItems() {
		return items;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPayed) {
		this.totalPrice = totalPayed;
	}
	
	public void emptyBasket() {
		this.items.clear();
		this.totalPrice = 0;
	}
}