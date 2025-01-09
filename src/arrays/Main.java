package arrays;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr));
//        bubbleSort(arr);
//        reverseArray(arr);
    }

    // bubble sort algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("Array after " + i + "iteration");
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void reverseArray(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

    public static Set<Integer> twoSum(int[] arr, int target) {
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[i] + arr[j] == target) {
                    return Set.of(i, j);
                }
            }
        }

        return Set.of();
    }

    public static int[] twoSumV2(int[] arr, int target) {
        // Map to store values and their indices
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= arr.length - 1; i++) {
            int complement = target - arr[i]; // Value we need to find
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(arr[i], i);
        }

        return new int[]{};
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // Edge case: Empty array
        
        int i = 0; // slow pointer
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++; // Move slow pointer
                nums[i] = nums[j]; // Overwrite at the new position
            }
        }

        return i + 1; // Length of the array with unique elements
    }
}
