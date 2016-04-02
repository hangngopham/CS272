package lab8;

import java.io.*;
import java.util.*;
/**
 * Calculate the capital gain.
 * @author Hang Ngo
 *
 */
public class CapitalGain {
	public static void main(String[] args) throws IOException {
		// Prompt the user for the name of the file containing a sequence of transactions
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter transactions file name: ");
		String filename = input.next();
		try {
			input = new Scanner(new FileInputStream(filename));
		} catch (FileNotFoundException fnfe) {
			System.out.println("File " + filename + " was not found or could not be opened.");
			System.exit(0);
		}

		System.out.println("The following transactions were read from the file: ");

		boolean sell = false;
		int number = 0;
		int price = 0;

		LinkedQueue<Transaction> all = new LinkedQueue<Transaction>();
		LinkedQueue<Transaction> buy = new LinkedQueue<Transaction>();

		while (input.hasNext()) {
			String token = input.next();
			if (token.equals("buy")) {
				sell = false;
			} else if (token.equals("sell")) {
				sell = true;
			}
			if (input.hasNextInt()) {
				token = input.next();
				number = Integer.parseInt(token);
				input.next();
				input.next();
				token = input.next();
				String token1 = token.substring(1);
				price = Integer.parseInt(token1);
			}
			token = input.nextLine();
			Transaction p = new Transaction(sell, number, price);
			all.add(p);
			System.out.println("\t" + p);
		} // end while

		System.out.println();

		int numSell = 0;
		int sellPrice = 0;
		int numBuy = 0;
		int buyPrice = 0;
		int capital = 0;
		boolean skip = true;
		while (!all.isEmpty() && skip) {
			Transaction front = all.peek();

			if (!front.isSell()) {
				System.out.println("Processing transaction: " + all.peek());
				buy.add(all.peek());
				all.remove();
			}

			if (front.isSell()) {
				System.out.println("Processing transaction: " + all.peek());
				numSell = front.getNumber();
				sellPrice = front.getPrice();

				while (!buy.isEmpty() && numSell > 0) {
					Transaction buyFront = buy.peek();

					numBuy = buyFront.getNumber();
					buyPrice = buyFront.getPrice();

					if (numSell > numBuy) {
						capital += numBuy * (sellPrice - buyPrice);
						numSell = numSell - numBuy;
						all.peek().changeNumber(numSell);
						numBuy = 0;
						buy.remove();

					} else {
						capital += numSell * (sellPrice - buyPrice);
						numBuy = numBuy - numSell;
						buy.peek().changeNumber(numBuy);
						numSell = 0;
						all.remove();
					}
				} // end while
				if (numSell > 0) {
					skip = false;
					System.out.println("Error: attempt to sell non-existing shares!");
				}
			} // end if
		} // end while

		System.out.println();
		if (skip) {
			int leftShare = 0;
			while (!buy.isEmpty()) {
				leftShare += buy.peek().getNumber();
				buy.remove();
			}
			System.out.println("Capital gain is $" + capital + ".");
			System.out.println("There are " + leftShare + " shares left.");
		}

	}
}
