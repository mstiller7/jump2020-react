package collections;

public class GenericsExample {

	public static void main(String[] args) {
		
		Triplets<String> triplets = new Triplets<>();
		
		triplets.add("one");
		triplets.add("two");
		triplets.add("three");
		
		System.out.println(triplets);
		
		System.out.println(triplets.add("four"));
		
//		Triplets<Integer> ints = new Triplets<>();
		
	}
	
}
