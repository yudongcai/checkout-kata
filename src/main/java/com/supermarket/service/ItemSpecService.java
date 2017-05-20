package com.supermarket.service;

import java.util.List;

import com.supermarket.domain.ItemSpec;

public interface ItemSpecService {
	
	ItemSpec getItemSpecByName(String name);
	
	void create(ItemSpec itemSpec);
	
	void update(ItemSpec itemSpec);
	
	void delete(String name);
	
	List<ItemSpec> list();

}
