package lab6;

import java.util.HashMap;
import java.util.Scanner;

public class ComputeInfix1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter an expression: ");
		String exp = input.nextLine();
		
		String[] arr = new String[exp.length()];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = exp.valueOf(exp.charAt(i));
			// System.out.println(arr[i]);
		}

		// for(int j= 0; j < arr.length; j++) {
		// System.out.println(arr[j]);
		// }
		LinkedStack<Integer> numStack = new LinkedStack<Integer>();
		LinkedStack<String> opStack = new LinkedStack<String>();

		for (int j = 0; j < exp.length(); j++) {
			if (arr[j] == "(") {
				System.out.println(arr[j]);
				opStack.push(arr[j]);
				System.out.println(opStack.toString());
			} else if (isInteger(arr[j])) {
				int num = Integer.parseInt(arr[j]);
				numStack.push(num);
			} else if (isOperator(arr[j])) {
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				map.put("^", 3);
				map.put("*", 2);
				map.put("/", 2);
				map.put("+", 1);
				map.put("-", 1);
				map.put("#", 0);
				System.out.println(map.get(arr[j]));
				while (!opStack.isEmpty() && opStack.peek() != "(") {
					if (map.get(opStack.peek()) >= map.get(arr[j])) {
						String top = opStack.pop();
						int num1 = numStack.pop();
						int num2 = numStack.pop();
						numStack.push(operator(top, num2, num1));
					}
				}
				opStack.push(arr[j]);
				System.out.println(opStack.toString());
			} else {
				if (arr[j] == ")") {
					break;
				}
				while (opStack.peek() != "(" && !opStack.isEmpty()) {
					String opTop = opStack.pop();
					int num3 = numStack.pop();
					int num4 = numStack.pop();
					numStack.push(operator(opTop, num4, num3));
				}
				if (opStack.peek() != "(") {
					System.out.println("Unbalanced parentheses");
					break;
				} else {
					opStack.pop();
				}
			}
		}

		System.out.println("The expression evaluates to ");

	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}

		return true;
	}

	public static boolean isOperator(String s) {
		String[] operators = { "+", "-", "*", "/"};
		for (int j = 0; j < operators.length; j++) {
			if (s == operators[j]) {
				System.out.println(s);
				return true;
			}
		}
		return false;
	}

	public static int operator(String op, int a, int b) {
		int result = 0;
		if (op == "+") {
			result = a + b;
		} else if (op == "-") {
			result = a - b;
		} else if (op == "*") {
			result = a * b;
		} else if (op == "/") {
			result = a / b;
		}
		return result;
	}

}
