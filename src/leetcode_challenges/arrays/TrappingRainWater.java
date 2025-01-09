package leetcode_challenges.arrays;

import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation
 * map where the width of each bar is 1, compute how much water it can trap after raining.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section)
 * is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 * <p>
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(maximumRainWaterOptimal2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    private static int maximumRainWater(int[] height) {
        // for every position, get left and right maximum

        int n = height.length;
        int[] leftMaxArray = new int[n];

        leftMaxArray[0] = 0;
        int leftMax = 0;
        for (int i = 1; i < n; i++) {
            leftMax = Math.max(leftMax, height[i - 1]);
            leftMaxArray[i] = leftMax;
        }

        int[] rightMaxArray = new int[n];
        int rightMax = 0;
        rightMaxArray[n - 1] = rightMax;
        for (int i = n - 2; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i + 1]);
            rightMaxArray[i] = rightMax;
        }
        System.out.println(Arrays.toString(leftMaxArray));
        System.out.println(Arrays.toString(rightMaxArray));

        // min(rightMaxArray[i], leftMaxArray[i]) - height[i]
        int maxRainWater = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(rightMaxArray[i], leftMaxArray[i]);
            int diff = min - height[i];
            if (diff <= 0) continue;
            maxRainWater = maxRainWater + diff;
        }

        return maxRainWater;
    }

    private static int maximumRainWaterOptimal(int[] height) {
        //we use to pointer
        int maxLeft = 0, maxRight = 0;
        int left = 0, right = height.length - 1;
        int trappedWater = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    trappedWater = trappedWater + (maxLeft - height[left]);
                }
                left++;
            } else {
                if (height[right] < maxRight) {
                    trappedWater = trappedWater + (maxRight - height[right]);
                } else {
                    maxRight = height[right];
                }
                right--;
            }

        }

        return trappedWater;
    }

    private static int maximumRainWaterOptimal2(int[] height) {
        // Edge case: If the array has less than 2 elements, no water can be trapped
        if (height == null || height.length < 3) {
            return 0;
        }

        int maxLeft = height[0], maxRight = height[height.length - 1];

        int left = 1, right = height.length - 1;

        int trappedWater = 0;
        while (left <= right) {
            if (maxLeft < maxRight) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    trappedWater += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    trappedWater += maxRight - height[right];
                }
                right--;
            }
        }

        return trappedWater;

    }
}
