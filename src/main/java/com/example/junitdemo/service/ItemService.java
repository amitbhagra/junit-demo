package com.example.junitdemo.service;

import java.util.List;
import java.util.Optional;

import com.example.junitdemo.model.Item;

public interface ItemService {
	public Optional<Item> getItem(Integer id);
	
	public List<Item> getAllItems();
}
