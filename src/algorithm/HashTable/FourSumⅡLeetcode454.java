package src.algorithm.HashTable;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FourSumⅡLeetcode454 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取四个数组
        System.out.println("请输入数组 nums1 (例如：[1, 2]): ");
        int[] nums1 = parseArray(scanner.nextLine());
        System.out.println("请输入数组 nums2 (例如：[-2, -1]): ");
        int[] nums2 = parseArray(scanner.nextLine());
        System.out.println("请输入数组 nums3 (例如：[-1, 2]): ");
        int[] nums3 = parseArray(scanner.nextLine());
        System.out.println("请输入数组 nums4 (例如：[0, 2]): ");
        int[] nums4 = parseArray(scanner.nextLine());

        // 计算和为0的四元组数量
        int count = fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println("满足条件的四元组数量是: " + count);
        scanner.close();
    }

    private static int[] parseArray(String input) {
        String[] items = input.replaceAll("\\[|\\]", "").split(",");
        int[] result = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            result[i] = Integer.parseInt(items[i]);
        }
        return result;
    }

    private static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }

        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                count += map.getOrDefault(-1 * (i + j), 0);
            }
        }
        return count;
    }
}
