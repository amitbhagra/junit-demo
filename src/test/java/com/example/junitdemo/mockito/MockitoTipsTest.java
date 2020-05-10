package com.example.junitdemo.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTipsTest {

	@Mock
	List<Integer> mockList;

	@Test
	public void testVerificationBasics() {
		//SUT
		mockList.get(0);
		mockList.get(1);
		
		//Verification
		verify(mockList).get(0);
		verify(mockList, times(2)).get(anyInt());
		verify(mockList, atLeastOnce()).get(anyInt());
		verify(mockList, atMost(2)).get(anyInt());
		verify(mockList, never()).get(2);
	}
	
	@Test
	public void testArgumentCapturing() {
		//SUT
		mockList.add(5);
		
		
		//Verification
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class); 
		verify(mockList).add(captor.capture());
		
		assertEquals(Integer.valueOf(5), captor.getValue());
		
	}
	
	@Test
	public void testMultipleArgumentCapturing() {
		//SUT
		mockList.add(5);
		mockList.add(6);
		
		
		//Verification
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class); 
		verify(mockList, times(2)).add(captor.capture());
		
		assertEquals(Integer.valueOf(5), captor.getAllValues().get(0));
		assertEquals(Integer.valueOf(6), captor.getAllValues().get(1));
		
	}

}
