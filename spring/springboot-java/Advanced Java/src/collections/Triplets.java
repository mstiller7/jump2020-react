package collections;

public class Triplets<T> {
	
	private T oldest;
	private T middle;
	private T youngest;
	
	// when we add a triplet, add oldest to youngest
	public boolean add(T child) {
		if (oldest == null) {
			oldest = child;
			return true;
		}
		else if (middle == null) {
			middle = child;
			return true;
		}
		else if (youngest == null) {
			youngest = child;
			return true;
		} else {
			return false;
		}
	}
	
	public T get(int child) {
		
		if (child == 1) {
			return this.oldest;
		} else if (child == 2) {
			return this.middle;
		} else if (child == 3) {
			return this.youngest;
		} else return null;
		
	}

	@Override
	public String toString() {
		return "Triplets [oldest=" + oldest + ", middle=" + middle + ", youngest=" + youngest + "]";
	}
	

}
