package src.algorithm.Sort;

import java.util.Arrays;

public class BubblingSorting {
    public static void main(String[] args) {
        int[] arr={3,9,-1,10,20};

        int temp;

        for (int i=0;i<arr.length-1;i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
