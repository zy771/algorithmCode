package src.algorithm.search;

/**
 * @Author：zz
 * @Package：src.algorithm.search
 * @Project：algorithmCode
 * @name：BinarySearch
 * @Date：2024/4/16 17:19
 */

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 用户输入数组大小,数组必须是排好序的
        System.out.println("Enter the number of elements in the array (array must be sorted):");
        int n = scanner.nextInt();
        int[] array = new int[n];

        // 用户输入数组元素
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // 用户输入要查找的值
        System.out.println("Enter the value to search for:");
        int target = scanner.nextInt();

        // 调用二分查找函数
        int result = binarySearch(array, target);

        // 输出结果
        if (result == -1) {
            System.out.println("Value not found in the array.");
        } else {
            System.out.println("Value found at index: " + result);
        }

        scanner.close();
    }

    // 二分查找的实现
    //折半二分查找的时间复杂度为log2(N)
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (right +left) / 2;

            if (array[mid] == target) {
                return mid; // 返回找到的元素的索引
            } else if (array[mid] < target) {
                left = mid + 1; // 调整左边界
            } else {
                right = mid - 1; // 调整右边界
            }
        }
        return -1; // 如果未找到，返回-1
    }
}
