import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryNavigatorWithFiles {

	static long finalCount = 0;
	static long finalCount1 = 0;

	public static void main(String[] args) throws IOException {

		String filepath = args[0];

		File file = new File(filepath);

		if (file.exists()) {
			printDirectory(file);
//			if (file.isDirectory())
//				printDirectory(file);
//			else
//				System.out.println(file.getName());
		}

		System.out.println("Final Count 1:" + finalCount);
		System.out.println("Final Count:" + finalCount);
	}

	private static void printDirectory(File folder) throws IOException {

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
						
//						Files.lines(Path.of(file.toURI())).count();
//						Scanner scanner = new Scanner(file);
//						while (scanner.hasNextLine()) {
//							++count;
//							scanner.nextLine();
//						}
//						scanner.close();
//
//						finalCount1 += count;
						
						
						finalCount += Files.lines(Path.of(file.toURI())).count();
						System.out.println(file.getName() + ":::::>" + count);

					}
				}

			}
		}
	}
}
