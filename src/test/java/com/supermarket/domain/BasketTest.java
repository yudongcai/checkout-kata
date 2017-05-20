package com.supermarket.domain;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class BasketTest {
	
	@Test
	public void testAddItem() {
		Basket basket = new Basket();
		basket.addItem("A");
		basket.addItem("B");
		basket.addItem("C");
		assertThat(basket.getItems().size()).isEqualTo(3);
		assertThat(basket.getItems().get(0)).isEqualTo("A");
		assertThat(basket.getItems().get(1)).isEqualTo("B");
		assertThat(basket.getItems().get(2)).isEqualTo("C");
	}
	
	@Test
	public void testEmptyBasket() {
		Basket basket = new Basket();
		basket.addItem("A");
		basket.addItem("B");
		basket.setTotalPrice(100.00);
		
		basket.emptyBasket();
		assertThat(basket.getItems()).isEmpty();
		assertThat(basket.getTotalPrice()).isEqualTo(0);
	}
}
