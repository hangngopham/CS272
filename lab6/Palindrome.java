package lab6;

import java.util.*;

public class Palindrome {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("How many integers are in the sequence? ");
		int num = input.nextInt();
		if (num == 0) {
			throw new IllegalArgumentException(
					"There is no integer in the sequence");
		}
		System.out.println();
		System.out.println("Please enter a sequence of " + num + " integers:");
		int i = 0;
		LinkedStack ls = new LinkedStack();
		while (i < num) {
			int n = input.nextInt();
			ls.push(n);
			i++;
		}
		System.out.println(ls);

		int halfSize = ls.size() / 2;
		LinkedStack ls2 = new LinkedStack();
		for (int j = 0; j < halfSize; j++) {
			ls2.push(ls.peek());
			ls.pop();
		}
		System.out.println(ls2);
		System.out.println(ls);

		boolean same = true;

		int listSize = ls.size();
		if (ls.size() % 2 == 0) {
			for (int a = 0; a < listSize; a++) {
				if (ls.peek() != ls2.peek()) {
					same = false;
				}
				ls.pop();
				ls2.pop();
			}
		}

		int listSize2 = ls2.size();
		if (ls.size() % 2 != 0) {
			if (ls.size() > ls2.size()) {
				ls.pop();
				for (int a = 0; a < listSize2; a++) {
					if (ls.peek() != ls2.peek()) {
						same = false;
					}
					ls.pop();
					ls2.pop();
				}
			}
			else {
				ls2.pop();
				for (int a = 0; a < listSize; a++) {
					if (ls.peek() != ls2.peek()) {
						same = false;
					}
					ls.pop();
					ls2.pop();
				}
			}
		}
		System.out.println();
		if (same) {
			System.out.println("This sequence is palindromic");
		} else {
			System.out.println("This sequence is not palindromic");
		}
		

	}

}
