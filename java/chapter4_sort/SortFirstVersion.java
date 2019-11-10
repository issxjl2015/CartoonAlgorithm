package chapter4_sort;

import java.util.Arrays;

public class SortFirstVersion {

    public static void sort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 8, 6, 3, 9, 2, 1, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
