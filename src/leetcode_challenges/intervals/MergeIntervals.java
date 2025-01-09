package leetcode_challenges.intervals;

import java.util.*;

/**
 * Given an array of intervals where
 * intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * <p>
 * [[2,3],[4,5],[6,7],[8,9],[1,10]]
 * [[1,4],[0,2],[3,5]]
 * [[2,3],[5,5],[2,2],[3,4],[3,4]]
 *[[2,2],[1,3],[3,3],[3,4],[2,3],[4,5],[4,4]]
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] currentInterval;
        int[] previousInterval;

        List<int[]> overlaps = new ArrayList<>();
        int overlapStart = 0, overLapEnd = 0;
        int maxEnd = intervals[0][1];
        int length = intervals.length;
        for (int i = 1; i < length; i++) {
            currentInterval = intervals[i];
            previousInterval = intervals[i - 1]; // get last known overlap

            // check for overlap
            if (previousInterval[1] >= currentInterval[0] || currentInterval[0] <= maxEnd ||currentInterval[1] <= maxEnd ) {
                // we have an overlap between i and i-1
                overLapEnd++;
            } else {
                // we do not have an overlap
                // so we get interval at overlapStart and overLapEnd

                overlaps.add(new int[]{intervals[overlapStart][0], maxEnd});
                overLapEnd = i;
                overlapStart = i;
            }

            maxEnd = Math.max(maxEnd, currentInterval[1]);


        }

        overlaps.add(new int[]{intervals[overlapStart][0], maxEnd});


        return overlaps.toArray(new int[overlaps.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,3},
                {2,6},
                {8,10},
                {15,18}

        };

        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
