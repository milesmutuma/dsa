package recursion;

import java.util.Arrays;

public class MergeSort {

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] data, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;

        // work left sub array
        while (i <= mid & j <= end) {
            if (data[i] <= data[j]) {
                temp[k] = data[i];
                k++;
                i++;
            } else {
                temp[k] = data[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            temp[k] = data[i];
            k++;
            i++;
        }

        while (j <= end) {
            temp[k] = data[j];
            k++;
            j++;
        }

        for (int v = 0; v < temp.length; v++) {
            data[start] = temp[v];
            start++;
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{3, 1, -9, 10, 11};
        mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }
}
