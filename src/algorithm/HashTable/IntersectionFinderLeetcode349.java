package src.algorithm.HashTable;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//整体框架public class IntersectionFinder{
//      psvm{}
//      solution{}
//}
//HashSet不允许有重复值


public class IntersectionFinderLeetcode349 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入第一个数组
        System.out.println("请输入第一个数组的长度:");
        int length1 = scanner.nextInt();
        int[] nums1 = new int[length1];
        System.out.println("请输入第一个数组的元素:");
        for (int i = 0; i < length1; i++) {
            nums1[i] = scanner.nextInt();
        }

        // 输入第二个数组
        System.out.println("请输入第二个数组的长度:");
        int length2 = scanner.nextInt();
        int[] nums2 = new int[length2];
        System.out.println("请输入第二个数组的元素:");
        for (int i = 0; i < length2; i++) {
            nums2[i] = scanner.nextInt();
        }

        // 查找交集
        int[] intersection = intersection(nums1, nums2);

        // 输出结果
        if (intersection.length > 0) {
            System.out.println("两个数组的交集为:");
            for (int num : intersection) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("两个数组没有交集。");
        }
        scanner.close();
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        return resSet.stream().mapToInt(x -> x).toArray();
    }
}
