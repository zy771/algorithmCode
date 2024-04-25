package src.algorithm.TwoPointerMethod;

/**
 * @Author：zz
 * @Package：src.algorithm.TwoPointerMethod
 * @Project：algorithmCode
 * @name：RemoveElementLeetcode27
 * @Date：2024/4/13 10:09
 */


import java.util.Scanner;

public class RemoveElementLeetcode27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组大小
        System.out.println("Enter the length of elements in the array:");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // 读取数组元素
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 读取要删除的元素
        System.out.println("Enter the value to remove:");
        int val = scanner.nextInt();

        // 调用 removeElement 方法
        int newLength = removeElement(nums, val);

        // 打印新数组的长度和内容
        System.out.println("New length of the array: " + newLength);
        System.out.print("Elements in the new array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
        scanner.close();
    }

    public static int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
