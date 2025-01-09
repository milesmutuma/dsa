package leetcode_challenges.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 * of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 * <p>
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 */
public class MinimumWindowSubstring {

    private static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> tFreqMap = new HashMap<>();
        Map<Character, Integer> sFreqMap = new HashMap<>();

        int min = Integer.MAX_VALUE;
        String subString = "";
        for (var ch : t.toCharArray()) {
            tFreqMap.put(ch, tFreqMap.getOrDefault(ch, 0) + 1);
        }
        int length = s.length();
        int j = 0;
        int created = 0;
        for (int i = 0; i < length; i++) {
            var ch = s.charAt(i);
            sFreqMap.put(ch, sFreqMap.getOrDefault(ch, 0) + 1);


            if (tFreqMap.containsKey(ch) && sFreqMap.get(ch) <= tFreqMap.get(ch)) {
                created++;
            }

            while (j <= i && created == t.length()) {
                if (min > i - j + 1) {
                    min = i - j + 1;
                    subString = s.substring(j, i + 1);
                }

                char left = s.charAt(j);
                sFreqMap.put(left, sFreqMap.get(left) - 1);
                if (tFreqMap.containsKey(left) && sFreqMap.get(left) < tFreqMap.get(left)) {
                    created--;
                }
                j++;
            }
        }


        return subString;
    }

    private static boolean getSubstring(String substring, Map<Character, Integer> target) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < substring.length(); i++) {
            char c = substring.charAt(i);
            if (target.containsKey(c))
                map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return target.equals(map);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANCDCCAVB", "ABCC"));
    }
}























