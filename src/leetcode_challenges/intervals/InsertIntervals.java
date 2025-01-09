package leetcode_challenges.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals
 * intervals where intervals[i] = [starti, endi] represent the start
 * and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start
 * and end of another interval.
 * <p>
 * Insert newInterval into intervals such that intervals
 * is still sorted in ascending order by starti and intervals still does
 * not have any overlapping intervals (merge overlapping intervals if necessary).
 * <p>
 * Return intervals after the insertion.
 * <p>
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 */
public class InsertIntervals {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] newIntervals = new int[intervals.length + 1][2];

        System.arraycopy(intervals, 0, newIntervals, 0, intervals.length);

        // add interval at the end of the list

        newIntervals[intervals.length] = newInterval;

        // let's sort the intervals
        Arrays.sort(newIntervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> nonOverlapping = new ArrayList<>();
        // find overlapping
        int[] currentInterval;
        int[] previousInterval;

        int overlapStart = 0, overlapEnd = 0;

        int maxEnd = newIntervals[0][1];
        for (int i = 1; i < newIntervals.length; i++) {
            currentInterval = newIntervals[i];
            previousInterval = newIntervals[i - 1];

            if (previousInterval[1] > currentInterval[0] || currentInterval[0] <= maxEnd || currentInterval[1] <= maxEnd) {
                overlapEnd++;
            } else { // means it's not overlapping
                nonOverlapping.add(new int[]{newIntervals[overlapStart][0], maxEnd});

                overlapEnd = i;
                overlapStart = i;
            }

            maxEnd = Math.max(maxEnd, currentInterval[1]);
        }

        nonOverlapping.add(new int[]{newIntervals[overlapStart][0], maxEnd});

        return nonOverlapping.toArray(new int[nonOverlapping.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = new int[][]{
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16},
        };
        System.out.println(Arrays.deepToString(insert(intervals, new int[]{4, 8})));
    }

}
