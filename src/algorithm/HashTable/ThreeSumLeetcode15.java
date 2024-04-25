package src.algorithm.HashTable;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//双指针法
public class ThreeSumLeetcode15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        if (result.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println("The triplets are:");
            for (List<Integer> triplet : result) {
                System.out.println(triplet);
            }
        }
        scanner.close();
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) { // 确保至少有三个元素可供选择
                // 如果当前数字大于0，则之后的数字都大于0，无需继续搜索
                if (nums[i] > 0) break;
                // 跳过重复元素
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // 跳过所有重复的`left`值
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // 跳过所有重复的`right`值
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return result;
        }
    }
}
