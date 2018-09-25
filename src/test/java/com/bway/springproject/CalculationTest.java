package com.bway.springproject;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.testing.Calculation;

public class CalculationTest 
{
	static Calculation c;
	
	@BeforeClass
	public static void init()
	{
		c = new Calculation();
		System.out.println("====init method loaded====");
	}
	
	@Test
	public void squareTest()
	{
		int res = c.square(5);
		assertEquals(res, 25);
	}
	
	@Test
	public void SITest()
	{
		int res = c.SI(5, 5, 4);
		assertEquals(res, 1);
	}
	
}
