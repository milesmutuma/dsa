package leetcode_challenges.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 * <p>
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 * <p>
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array to handle duplicates and enable two-pointer logic
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the next number

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Call the twoSum function with target = -nums[i]
            // nums[i] + nums[j] + nums[k] == 0. means nums[j] + nums[k] = -nums[i]

            int target = -nums[i];
            List<List<Integer>> pairs = twoSum(nums, i + 1, target);
            for (List<Integer> pair : pairs) {
                pair.add(nums[i]);
                result.add(pair);
            }
        }
        return result;
    }

    // Modified TwoSum to find pairs in nums[start:] that sum to the target
    public static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        int left = start, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                // Found a pair
                pairs.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));

                // Skip duplicates for the second number
                while (left < right && nums[left] == nums[left + 1]) left++;
                // Skip duplicates for the third number
                while (left < right && nums[right] == nums[right - 1]) right--;

                // Move pointers
                left++;
                right--;
            } else if (sum < target) {
                left++; // Increase the sum
            } else {
                right--; // Decrease the sum
            }
        }

        return pairs;
    }
}
