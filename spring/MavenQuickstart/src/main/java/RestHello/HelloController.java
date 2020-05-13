package RestHello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private static final String helloWorldTemplate = "Hello %s!";
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Web!";
	}
	
	HelloWeb helloWeb = new HelloWeb();
	
	
	@GetMapping("/helloweb/name/{name}")
	public HelloWeb helloObject(@PathVariable String name) {
		helloWeb.setMessage(String.format(helloWorldTemplate, name));
		return helloWeb;
	}
	
	
	/*
	 * @GetMapping("/helloweb/name") public HelloWeb helloWithObject(@RequestParam
	 * String name) { helloWeb.setMessage(String.format(helloWorldTemplate, name));
	 * return helloWeb; }
	 */
	
}
