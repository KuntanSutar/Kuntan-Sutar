package com.techlab.strategy.pattern;

public class Adition implements IStrategy {

	@Override
	public int doArithmeticOperation(int num1, int num2) {
		return num1 + num2;
	}

}
