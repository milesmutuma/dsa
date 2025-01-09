package leetcode_challenges.stack;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        int result = 0;
        int sign = 1;          // Current sign: 1 for positive, -1 for negative
        int currentNumber = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int il = c - '0';
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (c == '-') {
                // Add the current number to result with its sign
                result += sign * currentNumber;
                currentNumber = 0; // Reset current number
                sign = -1;
            } else if (c == '+') {
                // Add the current number to result with its sign
                result += sign * currentNumber;
                currentNumber = 0; // Reset current number
                sign = 1;         // Update sign to negative
            } else if (c == '(') {
                // Push current result and sign onto the stack for later
                stack.push(result);
                stack.push(sign);
                // Reset result and sign for the new sub-expression
                result = 0;
                sign = 1;
            } else if (c == ')') {
                // Add the current number to the result
                result += sign * currentNumber;
                currentNumber = 0; // Reset current number

                // Retrieve the last sign and result from the stack
                result *= stack.pop(); // Multiply by the sign before '('
                result += stack.pop(); // Add to the result before '('
            }
        }
        // Add any remaining number to the result
        result += sign * currentNumber;

        return result;
    }

    public static void main(String[] args) {

    }
}
