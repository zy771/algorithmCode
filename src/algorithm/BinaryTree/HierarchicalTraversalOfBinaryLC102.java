package src.algorithm.BinaryTree;

/**
 * @Author：zz
 * @Package：src.algorithm.BinaryTree
 * @Project：algorithmCode
 * @name：HierarchicalTraversalOfBinaryLC102
 * @Date：2024/4/21 10:12
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HierarchicalTraversalOfBinaryLC102 {
    // 内部静态类 TreeNode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode insertLevelOrder(Integer[] arr, TreeNode root, int i) {
        // 基于数组创建二叉树
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // 插入左子节点
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

            // 插入右子节点
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static void levelOrder(TreeNode root) {
        // 层序遍历二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.val + " ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入元素数量:");
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        System.out.println("请输入每个元素:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        TreeNode root = null;
        root = insertLevelOrder(arr, root, 0);

        System.out.println("层序遍历输出:");
        levelOrder(root);
    }
}

