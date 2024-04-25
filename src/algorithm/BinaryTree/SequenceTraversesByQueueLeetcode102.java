package src.algorithm.BinaryTree;

/**
 * @Author：zz
 * @Package：src.algorithm.BinaryTree
 * @Project：algorithmCode
 * @name：SequenceTraversesByQueueLeetcode102
 * @Date：2024/4/25 12:23
 */


import java.util.*;//引入所有

public class SequenceTraversesByQueueLeetcode102 {
    // TreeNode 类定义
    static class TreeNode {
        int val;
        TreeNode left;
        //TreeNode left; 定义了 TreeNode 类的一个属性，这个属性也是一个 TreeNode 类型的对象。
        // 这意味着每个 TreeNode 对象可以拥有一个指向另一个 TreeNode 对象的引用作为其左子节点。
        TreeNode right;

        TreeNode(int x) { val = x; }//构造方法，同时满足两个条件，1：无任何返回值，连void也没有.2：和类同名。
    }

    // 构建二叉树的方法
    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes.length == 0 || nodes[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            if (i < nodes.length && nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    // 层序遍历方法
    public static List<List<Integer>> checkFun02(TreeNode node) {
        List<List<Integer>> resList = new ArrayList<>();
        if (node == null) return resList;

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            int len = que.size();
            List<Integer> itemList = new ArrayList<Integer>();

            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;
            }
            resList.add(itemList);
        }
        return resList;
    }

    // 主函数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组元素，使用英文逗号分隔，null表示无子节点:");

        String inputLine = scanner.nextLine();
        String[] parts = inputLine.split(",");//只能分割英文逗号
        Integer[] input = new Integer[parts.length];
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].trim().equals("null")) {
                input[i] = null;
            } else {
                input[i] = Integer.parseInt(parts[i].trim());
            }
        }

        TreeNode root = buildTree(input); // 构建二叉树
        List<List<Integer>> output = checkFun02(root); // 层序遍历二叉树

        // 打印输出结果
        for (List<Integer> level : output) {
            System.out.println(level);
        }
        scanner.close();
    }
}
