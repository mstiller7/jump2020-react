package assignments;

import java.util.stream.IntStream;

public class ThreadsPrintNumbers {

//	Write a java program using multithreading to print 5 and 10 times table till 500. 

	public static void main(String[] args) {

		int i = 0;

		System.out.println("Main ThreadId: " + Thread.currentThread().getId());

		// do this 3 times:
		IntStream.range(0, 3).forEach($ -> {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (i < 500) {
						System.out.println(Thread.currentThread().getId() + ":" + i);
					}
				}
			}).start();
		});

	}
	
}