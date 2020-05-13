package exercises.kitchen;

public class Chef implements Runnable {

	private Orders orders;

	public Chef(Orders orders) {
		this.orders = orders;
	}

	@Override
	public void run() {

		// basic structure:
		// 1) define what object you want to wait for a lock on, and await notification
		// after the try-catch
		// 2) once notified, obtain the lock and do whatever

		String name = Thread.currentThread().getName();

		synchronized (orders) {

			try {

				// better to assign a less-local variable so that the lock can be released afterward
				System.out.println(name + " waiting for an order to prepare");
				orders.wait();

			} catch (Exception e) {
				e.printStackTrace();
			}

			String order = orders.nextOrder();
			if (order == null) {
				System.out.println("no orders at this time, " + name + " can rest");
			} else {
				System.out.println(name + " received order for " + order);
				System.out.println(name + " preparing " + order);
				System.out.println(name + " completed order for " + order);
			}

		}

	}

}
