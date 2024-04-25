package src.algorithm.search;

/**
 * @Author：zz
 * @Package：src.algorithm.search
 * @Project：algorithmCode
 * @name：SequentialSearch
 * @Date：2024/4/16 16:52
 */

import java.util.Scanner;

public class SequentialSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 用户输入数组大小
        System.out.println("Enter the number of elements in the array:");
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

        // 调用顺序查找函数
        int result = linearSearch(array, target);

        // 输出结果
        if (result == -1) {
            System.out.println("Value not found in the array.");
        } else {
            System.out.println("Value found at index: " + result);
        }

        scanner.close();
    }

    // 顺序查找的实现
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // 返回找到的元素的索引
            }
        }
        return -1; // 如果未找到，返回-1
    }
}
