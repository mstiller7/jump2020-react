package TestHello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRequestController {
	@RequestMapping("/")
	public String home() {
		return "Spring boot web is working!";
	}
}
