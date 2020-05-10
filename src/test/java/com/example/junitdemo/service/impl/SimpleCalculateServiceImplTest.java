package com.example.junitdemo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.example.junitdemo.service.SimpleCalculateService;

public class SimpleCalculateServiceImplTest {

	@Test
	public void testSum_basic() {
		SimpleCalculateService service = new SimpleCalculateServiceImpl();
		int actual = service.sum(new int[] {1,2,3});
		int expected = 6;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSum_emptyInput() {
		SimpleCalculateService service = new SimpleCalculateServiceImpl();
		int actual = service.sum(new int[] {});
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSum_nullInput() {
		SimpleCalculateService service = new SimpleCalculateServiceImpl();
		int actual = service.sum(null);
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	

}
