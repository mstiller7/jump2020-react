@FunctionalInterface
public interface Calculator<T> {
	T operation( T a, T b);
}
