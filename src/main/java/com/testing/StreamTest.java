package com.testing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest 
{
	public static void main(String[] args) 
	{
		List<String> myList = Arrays.asList("apple", "ant", "ball", "bat", "cat", "cake");
		
		myList.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase).sorted().forEach(System.out::println);
		
		//2nd example
		Stream.of("apple", "ant", "ant", "ball").distinct().forEach(System.out::println);
		
		//3rd example
		Arrays.stream(new int[] {1, 2, 3,}).map(n -> 2 * n + 1).average().ifPresent(System.out::println);
	}
	

}
