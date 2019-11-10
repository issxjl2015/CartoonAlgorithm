package chapter4_sort;

import java.util.Arrays;

/**
 * 如果发现数列已经有序，并作出标记，
 * 那么剩下的几轮排序就不必执行，可以提前结束工作
 * */
public class SortSecondVersion {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    // 因为有元素交换，所以不是有序的，标记为 false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 8, 6, 3, 9, 2, 1, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
