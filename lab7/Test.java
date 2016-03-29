package lab7;

import java.io.*;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		// //creating File instance to reference text file in Java
		// File text = new
		// File("/home/ugrad22/hngo/workspace/CS272/src/lab7/test.txttest.txt");
		//
		// //Creating Scanner instance to read File in Java
		// Scanner scnr = new Scanner(text);
		//
		// //Reading each line of file using Scanner class
		// int lineNumber = 1;
		// while(scnr.hasNextLine()){
		// String line = scnr.nextLine();
		// System.out.println( line);
		// lineNumber++;
		// }

		Scanner input = null;
		String filename = "transactions.txt";
		try {
			input = new Scanner(new FileInputStream(filename));
		} catch (FileNotFoundException fnfe) {
			System.out.println("File " + filename
					+ " was not found or could not be opened.");
			System.exit(0);
		}

	}
}
