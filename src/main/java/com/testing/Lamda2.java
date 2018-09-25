package com.testing;

import java.util.Arrays;
import java.util.List;

interface Test
{
	void show();
}

//class C implements Test
//{
//
//	@Override
//	public void show() 
//	{
//		System.out.println("welcome");		
//	}
//	
//	
//}

public class Lamda2 
{
	public static void main(String[] args) 
	{
//		Test t = new C();
//		t.show();
		
		Test t1 = () ->{
			System.out.println("lambda expression!!");
		};
		
		t1.show();
		
		List<Integer> dList = Arrays.asList(10, 20, 40, 50);
		dList.forEach(x -> System.out.println(x));
	}

}
