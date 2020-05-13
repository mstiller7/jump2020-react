package assignments.diamond;

public interface IB extends IA{
	void printIB();
	
	@Override
	default void printIA(String data) {
		// TODO Auto-generated method stub
		IA.super.printIA(data);
	}
	
	
}
