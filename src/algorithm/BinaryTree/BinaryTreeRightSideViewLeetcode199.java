package src.algorithm.BinaryTree;

/**
 * @Author：zz
 * @Package：src.algorithm.BinaryTree
 * @Project：algorithmCode
 * @name：BinaryTreeRightSideViewLeetcode199
 * @Date：2024/4/26 18:42
 */



import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeRightSideViewLeetcode199 {

    // 定义二叉树的节点结构
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // 节点构造函数，初始化节点值
        TreeNode(int x) {
            val = x;
        }
    }

    // 包含从二叉树右侧视图获取节点值的方法的类
    public static class N0199 {
        // 从右侧看二叉树，返回看到的节点值列表
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> queue = new LinkedList<>();

            // 如果根节点为空，则返回空列表
            if (root == null) {
                return list;
            }

            // 使用队列进行层序遍历
            queue.offerLast(root);//放在队列末尾
            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode current = queue.pollFirst();

                    // 将当前节点的左右子节点加入队列
                    if (current.left != null) {
                        queue.addLast(current.left);
                    }
                    if (current.right != null) {
                        queue.addLast(current.right);
                    }

                    // 如果是当前层的最后一个节点，则将其值添加到列表
                    if (i == levelSize - 1) {
                        list.add(current.val);
                    }
                }
            }
            return list;
        }
    }

    // 从键盘输入构建二叉树的类
    public static class TreeBuilder {
        public static TreeNode buildTreeFromInput() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入二叉树的节点值序列，中间用空格分隔：");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            return buildTree(parts);
        }

        // 根据输入的节点值数组构建二叉树
        public static TreeNode buildTree(String[] parts) {
            if (parts[0].equals("null")) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int i = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (i >= parts.length) break;//若执行break会跳出while循环
                if (!parts[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(parts[i]));
                    queue.offer(node.left);
                }
                i++;

                if (i >= parts.length) break;
                if (!parts[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(parts[i]));
                    queue.offer(node.right);
                }
                i++;
            }

            return root;
        }
    }

    // 主方法，实现调用方法获取二叉树的右视图
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTreeFromInput();
        if (root == null) {
            System.out.println("二叉树的右视图是：[]");
        } else {
            N0199 solution = new N0199();
            List<Integer> rightView = solution.rightSideView(root);
            System.out.println("二叉树的右视图是：" + rightView);
        }
    }
}
