package com.collabera.jump.fi;

public class PrintMyData {

	public static void main(String[] args) {
		
		PrintData printData = (x) -> {
			
			StringBuilder sb = new StringBuilder(x);
			
			System.out.println("Data : "+ sb.reverse().toString());
		};
		

		printData.print("Hi this is a new Lambda");
		
		
		PrintData pd = new PrintData() {
			
			@Override
			public void print(String data) {
				StringBuilder sb = new StringBuilder(data);
				
				System.out.println("Data : "+ sb.reverse().toString());
				
			}
		};
		
		pd.print("Hi this is a new Lambda");
	}
}
