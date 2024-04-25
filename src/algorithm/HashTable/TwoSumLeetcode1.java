package src.algorithm.HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSumLeetcode1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入数组长度
        System.out.println("Enter the length of the array:");
        int length = scanner.nextInt();

        int[] nums = new int[length];

        // 输入数组元素
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }

        // 输入目标值
        System.out.println("Enter the target value:");
        int target = scanner.nextInt();

        // 调用twoSum方法并输出结果
        int[] result = twoSum(nums, target);
        //// 假设数组中不存在0下标的有效组合，以区分未找到的情况,检查返回的结果数组result，如果不是初始值[0, 0]，则打印两个索引。
        if(result[0] != 0 || result[1] != 0) {
            System.out.println("Index1: " + result[0] + ", Index2: " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
        scanner.close();
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}

