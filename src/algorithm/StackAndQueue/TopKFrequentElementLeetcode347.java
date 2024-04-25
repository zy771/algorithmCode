package src.algorithm.StackAndQueue;

/**
 * @Author：zz
 * @Package：src.algorithm.StackAndQueue
 * @Project：algorithmCode
 * @name：TopKFrequentElementLeetcode347
 * @Date：2024/4/14 15:39
 */


import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElementLeetcode347 {
    // 基于大顶堆实现的方法
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);//不理解
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入数组元素个数:");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("请输入数组元素:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("请输入k的值:");
        int k = scanner.nextInt();

        TopKFrequentElementLeetcode347 sol = new TopKFrequentElementLeetcode347();
        int[] result = sol.topKFrequent(nums, k);

        System.out.println("出现频率最高的 " + k + " 个元素是:");
        for (int num : result) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}
