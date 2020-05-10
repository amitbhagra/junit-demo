package com.example.junitdemo.service.impl;

import com.example.junitdemo.dao.CalculateDAO;
import com.example.junitdemo.service.CalculateService;



public class CalculateServiceImpl implements CalculateService {
	
	private CalculateDAO calculatorDAO;
	
	public CalculateServiceImpl(CalculateDAO calculatorDAO) {
		super();
		this.calculatorDAO = calculatorDAO;
	}

	public int sum() {
		int[] arr = calculatorDAO.retrieveCalculationData();
		int sum = 0;
		if (arr != null) {
			for (int val : arr) {
				sum = sum + val;
			}
		}
		return sum;
	}

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
