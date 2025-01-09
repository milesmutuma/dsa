package leetcode_challenges.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 * Encode Function:
 * <p>
 * Given a list of strings, write a function that encodes the list into a single string.
 * The encoded string should be reversible, meaning it can be decoded back to the original list of strings.
 * Decode Function:
 * <p>
 * Given the encoded string, write a function that decodes it back into the original list of strings.
 * Assumptions:
 * <p>
 * The input strings can contain any character, including special characters like #.
 */
public class EncodingDecodingMsg {

    public static void main(String[] args) {
        String encoded = encodeV2(List.of("Miles", "Mutuma"));
        System.out.println(encoded);
        int sharpIndex = encoded.indexOf("#", 0);
        System.out.println(sharpIndex);
        int length = Integer.parseInt(encoded.substring(0, sharpIndex));
        System.out.println(length);
        String substring = encoded.substring(sharpIndex + 1, sharpIndex + 1 + length);
        System.out.println(substring);
    }

    public static String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return Character.toString(258);
        }
        // we are going to encode with #

        var separate = Character.toString(257);
        StringBuilder encoder = new StringBuilder();

        for (String str : strs) {
            encoder.append(str);
            encoder.append(separate);
        }

        encoder.deleteCharAt(encoder.length() - 1);
        return encoder.toString();
    }

    public static List<String> decode(String s) {
        if (s.equals(Character.toString(258))) {
            return new ArrayList<>();
        }

        String separate = Character.toString(257);

        return Arrays.asList(s.split(separate, -1));
    }


    public static String encodeV2(List<String> strs) {
        StringBuilder encoder = new StringBuilder();

        for (String str : strs) {
            encoder.append(str.length()).append("#").append(str);
        }

        return encoder.toString();
    }

    public static List<String> decodev2(String s) {
        List<String> decoded = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            // Find the position of the next '#'

            int sharpIndex = s.indexOf("#", i);

            // length of the string
            int wordLength = Integer.parseInt(s.substring(i, sharpIndex));

            // get the word
            String word = s.substring(sharpIndex + 1, sharpIndex + 1 + wordLength);
            decoded.add(word);

            i = sharpIndex + 1 + wordLength;

        }

        return decoded;
    }

}
