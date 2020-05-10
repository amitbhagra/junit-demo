package com.example.junitdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.junitdemo.model.Item;
import com.example.junitdemo.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/dummy-item")
	public Item getDummyItem() {
		return new Item(1, "Product 1", 25, 15);
	}
	
	@GetMapping("/dummy-item-service")
	public Item getDummyItemFromService(@RequestParam Integer id) {
		return itemService.getItem(id).get();
	}
	
	@GetMapping("/items")
	public List<Item> getItems() {
		return itemService.getAllItems();
	}
	
	
	
}
