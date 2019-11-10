package chapter4_sort;

import java.util.Arrays;

/**
 * 关键点：对于数列有序区的界定
 * 每一轮排序后，记录下来最后一次元素交换的位置，
 * 该位置即为无序数组的边界，再往后就是有序区了
 * sortborder就是无序数列的边界。在每一轮排序过程中，
 * 处于sortBorder之后的元素就不需要再进行比较了，肯定是有序的
 * */
public class SortThridVersion {
    public static void sort(int[] array) {
        // 记录最后一次交换的位置
        int lastExchangeIndex = 0;
        // 无序数列的边界，每次比较只需要比较到这里为止
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            // 有序标记，每一轮的初始值都为true
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    // 因为有元素进行交换，所以不是有序的，标记为false
                    isSorted = false;
                    // 更新为最后一次进行交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {5, 8, 6, 3, 9, 2, 1, 7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
