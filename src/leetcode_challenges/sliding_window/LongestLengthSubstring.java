package leetcode_challenges.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestLengthSubstring {


    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        Set<Character> charSet = new HashSet<>();

        int max = Integer.MIN_VALUE;

        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);

            while (charSet.contains(ch)) {
                charSet.remove(s.charAt(j));
                j++;
            }
            max = Math.max(max, (i - j) + 1);
            charSet.add(ch);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbbbb"));
    }

}
