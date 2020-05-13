import java.io.IOException;

public class TestMain {
	
	public static void main(String[] args) throws IOException {
		 ProcessBuilder processBuilder = new ProcessBuilder("jshell", "--execution local");
	      Process process = processBuilder.start();

	      process.getOutputStream();
	      
	      System.out.println("-- process handle --");
	      
	      ProcessHandle processHandle = process.toHandle();
	}

}
