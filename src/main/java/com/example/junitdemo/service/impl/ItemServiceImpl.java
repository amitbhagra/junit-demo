package com.example.junitdemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.junitdemo.model.Item;
import com.example.junitdemo.repository.ItemRepository;
import com.example.junitdemo.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Optional<Item> getItem(Integer id) {
		return itemRepository.findById(id);
	}

	@Override
	public List<Item> getAllItems() {
		List<Item> items =  itemRepository.findAll();
		for (Item item: items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return items;
	}

}
