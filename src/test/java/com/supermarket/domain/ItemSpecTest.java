package com.supermarket.domain;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class ItemSpecTest {
	
	@Test
	public void testCreate() {
		ItemSpec spec = new ItemSpec("A", 50.00, 130.00, 2);
		assertThat(spec.getUnitForSpecialPrice()).isEqualTo(2);
		
		spec = new ItemSpec("A", 50.00, -130.00, -2);
		assertThat(spec.getUnitForSpecialPrice()).isEqualTo(0);
		assertThat(spec.getSpecialPrice()).isEqualTo(0);
	}

	@Test
	public void testHasSpecialPrice() {
		ItemSpec spec = new ItemSpec("A", 50.00, 130.00, 3);
		assertThat(spec.hasSpecialPrice()).isTrue();
		
		spec = new ItemSpec("A", 50.00, 130.00, 0);
		assertThat(spec.hasSpecialPrice()).isFalse();
		
		spec = new ItemSpec("A", 50.00, 0, 10);
		assertThat(spec.hasSpecialPrice()).isFalse();
	}
	
	@Test
	public void testEqualsAndHashCode() {
		ItemSpec spec1 = new ItemSpec("A", 50.00, 130.00, 3);
		ItemSpec spec2 = new ItemSpec("A", 40.00, 132.00, 4);
		assertThat(spec1).isEqualTo(spec2);
		assertThat(spec1.hashCode() == spec2.hashCode()).isTrue();
		
		ItemSpec spec3 = new ItemSpec("B", 40.00, 132.00, 4);
		ItemSpec spec4 = new ItemSpec("C", 40.00, 132.00, 4);
		assertThat(spec3).isNotEqualTo(spec4);
		assertThat(spec3.hashCode() != spec4.hashCode()).isTrue();
	}

}
