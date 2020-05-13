package threads;

public class NumThread extends Thread {
	
	// should override Thread's run() method
	// contains the operation to do while the thread is running
	public void run() {
		
		System.out.println("Starting Thread" + Thread.currentThread().getId());
		
		super.run();
	}
	

}
