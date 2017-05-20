package com.supermarket.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.domain.Basket;
import com.supermarket.domain.ItemSpec;
import com.supermarket.service.CheckoutService;
import com.supermarket.service.ItemSpecService;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	private ItemSpecService itemSpecService;

	@Override
	public void checkout(Basket basket) {
		calculate(basket);
	}

	private void calculate(final Basket basket) {

		Map<String, Integer> itemCounter = new HashMap<>();
		basket.getItems().forEach(item -> {
			if (itemCounter.get(item) == null) {
				itemCounter.put(item, 1);
			} else {
				int count = itemCounter.get(item);
				itemCounter.put(item, ++count);
			}
		});

		double price = 0;

		for (Entry<String, Integer> e : itemCounter.entrySet()) {
			ItemSpec spec = this.itemSpecService.getItemSpecByName(e.getKey());
			final int count = e.getValue();
			if (spec.hasSpecialPrice() && count >= spec.getUnitForSpecialPrice()) {
				int a = count / spec.getUnitForSpecialPrice();
				int b = count % spec.getUnitForSpecialPrice();
				price += a * spec.getSpecialPrice();
				price += b * spec.getUnitPrice();
			} else {
				price += count * spec.getUnitPrice();
			}
		}

		basket.setTotalPrice(price);
	}

	public void setItemSpecService(ItemSpecService itemSpecService) {
		this.itemSpecService = itemSpecService;
	}
}
