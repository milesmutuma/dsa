package leetcode_challenges.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane.
 * The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 * <p>
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 * <p>
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 */
public class MinArrowBurstBalloons {

    // basically we find overlapping intervals
    public static int findMinArrowShots(int[][] points) {

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int[] currentInterval;
        int[] previousInterval = points[0];

        int n = points.length;

        int count = n;
        for (int i = 1; i < n; i++) {
            currentInterval = points[i];

            // find overlapping
            if (currentInterval[0] <= previousInterval[1]) {
                count -= 1;
                previousInterval[0] = currentInterval[0];
                previousInterval[1] = Math.min(previousInterval[1], currentInterval[1]);
            } else {
                previousInterval = currentInterval;
            }
        }


        return count;

    }

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(
                new int[][]{
                        {9, 12},
                        {1, 10},
                        {4, 11},
                        {8, 12},
                        {3, 9},
                        {6, 9},
                        {6, 7},
                }
        ));
    }
}
