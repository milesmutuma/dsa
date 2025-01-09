package arrays;

import java.util.Arrays;

public class ProductArray {

    public static void main(String[] args) {
        int [] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Compute prefix products
        answer[0] = 1; // No elements to the left of the first element
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        System.out.println(Arrays.toString(answer));

        // Step 2: Compute suffix products and final result in a single pass
        int suffix = 1; // Initialize suffix product to 1
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix *= nums[i]; // Update the suffix product
        }

        return answer;

    }
}
