package leetcode_challenges.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {

    private static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] split = path.split("/");

        for (String pathItem : split) {
            if (!pathItem.isEmpty() && !pathItem.equals("..") && !pathItem.equals(".")) {
                stack.push(pathItem);
            } else if (!stack.isEmpty() && pathItem.equals("..")) {
                stack.pop();
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder builder = new StringBuilder();

        while (!stack.isEmpty()) {
            String item = stack.pop();

            builder.insert(0, item).insert(0, "/");
        }

        return builder.toString();
    }

    private static String simplifyPathWithDeque(String path) {
        Deque<String> stringDeque = new LinkedList<>();

        String[] pathNames = path.split("/");

        for (var pathItem : pathNames)  {
            if (!pathItem.isEmpty() && !pathItem.equals("..") && !pathItem.equals(".")){
                stringDeque.offerFirst(pathItem);
            }else if(!stringDeque.isEmpty() && pathItem.equals("..")){
                stringDeque.pollFirst();
            }
        }

        if (stringDeque.isEmpty()) return "/";

        StringBuilder builder = new StringBuilder();

        while (!stringDeque.isEmpty()) {
            var pathItem = stringDeque.pollLast();
            builder.append("/").append(pathItem);
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        System.out.println(simplifyPathWithDeque("/home//foo/"));
    }
}
