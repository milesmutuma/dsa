package leetcode_challenges.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        System.out.println(solutionBruteForce("bbbbb"));
    }

    private static int solutionBruteForce(String s) {

        int result = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                String substring = s.substring(i, j);
                if (hasUniquesCharacters(substring)) {
                    result = Math.max(result, substring.length());
                }
            }
        }
        return result;
    }

    private static boolean hasUniquesCharacters(String s) {
        Set<Character> chars = new HashSet<>();
        for (var cha: s.toCharArray()) {
            if (chars.contains(cha)) return false;
            chars.add(cha);
        }

        return true;
    }
}
