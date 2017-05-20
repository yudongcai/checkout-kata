package com.supermarket.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.supermarket.domain.ItemSpec;
import com.supermarket.service.ItemSpecService;

@Service
public class ItemSpecServiceImpl implements ItemSpecService {
	
	//To be replaced with a DAO
	private Map<String, ItemSpec> nameToItemSpecMap = new HashMap<>();

	@Override
	public ItemSpec getItemSpecByName(String name) {
		return this.nameToItemSpecMap.get(name);
	}

	@Override
	public void create(ItemSpec itemSpec) {
		final String name = itemSpec.getName();
		if (this.nameToItemSpecMap.get(name) != null) {
			throw new RuntimeException("Oops, ItemSpec already exists - " + name);
		}
		
		this.nameToItemSpecMap.put(name, itemSpec);
	}

	@Override
	public void update(ItemSpec itemSpec) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ItemSpec> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
