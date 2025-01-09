package leetcode_challenges.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(N) time and without using division.
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */
public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productArrayBruteForce(new int[]{1, 2, 3, 4})));
    }

    private static int[] productArray(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] result = new int[n];
        prefix[0] = 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int[] suffix = new int[n];

        suffix[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    // brute force
    private static int[] productArrayBruteForce(int[] nums) {
        int[] prod = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int value = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                value = value * nums[j];
            }
            prod[i] = value;
        }

        return prod;
    }

}
