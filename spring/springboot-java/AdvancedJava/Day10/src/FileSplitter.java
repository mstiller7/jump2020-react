import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSplitter {

	public static void main(String[] args) throws IOException {

		File file = new File("longfile.txt");
		/*
		 * int count = 1; PrintWriter pw = new PrintWriter(file); while (count<=5000) {
		 * pw.println("Line "+count); count ++;
		 * 
		 * } pw.close();
		 */

		// To know the number of files in the file to be split.
		int count = 0;
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			++count;
			scanner.nextLine();
		}

		scanner.close();

		// Asking for number of files to be generated.
		Scanner scanner1 = new Scanner(System.in);

		System.out.println("Number of Files to be Split To:");
		int number = scanner1.nextInt();

		scanner1.close();

		// Logic
		int lines = count / number;

		Scanner scanner2 = new Scanner(file);
		for (int i = 1; i <=number; i++) {
			
			//creating number of files
			PrintWriter pw = new PrintWriter("File" + i);

			for (int j = 0; j < lines; j++) {
				if (scanner2.hasNextLine()) {
					pw.println(scanner2.nextLine());
				}
			}
			pw.close();
		}

		//leftover lines will be appended to the last file.
		/*
		 * The last file needs to be appended as the file would already contain the lines.
		 */
		if (scanner2.hasNextLine()) {
			PrintWriter pw = new PrintWriter(new FileWriter("File" + number, true));
			while (scanner2.hasNextLine())
				pw.println(scanner2.nextLine());
			pw.close();
		}

		scanner2.close();

	}

}
