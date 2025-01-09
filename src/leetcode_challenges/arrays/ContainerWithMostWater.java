package leetcode_challenges.arrays;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 * <p>
 * Input: height = [1,1]
 * Output: 1
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maximumWater(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    private static int maximumWater(int[] nums) {
        int left = 0, right = nums.length - 1;

        int maximumWater = 0;
        while (left < right) {
            int width = right - left;
            int height = Math.min(nums[right], nums[left]);

            int area = height * width;

            maximumWater = Math.max(area, maximumWater);
            if (nums[left] <= nums[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maximumWater;
    }
}
