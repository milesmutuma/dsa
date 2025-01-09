package leetcode_challenges.mapsandheaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 * <p>
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsSeq {

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(longestConsecutiveWithSort(nums1)); // Output: 4
        System.out.println(longestConsecutiveWithSort(nums2)); // Output: 9
    }

    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        // create a hashset
        Set<Integer> numSet = new HashSet<>();

        for (var num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (var num : numSet) {
            // only start if the current number is not the start of a sequence
            if (!numSet.contains(num - 1)) {

                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }

        return longestStreak;
    }


    public static int longestConsecutiveWithSort(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;

            if (nums[i] == nums[i - 1] + 1) {
                currentStreak++;
            } else {
                longestStreak = Math.max(longestStreak, currentStreak);
                currentStreak = 1;
            }
        }

        return Math.max(longestStreak, currentStreak);
    }
}
