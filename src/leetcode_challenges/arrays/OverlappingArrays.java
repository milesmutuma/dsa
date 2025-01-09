package leetcode_challenges.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * Given an array of intervals where intervals[i] = [start_i, end_i], merge all overlapping
 * intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class OverlappingArrays {

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {15, 18}, {2, 6}, {9, 12}, {8, 10}};

        mergeIntervals(intervals1);
    }

    private static List<int[]> arrays(int[][] intervals) {

        // sort arrays
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];

        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged;

//        List<int[]> nonOverlapping = new ArrayList<>();
//        for (int i = 0; i < intervals.length; i++) {
//            int[] interval = intervals[i];
//            int min = interval[0];
//            int max = interval[1];
//
//            for (int j = i + 1; j < intervals.length; j++) {
//                int[] other = intervals[j];
//                int otherMin = other[0];
//                int otherMax = other[1];
//
//                if (otherMin <= max) {
//                    // overlapping
//                    nonOverlapping.add(new int[]{min, otherMax});
//                } else {
//                    nonOverlapping.add(interval);
//                    nonOverlapping.add(other);
//                }
//            }
//        }
//
//        System.out.println(Arrays.deepToString( nonOverlapping.toArray()));
    }


    private static void mergeIntervals(int[][] intervals) {
        // Ste 1: Sort intervals by startTime
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        System.out.println(Arrays.deepToString(intervals));

        // ste2 merge intervals

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];

        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) { // Overlapping intervals
                currentInterval[1] = Math.max(currentEnd, nextEnd); // Merge
            } else { // No overlap
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        System.out.println(Arrays.deepToString(merged.toArray()));
    }
}
