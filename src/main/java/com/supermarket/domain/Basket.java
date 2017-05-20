package com.supermarket.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("items [");
		sb.append(items.stream().collect(Collectors.joining(",")));
		sb.append("], totalPrice [");
		sb.append(this.totalPrice + "]");
		return sb.toString();
	}
	
	
}