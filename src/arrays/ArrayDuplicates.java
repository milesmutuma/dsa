package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayDuplicates {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }

    private static Set<Integer> duplicatesArray(int[] nums) {
        Set<Integer> items = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int num : nums) {
            if(!items.add(num))
                duplicates.add(num);
        }

        return duplicates;
    }

    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for(int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                // If the value at `index` is negative, it means `num` is a duplicate
                duplicates.add(Math.abs(num));
            }else {
                // Mark the value at `index` as visited by making it negative
                nums[index] = -nums[index];
            }
        }

        return duplicates;
    }
}
