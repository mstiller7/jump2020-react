package RestHello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloObject {
	@Autowired
	HelloWeb helloWeb;
	
	@GetMapping("/helloweb")
	public HelloWeb helloObject() {
		helloWeb.setMessage("Hello Web from Bean");
		return helloWeb;
	}
}