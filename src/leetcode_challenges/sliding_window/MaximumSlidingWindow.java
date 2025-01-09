package leetcode_challenges.sliding_window;

import java.util.*;

public class MaximumSlidingWindow {

    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> maximum = new ArrayList<>();
        int j = 0;
        for (int i = 0; i <nums.length; i++) {

            if (i >= k - 1) {
                int tracker = j;
                int max = Integer.MIN_VALUE;
                for (int l = 0; l < k; l++) {
                    max = Math.max(max, nums[tracker]);
                    tracker++;
                }
                maximum.add(max);
                j++;
            }
        }
        return maximum;
    }

    public static List<Integer> maxSlidingWindowV2(int[] nums, int k) {
        List<Integer> maximum = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove indices of elements not in the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of elements smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index
            deque.offerLast(i);

            // Add the maximum of the current window to the result
            if (i >= k - 1) {
                maximum.add(nums[deque.peekFirst()]);
            }
        }

        return maximum;
    }

    public static void main(String[] args) {
        System.out.println(maxSlidingWindowV2(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }
}
