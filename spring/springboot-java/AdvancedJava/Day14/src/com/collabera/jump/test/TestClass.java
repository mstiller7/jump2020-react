package com.collabera.jump.test;
import java.util.Arrays;

import javax.swing.JFrame;

import com.collabera.jump.GSorter;
import com.collabera.jump.HelloLambda;


public class TestClass {

	public static void main(String[] args) {
		
		
		JFrame jframe = new JFrame();
		
		HelloLambda hello = new HelloLambda();
		
		hello.print();
		
		GSorter<Integer>  sorter = x -> {
			 Arrays.sort(x);
			 return x;
		};
		
		
		Integer[] intArray = { 500, 1,5,100};
		
		System.out.println(Arrays.toString(sorter.sort(intArray)));
		
		
	}
	
	
}
