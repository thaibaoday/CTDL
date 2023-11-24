package Lab10;


import java.util.Stack;

public class MyLIFO_App1 {
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> reserve = new Stack<E>();
		for (E e : array) {
			reserve.push(e);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = reserve.pop();
		}

	}

	// This method checks the correctness of the given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==>false
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : input.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				char last = stack.pop();
				if ((c == ')' && last != '(') || (c == ']' && last != '[') || (c == '}' && last != '{')) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	
	}

	// This method evaluates the value of an expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		char[] tokens = expression.toCharArray();
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == ' ')
				continue;
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				values.push(Integer.parseInt(sbuf.toString()));
			}

			else if (tokens[i] == '(')
				ops.push(tokens[i]);
			else if (tokens[i] == ')') {
				while (ops.peek() != '(')
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				ops.pop();
			} else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));

				ops.push(tokens[i]);
			}
		}
		while (!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));

		return values.pop();
	}

	public static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	public static int applyOp(char op, int b, int a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return 0;

	}

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3, 4, 5 };
		System.out.println("Original array:");
		for (Integer i : array) {
			System.out.print(i + " ");
		}
		reserve(array);
		System.out.println("\nReversed array:");
		for (Integer i : array) {
			System.out.print(i + " ");
		}

		String input1 = "()(())[]{(())}";
		String input2 = "){[]}()";
		System.out.println("\n\nInput: " + input1 + " is correct? " + isCorrect(input1));
		System.out.println("Input: " + input2 + " is correct? " + isCorrect(input2));

		// 51 + (54 *(3+2)) = 321
		System.out.println("51 + (54 *(3+2)) = " + MyLIFO_App1.evaluateExpression("51 + ( 54 * ( 3 + 2 ) )"));
		
	}
	

}
