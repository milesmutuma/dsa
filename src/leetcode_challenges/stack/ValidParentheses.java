package leetcode_challenges.stack;


import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {

        int length = s.length();
        Stack<Character> stack = new Stack<>();

        Map<Character,Character> map = Map.of(')','(','}','{',']','[');
        for (int i = 0; i < length; i++) {
            var ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch);
            }else {
                if (stack.isEmpty()) return false;
                var top = stack.pop();
                if (top != map.get(ch)) return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("("));
    }
}
