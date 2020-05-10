package com.example.junitdemo.controller;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.junitdemo.model.Item;
import com.example.junitdemo.service.ItemService;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemService itemService;
	
	@Test
	public void testGetDummyItem_basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:1,name:\"Product 1\",price:25,quantity:15}")).andReturn();
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}
	
	@Test
	public void testGetDummyItemService_basic() throws Exception {
		when(itemService.getItem(anyInt())).thenReturn(Optional.of(new Item(1, "Product 1", 20, 15)));
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item-service").param("id", "10001")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:1,name:\"Product 1\",price:20,quantity:15}")).andReturn();
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}
	
	@Test
	public void testGetAllItems_basic() throws Exception {
		List<Item> mockList = new ArrayList<>();
		mockList.add(new Item(1, "Product 1", 20, 15));
		mockList.add(new Item(2, "Product 2", 10, 20));
		when(itemService.getAllItems()).thenReturn(mockList);
		RequestBuilder request = MockMvcRequestBuilders
				.get("/items")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:1,name:\"Product 1\",price:20,quantity:15},{id:2,name:\"Product 2\",price:10,quantity:20}]")).andReturn();
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}

}
