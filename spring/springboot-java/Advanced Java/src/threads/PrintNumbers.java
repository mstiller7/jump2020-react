package threads;

public class PrintNumbers {

	static public void main(String[] args) {
		
		System.out.println("Main ThreadId: " + Thread.currentThread().getId());
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread3 ThreadId: " + Thread.currentThread().getId());
				// do our thing
				printNumbers();
			}
		}).start(); // don't call run! ...
		printNumbers();
	}

//	static public void main(String[] args) {
//		System.out.println("Main ThreadId: " + Thread.currentThread().getId());
//		for (int i = 0; i < 3; i++) {
//			new Thread(new Thread2()).start();
//			// again, don't call run!
//			// (if you want a separate thread)
//		}
//		printNumbers();
//	}

//	static public void main(String[] args) {
//		System.out.println("Main ThreadId: " + Thread.currentThread().getId());
//
//		for (int i = 0; i < 3; i++) {
//			new Thread1().start(); // don't call run! // (if you want a separate thread)
//		}
//
//		printNumbers();
//	}

	static public void printNumbers() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getId() + ": " + i);
		}
	}
}