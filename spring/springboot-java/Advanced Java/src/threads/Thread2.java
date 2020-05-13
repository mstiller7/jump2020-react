package threads;

public class Thread2 implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread2 ThreadID: " + Thread.currentThread().getId());
		// do our thing
		PrintNumbers.printNumbers();
	}

}
