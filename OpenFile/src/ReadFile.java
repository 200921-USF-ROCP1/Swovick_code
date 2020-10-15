import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	public static void main(String[] args) {
		File aFile = new File("test.txt");
		try {
			Scanner scan = new Scanner(aFile);
			System.out.println("Success!");
			System.out.println(aFile.getAbsolutePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(aFile.exists());
		
	}
}
