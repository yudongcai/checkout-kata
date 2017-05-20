package com.supermarket.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.supermarket.domain.ItemSpec;
import com.supermarket.service.ItemSpecService;

@Service
public class ItemSpecServiceImpl implements ItemSpecService {
	
	//To be replaced with a DAO
	private Map<String, ItemSpec> nameToItemSpecMap = new HashMap<>();
	
	@PostConstruct
	public void setup() throws Exception {
		create(new ItemSpec("A", 50.00, 130.00, 3));
		create(new ItemSpec("B", 30.00, 45.00, 2));
		create(new ItemSpec("C", 20.00, 0, 0));
		create(new ItemSpec("D", 15.00, 0, 0));
		create(new ItemSpec("E", 10.00, 0, 0));
		create(new ItemSpec("F", 5.00, 0, 0));
	}

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
