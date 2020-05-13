package Sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyHello {
	
	@Value("${message}")
	private String msg = "Component Bean Msg";
	
	public MyHello() {
		System.out.println("MyHello");
		System.out.println(msg);
	}
	
	public String getMsg() {
		return msg;
	}
}