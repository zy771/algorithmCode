package src.algorithm.search;

/**
 * @Author：zz
 * @Package：src.algorithm.search
 * @Project：algorithmCode
 * @name：BlockSearch
 * @Date：2024/4/16 19:15
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//分块查找

public class BlockSearch {
    // 用于存储分块后的数组
    //这表示该方法是私有的，即只能在定义它的类内部访问，而 static 表示它属于类而非类的实例。
    static List<List<Integer>> blocks = new ArrayList<>();

    // 线性搜索指定块内的元素
    private static int linearSearchInBlock(List<Integer> block, int target) {
        for (int i = 0; i < block.size(); i++) {
            if (block.get(i) == target) {
                return i; // 返回目标值的索引
            }
        }
        return -1; // 如果未找到，则返回-1
    }

    // 自动分块方法
    private static void partitionBlocks(int[] array) {
        List<Integer> currentBlock = new ArrayList<>();
        int currentMax = Integer.MIN_VALUE;
        //在Java中，Integer.MIN_VALUE 表示一个 int 类型能够表示的最小的整数值。
        // 这个值是 (-2^{31})，即 (-2147483648)。

        for (int value : array) {
            if (value > currentMax) {
                if (!currentBlock.isEmpty()) {
                    blocks.add(new ArrayList<>(currentBlock));
                    currentBlock.clear();
                }
                currentMax = value;
            }
            currentBlock.add(value);
        }
        if (!currentBlock.isEmpty()) {
            blocks.add(currentBlock);
        }
        System.out.println(blocks);
    }

    // 分块查找
    public static int findBlock(int target) {
        for (int i = 0; i < blocks.size(); i++) {
            List<Integer> block = blocks.get(i);
            if (block.get(0) >= target) {
                // 在确定的块内进行线性搜索
                int resultIndex = linearSearchInBlock(block, target);
                if (resultIndex != -1) {
                    return resultIndex; // 返回找到的索引
                }
            }
        }
        return -1; // 如果未找到，则返回-1
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组大小
        System.out.print("输入数组大小: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        // 读取数组元素
        System.out.println("输入数组元素: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // 根据输入的数组元素自动分块
        partitionBlocks(array);

        // 读取目标值
        System.out.print("输入要查找的目标值: ");
        int target = scanner.nextInt();

        // 执行分块查找
        int resultIndex = findBlock(target);

        // 输出结果
        if (resultIndex != -1) {
            System.out.println("目标值位于索引: " + resultIndex + " 在块中");
        } else {
            System.out.println("目标值在数组中未找到。");
        }

        scanner.close();
    }
}
