package lab4;

import java.util.Scanner;

public class DNA {

	/**
	 * Take a String and convert it into a linked list of characters. If the
	 * string is empty then the method should return null. The program should
	 * prompt the user to enter a DNA strand and use this method to convert the
	 * string user entered into a linked list of characters.
	 * 
	 * @param userDNA
	 * @return null if the string is empty
	 * @return a linked list of characters entered by user
	 */
	public static CharNode stringToList(String userDNA) {
		if (userDNA == null || userDNA.length() == 0) {
			return null;
		}

		CharNode head;
		CharNode temp;

		head = new CharNode(userDNA.charAt(0), null);
		temp = head;
		for (int i = 1; i < userDNA.length(); i++) {
			CharNode c = new CharNode(userDNA.charAt(i), null);
			temp.setLink(c);
			temp = temp.getLink();
		}

		return head;
	}

	/**
	 * Take a DNA strand and produce the corresponding mRNA sequence
	 * 
	 * @param userDNA
	 *            - the head of DNA strand
	 * @return the head of the corresponding mRNA sequence
	 */
	public static CharNode dnaToRNA(CharNode dnaList) {
		if (dnaList == null) {
			return null;
		}

		String dnaString = dnaList.toString();
		CharNode dnaListUpper = stringToList(dnaString.toUpperCase());
		CharNode mraList = new CharNode(dnaListUpper.getData(), null);
		CharNode temp = mraList;

		if (dnaListUpper.getData() == 'C') {
			mraList.setData('G');
		} else if (dnaListUpper.getData() == 'T') {
			mraList.setData('A');
		} else if (dnaListUpper.getData() == 'G') {
			mraList.setData('C');
		} else if (dnaListUpper.getData() == 'A') {
			mraList.setData('U');
		}
		CharNode cursor;
		CharNode beforeCursor = mraList;
		for (cursor = dnaListUpper.getLink(); cursor != null; cursor = cursor
				.getLink()) {
			if (cursor.getData() == 'C') {
				temp = new CharNode('G', null);
			} else if (cursor.getData() == 'T') {
				temp = new CharNode('A', null);
			} else if (cursor.getData() == 'G') {
				temp = new CharNode('C', null);
			} else if (cursor.getData() == 'A') {
				temp = new CharNode('U', null);
			}
			beforeCursor.setLink(temp);
			beforeCursor = temp;
		}
		return mraList;
	}

	/**
	 * Determine whether these two lists can be perfectly aligned (whether the
	 * shorter list is a sublist of the longer list)
	 * 
	 * @param head1
	 *            - head of the shorter list
	 * @param head2
	 *            - head of the longer list
	 * @return true if there exists a perfect alignment between the lists
	 * @return false if there exists no perfect alignment between the lists
	 */
	public static boolean perfAlignment(CharNode head1, CharNode head2) {
		int length1 = CharNode.listLength(head1);
		int length2 = CharNode.listLength(head2);

		if (length1 > length2) {

			if (head1 == null || head2 == null) {
				return false;
			}

			CharNode current2 = head2;
			
			L1: for(CharNode cursor = head1; cursor != null; cursor = cursor.getLink())
			{
				if(cursor.getData() == head2.getData()) {
					for(current2 = head2; current2 != null; current2 = current2.getLink()) {
						if(current2.getData() != cursor.getData()) {
							continue L1;
						}
						cursor = cursor.getLink();
					}
					return true;
				}
			
			}
			
		 
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a DNA strand: ");
		String userDNA = input.nextLine();

		while (userDNA == null || userDNA.length() == 0) {
			System.out
					.println("The one you entered is null or empty. Please enter a DNA strand: ");
			userDNA = input.nextLine();
		}
		System.out.println("You entered: " + userDNA);

		System.out.println("Your DNA list is " + userDNA);
		CharNode dna = DNA.stringToList(userDNA);

		CharNode rna = DNA.dnaToRNA(dna);
		if (rna != null)
			System.out.println("Corresponding nRNA is " + rna.toString());

		System.out.print("Please enter sequence 1: ");
		String longList = input.nextLine();
		System.out.println("You entered: " + longList);
		CharNode longHead = DNA.stringToList(longList);

		System.out.print("Please enter sequence 2: ");
		String shortList = input.nextLine();
		System.out.println("You entered: " + shortList);
		CharNode shortHead = DNA.stringToList(shortList);

		if (DNA.perfAlignment(longHead, shortHead)) {
			System.out.println("The sequence can be perfectly aligned");
		} else {
			System.out.println("The sequence can NOT be perfectly aligned");
		}

	}
}
