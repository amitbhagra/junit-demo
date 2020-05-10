package com.example.junitdemo.service.impl;

import com.example.junitdemo.service.SimpleCalculateService;

public class SimpleCalculateServiceImpl implements SimpleCalculateService {

	@Override
	public int sum(int[] arr) {
		int sum = 0;
		if (arr != null) {
			for (int val : arr) {
				sum = sum + val;
			}
		}
		return sum;
	}

}
