package leetcode_challenges.sliding_window;

import java.util.*;

/**
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 * <p>
 * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
 * <p>
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
 * Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * <p>
 * Output: [0,9]
 * <p>
 * Explanation:
 * <p>
 * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * <p>
 * Output: []
 * <p>
 * Explanation:
 * <p>
 * There is no concatenated substring.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * <p>
 * Output: [6,9,12]
 * <p>
 * Explanation:
 * <p>
 * The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
 * The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
 * The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
 */
public class SubstringWithConWords {

    // given a word get all permutations of that word, in a set
    public static List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) return new ArrayList<>();
        if (s == null || s.isEmpty()) return new ArrayList<>();

        int wordLength = words[0].length();
        int totalWordLength = wordLength * words.length;

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (var word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i <= s.length() - totalWordLength; i++) {
            var substring = s.substring(i, i + totalWordLength);
            if (isSubstringValid(wordLength, substring, wordCountMap)) {
                indices.add(i);
            }
        }
        return indices;
    }

    private static boolean isSubstringValid(int wordLength, String substring, Map<String, Integer> wordCountMap) {
        Map<String, Integer> seenWords = new HashMap<>();

        for (int i = 0; i < substring.length(); i += wordLength) {
            var word = substring.substring(i, i + wordLength);

            if (!wordCountMap.containsKey(word)) return false;

            seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);

            if (seenWords.get(word) > wordCountMap.get(word)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }
}
