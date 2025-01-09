package leetcode_challenges.strings;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 * <p>
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 * <p>
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(Character.isLetterOrDigit(' '));
    }

    public static boolean isPalindrome(String s) {
        //two pointer approach

        int left = 0, right = s.length() - 1;

        while (left < right) {
            // move left pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            // move right pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right++;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }

            // move pointers inward
            right++;
            left++;

        }

        return true; // valid palindrome
    }
}
