package Sample;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class HelloWorld {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(HelloWorld.class, args);
		String[] beanNames = context.getBeanDefinitionNames();
		System.out.println("Beans count:" + context.getBeanDefinitionCount());
		
		Arrays.sort(beanNames); //optional
		
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
	
}

