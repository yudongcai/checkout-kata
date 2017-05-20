package com.supermarket.service.impl;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.supermarket.domain.ItemSpec;
import com.supermarket.service.ItemSpecService;

public class ItemSpecServiceImplTest {
	
	private ItemSpecService service;
	
	@Before
	public void setup() {
		this.service = new ItemSpecServiceImpl();
		this.service.create(new ItemSpec("A", 50.00, 130.00, 3));
		this.service.create(new ItemSpec("B", 30.00, 45.00, 2));
		this.service.create(new ItemSpec("C", 20.00, 0, 0));
		this.service.create(new ItemSpec("D", 15.00, 0, 0));
		this.service.create(new ItemSpec("E", 10.00, 0, 0));
		this.service.create(new ItemSpec("F", 5.00, 0, 0));
	}
	

	@Test
	public void testGetItemSpecByName() {
		ItemSpec itemSpec = this.service.getItemSpecByName("A");
		assertThat(itemSpec).isNotNull();
		assertThat(itemSpec.getUnitPrice()).isEqualTo(50.00);
		
		itemSpec = this.service.getItemSpecByName("G");
		assertThat(itemSpec).isNull();
	}

}
