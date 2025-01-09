package leetcode_challenges.sliding_window;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 * <p>
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */
public class SmallestSubArray {

    private static int smallestSubarray(int targetSum, int[] array) {
        int minWindowSize = Integer.MAX_VALUE;
        int currentWindowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            currentWindowSum += array[windowEnd];

            while (currentWindowSum >= targetSum) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum -= array[windowStart];
                windowStart++;
            }
        }

        // If no subarray was found, return 0
        return minWindowSize == Integer.MAX_VALUE ? 0 : minWindowSize;
    }

    public static void main(String[] args) {
        System.out.println(smallestSubarray(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
