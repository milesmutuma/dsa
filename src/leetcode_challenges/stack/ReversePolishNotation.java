package leetcode_challenges.stack;

import java.util.Set;
import java.util.Stack;

/**
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 *
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 */
public class ReversePolishNotation {

    public static int evalRPN(String[] tokens){
        Set<String> opr = Set.of("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();

        for(var token : tokens) {
            if (opr.contains(token)) {
                Integer b = stack.pop();
                Integer a = stack.pop();

                switch (token) {
                    case "+" -> stack.push(a + b);
                    case "*" -> stack.push(a * b);
                    case "/" -> stack.push(a / b);
                    case "-" -> stack.push(a - b);
                }
            }else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
