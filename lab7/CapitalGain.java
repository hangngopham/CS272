package lab7;

import java.io.*;
import java.util.*;

public class CapitalGain {
	public static void main(String[] args) throws IOException {
		// Scanner input = new Scanner(System.in);
		// System.out.print("Please enter transactions file name: ");
		// String filename = input.nextLine();
		// File file = new File(filename);
		// Scanner myFile = new Scanner(file);

		Scanner input = null;
		try {
			input = new Scanner(
					new FileInputStream(
							"/home/ugrad22/hngo/workspace/CS272/src/lab7/transactions.txt"));
		} catch (FileNotFoundException fnfe) {
			System.out.println("File " + "transactions.txt"
					+ " was not found or could not be opened.");
			System.exit(0);
		}
		System.out
				.println("The following transactions were read from the file: ");
		
		boolean sell;
		while (input.hasNext()) {
			String token = input.next();
			System.out.println(token);
			
			if (token.equals("buy")) {
				sell = false;
				//System.out.println("Buy");
			} else if (token.equals("sell")) {
				sell = true;
				//System.out.println("Sell");
			} else if (input.hasNextInt()) {
				int number;
				int price;
				number = input.nextInt();
				input.next();
				input.next();
				token = input.next();
				price = Integer.parseInt(token);
				System.out.println(number + " " + price);
				System.out.println("asdf");
			}
			else if(token == "shares") {
				token = input.next();
			}
			
		}

	}
}
