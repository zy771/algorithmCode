package src.algorithm.BinaryTree;

/**
 * @Author：zz
 * @Package：src.algorithm.BinaryTree
 * @Project：algorithmCode
 * @name：AverageOfLevelsInBinaryTreeLeetcode637
 * @Date：2024/4/26 20:32
 */

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.io.*;



public class AverageOfLevelsInBinaryTreeLeetcode637 {

    //在 static class TreeNode 中，val 变量可以被直接访问，因为它没有限定访问权限，
    // 即默认为包私有（package-private）。这意味着在同一个包内的任何类都可以直接访问 val 变量。
    //
    //另外，如果在同一个包内，left 和 right 变量也可以被直接访问，因为它们也没有限定访问权限。
    // 但是如果在不同的包内，即使是同一个包内的类也不能直接访问 left 和 right 变量，
    // 因为它们默认的访问权限是包私有（package-private），只有在同一个包内的类才能访问。
    //
    //总的来说，在同一个包内，除了构造函数 TreeNode(int x) 是公共的，其他成员都是包私有的，可以在包内直接访问。
    // 构造函数 TreeNode(int x) 是公共的，可以在任何地方直接访问，但要创建 TreeNode 对象，
    // 必须通过调用该构造函数来实例化对象。构造函数的作用是初始化对象的状态，并为对象分配内存空间。
    //所以，要访问 TreeNode(int x) 构造函数中的代码，必须创建 TreeNode 的实例，然后通过实例来调用构造函数。
    // 一旦创建了对象实例，就可以访问该对象的属性和方法。
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter elements in level order, use 'null' for no node 请输入二叉树的节点值序列，中间用空格分隔:");
        String[] parts = br.readLine().split(" ");//输入流 br 中读取一行文本，并将其按空格分割成多个部分，并将这些部分存储在一个字符串数组中。

        TreeNode root = buildTree(parts);
        AverageOfLevelsInBinaryTreeLeetcode637 solution = new AverageOfLevelsInBinaryTreeLeetcode637();
        List<Double> averages = solution.averageOfLevels(root);
        System.out.println("Average of each level:");
        for (double avg : averages) {
            System.out.println(avg);
        }
    }

      public static TreeNode buildTree(String[] parts) {
        if (parts[0].equals("null")) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        //静态类必须创建实例才能使用。静态类是指在类内部声明为静态的内部类，它可以独立于外部类的实例而存在。
        // 但即便是静态类，如果要访问其成员或调用其方法，仍然需要通过创建实例的方式来进行。
        // 静态类的静态成员可以直接通过类名访问，但非静态成员必须通过实例来访问。
        //
        //在Java中，静态内部类通常用于一些辅助性的工具类或者逻辑上独立的类，但它们仍然需要通过实例化来使用其中的成员或方法。
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < parts.length) {
            TreeNode node = queue.poll();

            if (i < parts.length && !parts[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(parts[i]));
                queue.offer(node.left);
            }
            i++;

            if (i < parts.length && !parts[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(parts[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0.0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            averages.add(levelSum / levelSize);
        }
        return averages;
    }
}
