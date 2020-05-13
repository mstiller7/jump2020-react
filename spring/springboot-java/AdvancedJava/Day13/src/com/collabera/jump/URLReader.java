package com.collabera.jump;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLReader {

	public static void main(String[] args) throws IOException {

		// URI uri = new
		// URI("https://docs.oracle.com/javase/8/docs/api/java/util/TreeSet.html");

		URL url = new URL(args[0]);
		
		InputStream is = url.openStream();
		long startTime = System.currentTimeMillis();
		int data = is.read();
		StringBuilder sb = new StringBuilder();
		//StringBuffer sb = new StringBuffer();
		while (data != -1) {
			sb.append((char) data);
			data = is.read();
		}

		//is.rea
		
		String dataStr = sb.toString();

		String[] strs = dataStr.toLowerCase().split("collection");

		System.out.println(strs.length - 1);

		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println(totalTime);
		is.close();
//	
//		is = url.openStream(); 
//		
//		Scanner scanner = new Scanner(is);
//		int count =0;
//		startTime = System.currentTimeMillis();
//		while(scanner.hasNext())
//		{
//			String str = scanner.next().toLowerCase();
//			System.out.println(str);
//			if(str.contains("contains"))
//				++count;
//			
//		}
//		
//		totalTime = System.currentTimeMillis() - startTime;
//		System.out.println(count);
//		System.out.println(totalTime);
//		

		// System.n

	}
}
