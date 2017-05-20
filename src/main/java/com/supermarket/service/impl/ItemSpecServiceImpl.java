package com.supermarket.service.impl;

import java.util.ArrayList;
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
	public ItemSpec create(ItemSpec itemSpec) {
		final String name = itemSpec.getName();
		if (this.nameToItemSpecMap.get(name) != null) {
			throw new RuntimeException("Oops, ItemSpec already exists - " + name);
		}
		
		this.nameToItemSpecMap.put(name, itemSpec);
		return this.nameToItemSpecMap.get(name);
	}

	@Override
	public ItemSpec update(ItemSpec itemSpec) {
		final String name = itemSpec.getName();
		if (this.nameToItemSpecMap.get(name) == null) {
			throw new RuntimeException("Oops, ItemSpec does not exist - " + name);
		}
		
		this.nameToItemSpecMap.put(name, itemSpec);
		return this.nameToItemSpecMap.get(name);
	}

	@Override
	public void delete(String name) {
		if (this.nameToItemSpecMap.get(name) != null) {
			this.nameToItemSpecMap.remove(name);
		}
	}

	@Override
	public List<ItemSpec> list() {
		return new ArrayList<ItemSpec>(this.nameToItemSpecMap.values());
	}

}
