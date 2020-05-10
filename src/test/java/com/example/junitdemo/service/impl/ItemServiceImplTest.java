package com.example.junitdemo.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.junitdemo.model.Item;
import com.example.junitdemo.repository.ItemRepository;
import com.example.junitdemo.service.ItemService;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceImplTest {

	@InjectMocks
	private ItemService itemService = new ItemServiceImpl();
	
	@Mock
	private ItemRepository itemRepository;
	
	@Test
	public void testGetAllItems_basic() {
		List<Item> mockList = new ArrayList<>();
		mockList.add(new Item(1, "Product 1", 20, 15));
		mockList.add(new Item(2, "Product 2", 10, 20));
		when(itemRepository.findAll()).thenReturn(mockList);
		
		List<Item> items = itemService.getAllItems();
		assertEquals(300, items.get(0).getValue());
		assertEquals(200, items.get(1).getValue());
	}

}
