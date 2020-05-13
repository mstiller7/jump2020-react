package threads;

public class Thread1 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread1 ThreadId: " + Thread.currentThread().getId());
		// do our thing
		PrintNumbers.printNumbers();
		// the super doesn't anything,
		// but just for the courtesy and good practice
		super.run();
	}
}