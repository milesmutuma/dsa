package arrays;

import java.util.Arrays;

public class InsertElementAtK {

    private static int[] insert(int[] data, int k, int num) {

        for (int i = data.length - 1; i > k; i--) {
            data[i] = data[i - 1];
        }
        data[k] = num;

        return data;
    }

    public static void main(String[] args) {
        int[] data = new int[5];
        data[0] = 0;
        data[1] = 1;
        data[2] = 3;
        System.out.println(Arrays.toString(insert(data, 2, 5)));
    }
}
