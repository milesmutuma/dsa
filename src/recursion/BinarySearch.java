package recursion;

public class BinarySearch {

    private static int binarySearch(int[] nums, int left, int right, int numToFind) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (numToFind == nums[mid])
            return mid;

        if (numToFind < nums[mid]) {
            return binarySearch(nums, left, mid - 1, numToFind);
        }

        return binarySearch(nums, mid + 1, right, numToFind);
    }
}
