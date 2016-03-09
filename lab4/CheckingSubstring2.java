package lab4;

import java.util.*;
import java.lang.String;

public class CheckingSubstring2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a String: ");
		String string1 = input.next();
		System.out.print("Please enter a second String: ");
		String string2 = input.next();
		if (isSubstring(string1, string2)) {
			System.out
					.println("The first string is a substring of the second.");
		} else {
			System.out
					.println("The first string is NOT a substring of the second.");
		}
	}

	public static boolean isSubstring(String string1, String string2) {
		char c;
		char d;
		boolean match = true;
		for (int i = 0; i < string1.length(); i++) {
			c = string1.charAt(i);
			for (int j = 0; j < string2.length(); j++) {
				d = string2.charAt(j);
				if (d != c) {
					match = false;
				}
				match = true;

			}
		}
		return match;
	}
}
