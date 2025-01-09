package leetcode_challenges.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums,
 * return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 */
public class ArrayContainsDuplicate {

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<Integer>();

        for (var item : nums) {
            if (visited.contains(item)) {
                return true;
            }
            visited.add(item);
        }

        return false;
    }

    private static boolean containsDuplicateV2(int[] nums){
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]){
                return true;
            }
        }

        return false;
    }
}
