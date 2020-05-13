package annotations;

@SV("/hello")

@MV(value = "New Value", count = 10, path = "Some_path")
public class TestAnnotation {

	@MyAnnotation
	private String reverse(String data) {
		return new StringBuilder(data).reverse().toString();
	}

}