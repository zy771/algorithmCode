package src.algorithm.BinaryTree;

/**
 * @Author：zz
 * @Package：src.algorithm.BinaryTree
 * @Project：algorithmCode
 * @name：FindLargestValueInEachTreeRowLeetcode515
 * @Date：2024/4/27 16:57
 */

import java.util.*;


    public class FindLargestValueInEachTreeRowLeetcode515 {
        // 定义二叉树节点类
        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int val) {
                this.val = val;
            }
        }

        // 查找每一层的最大值方法
        public List<Integer> largestValues(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int max = Integer.MIN_VALUE;
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    max = Math.max(max, node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                result.add(max);
            }
            return result;
        }

        // 使用层序遍历构建二叉树的方法
        public static TreeNode buildTree(String[] parts) {
            if (parts[0].equals("null")) return null;

            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
            queue.offer(root);
            int i = 1;
            while (!queue.isEmpty() && i < parts.length) {
                TreeNode node = queue.poll();

                if (i < parts.length && !parts[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(parts[i]));//只有静态类才可不创建实例直接调用
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

        // 主方法
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the node values separated by spaces (e.g., 1 2 3 null null 4):");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            FindLargestValueInEachTreeRowLeetcode515 solution = new FindLargestValueInEachTreeRowLeetcode515();
            TreeNode root = buildTree(parts);

            // 调用largestValues方法并输出结果
            List<Integer> largestValues = solution.largestValues(root);
            System.out.println("Largest values in each level: " + largestValues);
        }
    }
