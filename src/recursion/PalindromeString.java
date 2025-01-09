package recursion;

public class PalindromeString {

    private static boolean isPalindrome(String input) {
        if (input.length() == 1 || input.isEmpty()) {
            return true;
        }

        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return isPalindrome(input.substring(1, input.length() - 1));
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("racedar"));
    }
}
