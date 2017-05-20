package com.supermarket.service.impl;

import static org.fest.assertions.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.supermarket.domain.Basket;
import com.supermarket.domain.ItemSpec;

public class CheckoutServiceImplTest {
	
	private ItemSpecServiceImpl itemSpecService = new ItemSpecServiceImpl();
	
	private CheckoutServiceImpl checkoutService = new CheckoutServiceImpl();
	
	ItemSpec a = new ItemSpec("A", 50.00, 130.00, 3);
	ItemSpec b = new ItemSpec("B", 30.00, 45.00, 2);
	ItemSpec c = new ItemSpec("C", 20.00, 0, 0);
	ItemSpec d = new ItemSpec("D", 15.00, 0, 0);
	
	@Before
	public void setup() {
		Stream.of(a, b, c, d).forEach(this.itemSpecService::create);
		this.checkoutService.setItemSpecService(itemSpecService);
	}

	@Test
	public void testCheckout() {
		Basket basket = new Basket();
		basket.addItem("A");
		this.checkoutService.checkout(basket);
		assertThat(basket.getTotalPrice() == a.getUnitPrice()).isTrue();
		
		basket.addItem("A");
		this.checkoutService.checkout(basket);
		assertThat(basket.getTotalPrice() == (a.getUnitPrice() * 2)).isTrue();
		
		basket.addItem("A");
		this.checkoutService.checkout(basket);
		assertThat(basket.getTotalPrice() == a.getSpecialPrice()).isTrue();
		
		basket.addItem("A");
		this.checkoutService.checkout(basket);
		assertThat(basket.getTotalPrice() == a.getSpecialPrice() + a.getUnitPrice()).isTrue();
		
		Basket basket2 = new Basket();
		Stream.of("A", "B", "A", "B", "A").forEach(i->basket2.addItem(i));
		this.checkoutService.checkout(basket2);
		assertThat(basket2.getTotalPrice() == a.getSpecialPrice() + b.getSpecialPrice()).isTrue();
		
		Basket basket3 = new Basket();
		Stream.of("D", "B", "A", "B", "A", "D").forEach(i->basket3.addItem(i));
		this.checkoutService.checkout(basket3);
		assertThat(basket3.getTotalPrice() == a.getUnitPrice() * 2 + b.getSpecialPrice() + d.getUnitPrice() * 2).isTrue();
		
	}

}
