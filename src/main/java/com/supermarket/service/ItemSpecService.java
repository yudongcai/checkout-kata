package com.supermarket.service;

import java.util.List;

import com.supermarket.domain.ItemSpec;

public interface ItemSpecService {
	
	ItemSpec getItemSpecByName(String name);
	
	ItemSpec create(ItemSpec itemSpec);
	
	ItemSpec update(ItemSpec itemSpec);
	
	void delete(String name);
	
	List<ItemSpec> list();

}
