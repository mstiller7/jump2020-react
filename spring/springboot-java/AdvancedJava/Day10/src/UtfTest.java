import java.nio.charset.StandardCharsets;

public class UtfTest {
	public static void main(String[] args) {
		String s = new String("汉字".getBytes(), StandardCharsets.UTF_8);
		
		System.out.println(s);
	}

}
