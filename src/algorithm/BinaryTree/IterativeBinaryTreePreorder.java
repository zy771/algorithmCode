package src.algorithm.BinaryTree;

/**
 * @Author：zz
 * @Package：src.algorithm.BinaryTree
 * @Project：algorithmCode
 * @name：IterativeBinaryTreePreorder
 * @Date：2024/4/18 21:02
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}

public class IterativeBinaryTreePreorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of nodes in the binary tree:");
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println("Empty tree has no nodes to traverse.");
            return;
        }

        System.out.println("Enter the values of nodes in level order (use -1 to represent null):");
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            if (value == -1) continue; // Skip creating nodes for null values.
            nodes.add(new TreeNode(value));
        }

        for (int i = 0; i < nodes.size(); i++) {//用数组直接存储二叉树
            TreeNode current = nodes.get(i);
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;

            if (leftIndex < nodes.size() && nodes.get(leftIndex).val != -1) {
                current.left = nodes.get(leftIndex);
            }
            if (rightIndex < nodes.size() && nodes.get(rightIndex).val != -1) {
                current.right = nodes.get(rightIndex);
            }
        }

        TreeNode root = nodes.isEmpty() ? null : nodes.get(0);
        Solution solution = new Solution();
        List<Integer> result = solution.preorderTraversal(root);
        System.out.println("Preorder traversal result:");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
