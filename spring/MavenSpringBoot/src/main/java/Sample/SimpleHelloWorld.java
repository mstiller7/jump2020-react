package Sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SimpleHelloWorld {
	public static void main(String[] args) {
		SpringApplication.run(SimpleHelloWorld.class, args);
	}
}
