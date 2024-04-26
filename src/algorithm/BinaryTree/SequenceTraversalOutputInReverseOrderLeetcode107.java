package src.algorithm.BinaryTree;
/**
 * @Author：zz
 * @Package：src.algorithm.BinaryTree
 * @Project：algorithmCode
 * @name：SequenceTraversalOutputInReverseOrderLeetcode107
 * @Date：2024/4/26 10:28
 */
import java.util.*;

public class SequenceTraversalOutputInReverseOrderLeetcode107 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组（元素之间用空格分隔，null表示空节点）:");
        String[] parts = scanner.nextLine().split("\\s+");
        TreeNode root = buildTree(parts);

        List<List<Integer>> result = levelOrderBottom(root);
        System.out.println("翻转后的层序遍历结果为:");
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    // 构建二叉树
     static TreeNode buildTree(String[] parts) {
        if (parts[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (i >= parts.length) break;
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

    // 层序遍历并翻转结果
    static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int levelSize = queue.size();
            for (int j = 0; j < levelSize; j++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(levelList);
        }

        Collections.reverse(list);//collections是工具类
        return list;
    }
}
