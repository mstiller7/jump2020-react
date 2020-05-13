import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DirectoryNavigator {

	static long finalCount = 0;

	public static void main(String[] args) throws FileNotFoundException {

		String filepath = args[0];

		File file = new File(filepath);

		if (file.exists()) {
			printDirectory(file);
//			if (file.isDirectory())
//				printDirectory(file);
//			else
//				System.out.println(file.getName());
		}

		System.out.println("Final Count:" + finalCount);
	}

	private static void printDirectory(File folder) throws FileNotFoundException {

		if (folder.isDirectory()) {
			for (File file : folder.listFiles()) {

				long count = 0;

				if (file.isDirectory()) {

					File[] files = file.listFiles();

					System.out.println(
							"====== Directory: " + file.getName() + " : Contains: " + files.length + " Files ========");

					printDirectory(file);
				} else {

					// System.out.println("Filename :" + file.getName());

					if (file.getName().endsWith(".java")) {
						Scanner scanner = new Scanner(file);
						while (scanner.hasNextLine()) {
							++count;
							scanner.nextLine();
						}
						scanner.close();

						finalCount += count;
						System.out.println(file.getName() + ":::::>" + count);

					}
				}

			}
		}
	}
}
