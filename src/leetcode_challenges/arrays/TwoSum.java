package leetcode_challenges.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target,
 * return the indices of the two numbers such that they add up to the target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Return the answer in any order.
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4},6)));
    }


    private static int[] twoSum(int[] nums, int target) {
        int length = nums.length;


        Map<Integer, Integer> itemsMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int compliment = target - nums[i];
            if (itemsMap.containsKey(compliment)) {
                return new int[]{itemsMap.get(compliment), i};
            }
            itemsMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
