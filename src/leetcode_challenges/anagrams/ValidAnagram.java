package leetcode_challenges.anagrams;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an
 * anagram
 * of s, and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * <p>
 * Output: false
 */
public class ValidAnagram {

    public static void main(String[] args) {
        char item = 'i';

        System.out.println(item - 'a');
        // System.out.println(isValidAnagram("anagram","nagaram"));
    }

    public static boolean isValidAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sCharaters = s.toCharArray();
        char[] tCharacters = t.toCharArray();

        Arrays.sort(sCharaters);
        Arrays.sort(tCharacters);

        for (int i = 0; i < sCharaters.length; i++) {
            if (sCharaters[i] != tCharacters[i]) return false;
        }

        return true;

    }

    public static boolean isValidAnagramV2(String s, String t) {
        if (s.length() != t.length()) return false;

        s = s.toLowerCase();
        t = t.toLowerCase();

        // create an array to count character frequencies
        int[] charCounts = new int[26];

        // Increment count for each character in 's' and for the same character in
        // decrement

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        // check if all counts are zero
        for (var count : charCounts) {
            if (count != 0) return false;
        }

        return true; // all counts are zero, so 't' is an anagram of 's'
    }
}
