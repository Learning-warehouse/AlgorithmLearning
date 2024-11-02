package day01;

import java.util.Arrays;

public class Code03_InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        // 0~0有序
        // 0~i想有序
        for (int i = 1; i < arr.length; i++) { // 0 ~ i 做到有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // i和j一个位置会出错
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        /**
         * arr[i] = arr[i] ^ arr[j];
         * arr[j] = arr[i] ^ arr[j];
         * arr[i] = arr[i] ^ arr[j];
         */
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int[] Test = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        insertionSort(Test);
    }

}
