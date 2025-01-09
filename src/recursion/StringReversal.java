package recursion;

public class StringReversal {

    private static String reverseString(String input) {
        if (input.isEmpty()) return "";

        return reverseString(input.substring(1)) + input.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }
}
