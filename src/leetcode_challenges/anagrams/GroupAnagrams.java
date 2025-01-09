package leetcode_challenges.anagrams;

import java.util.*;

/**
 * Given an array of strings strs, group the
 * anagrams
 *  together. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 *
 * Output: [["a"]]
 *
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea","ate","nat","bat"}));
    }
    static List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) return new ArrayList<>();

        Map<String,List<String>> ansMap = new HashMap<>();

        int[] count = new int[26];
        for (var str : strs) {
            Arrays.fill(count,0);
            var strChars = str.toCharArray();
            for (char c : strChars) {
                count[c - 'a']++;
            }

            var stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                stringBuilder.append("#");
                stringBuilder.append(count[i]);
            }

            var key = stringBuilder.toString();

            List<String> anagrams = ansMap.computeIfAbsent(key, (k) -> new ArrayList<>());
            anagrams.add(str);
            ansMap.put(key,anagrams);
        }

        return new ArrayList<>(ansMap.values());

    }
}
