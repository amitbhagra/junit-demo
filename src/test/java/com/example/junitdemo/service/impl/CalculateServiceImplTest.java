package com.example.junitdemo.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.junitdemo.dao.CalculateDAO;
import com.example.junitdemo.service.CalculateService;

@RunWith(MockitoJUnitRunner.class)
public class CalculateServiceImplTest {
	
	CalculateService service;
	
	@Mock
	CalculateDAO calculateDAO;
	
	@Before
	public void setup() {
		service = new CalculateServiceImpl(calculateDAO);
	}
	
	@Test
	public void testSum_basic() {
		when(calculateDAO.retrieveCalculationData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, service.sum());
	}
	
	@Test
	public void testSum_emptyInput() {
		when(calculateDAO.retrieveCalculationData()).thenReturn(new int[] {});
		assertEquals(0, service.sum());
	}
	
	@Test
	public void testSum_nullInput() {
		when(calculateDAO.retrieveCalculationData()).thenReturn(null);
		assertEquals(0, service.sum());
	}
	
	
	
}
