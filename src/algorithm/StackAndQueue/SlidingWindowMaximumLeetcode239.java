package src.algorithm.StackAndQueue;

/**
 * @Author：zz
 * @Package：src.algorithm.StackAndQueue
 * @Project：algorithmCode
 * @name：SlidingWindowMaximumLeetcode239
 * @Date：2024/4/14 9:57
 */
//暴力for循环解法
/*import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximumLeetcode239 {
    public List<Integer> maxSlidingWindow(int[] nums) {
        int k = 3;  // 滑动窗口的大小固定为3
        List<Integer> maxValues = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return maxValues;  // 如果数组为空，返回空列表

        for (int i = 0; i <= n - k; i++) {  // 外层循环遍历所有窗口的起始位置
            int windowMax = nums[i];  // 初始化窗口最大值为当前窗口的第一个元素
            for (int j = 1; j < k; j++) {  // 从当前窗口的第二个元素开始遍历
                if (nums[i + j] > windowMax) {  // 使用if判断当前元素是否比已知最大值大
                    windowMax = nums[i + j];  // 如果是，更新最大值
                }
            }
            maxValues.add(windowMax);  // 将当前窗口的最大值添加到列表中
        }
        return maxValues;
    }

    public static void main(String[] args) {
        SlidingWindowMaximumLeetcode239 solution = new SlidingWindowMaximumLeetcode239();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        List<Integer> results = solution.maxSlidingWindow(nums);
        System.out.println(results);  // 打印所有滑动窗口的最大值
    }
}*/


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class MyQueue {
    Deque<Integer> deque = new LinkedList<>();

    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.addLast(val);
    }

    int peek() {
        return deque.peek();
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int num = 0;
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            res[num++] = myQueue.peek();
        }
        return res;
    }
}

public class SlidingWindowMaximumLeetcode239 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println("Enter the size of the window (k):");
        int k = scanner.nextInt();
        Solution solution = new Solution();
        int[] results = solution.maxSlidingWindow(nums, k);
        System.out.println("Maximum values in each sliding window:");
        for (int result : results) {
            System.out.print(result + " ");
        }
    }
}
