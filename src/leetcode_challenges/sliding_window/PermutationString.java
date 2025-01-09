package leetcode_challenges.sliding_window;


import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, s1 and s2, return true if any of permutations of s1 is present in s2
 */
public class PermutationString {

    private static boolean containsPermutation(String s1, String s2) {
        Map<Character, Integer> s1FreqMap = new HashMap<>();
        for (var ch : s1.toCharArray()) {
            s1FreqMap.put(ch, s1FreqMap.getOrDefault(ch, 0) + 1);

        }
        Map<Character, Integer> s2FreqMap = new HashMap<>();
        int j = 0;
        for (int i = 0; i < s2.length(); i++) {
            var ch = s2.charAt(i);

            if (s1FreqMap.containsKey(ch)) {
                j = i;
                while (s1FreqMap.containsKey(s2.charAt(j))) {
                    s2FreqMap.put(s2.charAt(j), s2FreqMap.getOrDefault(s2.charAt(j), 0) + 1);
                    if (s2FreqMap.equals(s1FreqMap)) return true;
                    j++;
                }
                i = j;
                s2FreqMap.clear();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsPermutation("cab", "abdcba"));
    }
}
