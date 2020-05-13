package ConfigClientPackage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
	
	@Value("${message}")
	private String message;
	
	@Value("${server.port}")
	private int port;
	
	@Value("${user.role}") 
	private String role;
	  
	@GetMapping
	public String getUserRole()
	{
		return this.role +"==>"+ this.message+"==>"+ this.port;
	}
	
	@GetMapping("port")
	public String getPort()
	{
		return this.port+"";
	}
	
	 @GetMapping("/profile/{name}") 
	 public String getActiveProfie(@PathVariable String name) { 
		 return "Hello "+name+"! active profile role is "+ role; 
		 }
	 
}
