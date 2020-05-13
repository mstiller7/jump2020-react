package functional.streams;

class DataPrinter {
	
	public static void main(String[] args) {
		
		PrintData pd = (x) -> {
			StringBuilder sb = new StringBuilder(x);
			System.out.println("Data: " + sb.reverse().toString());
		};
		
		pd.print("New lambda.");
		
		pd = new PrintData() {
			@Override
			public void print(String data) {
				StringBuilder sb = new StringBuilder(data);
				System.out.println("Data: " + sb.reverse().toString());
			}
		};
		
		pd.print("Anonymous method.");
	}
}

@FunctionalInterface
interface PrintData {
	void print(String data);
}