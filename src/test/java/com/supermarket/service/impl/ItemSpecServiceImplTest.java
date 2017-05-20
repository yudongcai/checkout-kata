package com.supermarket.service.impl;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

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
	
	@Test
	public void testUpdate() {
		
		this.service.update(new ItemSpec("A", 100.00, 430.00, 5));
		
		ItemSpec spec = this.service.getItemSpecByName("A");
		assertThat(spec.getUnitPrice()).isEqualTo(100.00);
		assertThat(spec.getUnitForSpecialPrice()).isEqualTo(5);
		assertThat(spec.getSpecialPrice()).isEqualTo(430.00);
	}
	
	@Test (expected=RuntimeException.class)
	public void testUpdateWhenNotExist() {
		
		this.service.update(new ItemSpec("G", 100.00, 430.00, 5));
		fail("Shouldn't reach here");
	}
	
	@Test
	public void testDelete() {
		this.service.delete("A");
		assertThat(this.service.list().size()).isEqualTo(5);
		
		this.service.delete("A");
		assertThat(this.service.list().size()).isEqualTo(5);
		
		this.service.delete("B");
		assertThat(this.service.list().size()).isEqualTo(4);
	}
	
	@Test
	public void testCreate() {
		ItemSpec spec = new ItemSpec("G", 50.00, 130.00, 3);
		ItemSpec spec2 = this.service.create(spec);
		assertThat(spec2.getName()).isEqualTo(spec.getName());
	}
	
	@Test (expected=RuntimeException.class)
	public void testCreateWhenIsDuplication() {
		ItemSpec spec = new ItemSpec("A", 50.00, 130.00, 3);
		this.service.create(spec);
		fail("Shouldn't reach here");
	}
	
	@Test
	public void testList() {
		List<ItemSpec> list = this.service.list();
		assertThat(list.size()).isEqualTo(6);
	}

}
