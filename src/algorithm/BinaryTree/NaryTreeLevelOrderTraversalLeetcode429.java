package src.algorithm.BinaryTree;

/**
 * @Author：zz
 * @Package：src.algorithm.BinaryTree
 * @Project：algorithmCode
 * @name：NaryTreeLevelOrderTraversalLeetcode429
 * @Date：2024/4/27 15:07
 */

import java.util.*;

public class NaryTreeLevelOrderTraversalLeetcode429 {

    //public static class Node：这表明 Node 是一个公共的静态内部类。
    // 公共（public）表示任何其他类都可以访问这个类，
    // 静态（static）说明这个类不依赖于外部类的实例。
    public static class Node {
        int val;
        List<Node> children;

        Node(int value) {
            this.val = value;
            this.children = new ArrayList<>();
        }
    }

    // 层序遍历N叉树
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<Node> queue = new LinkedList<>();
        queue.offerLast(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.pollFirst();
                currentLevel.add(currentNode.val);
                for (Node child : currentNode.children) {
                    if (child != null) {
                        queue.offerLast(child);
                    }
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    // 递归创建N叉树
    //好的，让我们假设我们要创建一个这样的N叉树：
    //
    //根节点值为 1，有 2 个子节点
    //第一个子节点值为 2，有 1 个子节点
    //子节点值为 4，没有子节点
    //第二个子节点值为 3，有 2 个子节点
    //第一个子节点值为 5，没有子节点
    //第二个子节点值为 6，没有子节点
    //在程序中，我们将依次输入这些节点和子节点的数量，然后根据这些输入构建N叉树。
    //
    //输入根节点的值为 1，子节点数量为 2。
    //输入第一个子节点的值为 2，子节点数量为 1。
    //输入第一个子节点的子节点值为 4，子节点数量为 0。
    //输入第二个子节点的值为 3，子节点数量为 2。
    //输入第一个子节点的子节点值为 5，子节点数量为 0。
    //输入第二个子节点的子节点值为 6，子节点数量为 0。
    public Node createNaryTree(Scanner scanner) {
        System.out.println("Enter the root node value:");
        int rootValue = scanner.nextInt();
        Node root = new Node(rootValue);

        System.out.println("Enter the number of children for the root:");
        int childrenCount = scanner.nextInt();
        List<Node> children = new ArrayList<>();

        for (int i = 0; i < childrenCount; i++) {
            System.out.println("Enter the value of child " + (i + 1) + ":");
            children.add(createNaryTree(scanner)); // 递归创建子树
        }

        root.children = children;
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NaryTreeLevelOrderTraversalLeetcode429 tree = new NaryTreeLevelOrderTraversalLeetcode429();

        Node root = tree.createNaryTree(scanner);

        List<List<Integer>> levels = tree.levelOrder(root);
        System.out.println("Level order traversal of N-ary tree is:");
        for (List<Integer> level : levels) {
            for (int val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}


/*假设创建一个N叉树，如下：

       1
     / | \
    2  3  4
   / \
  5   6
以下是递归过程的详细说明：

创建根节点：

用户输入根节点值为 1。
根节点的子节点数量为 3。
第一个子节点：

用户输入第一个子节点的值为 2。
进入递归创建以节点值 2 为根的子树。
用户输入子节点的数量为 2。
子节点的子节点：

在递归过程中，用户输入第一个子节点的子节点值为 5，并设置其子节点数量为 0。返回值为 5 的叶子节点。
用户输入第二个子节点的子节点值为 6，并设置其子节点数量为 0。返回值为 6 的叶子节点。
将这两个叶子节点加入到节点值为 2 的子节点列表中。
第二个子节点：

用户输入第二个子节点的值为 3。
递归创建以节点值 3 为根的子树，用户设置其子节点数量为 0。返回值为 3 的叶子节点。
第三个子节点：

用户输入第三个子节点的值为 4。
递归创建以节点值 4 为根的子树，用户设置其子节点数量为 0。返回值为 4 的叶子节点。
构建树结构：

根节点 1 拥有三个子节点：2、3、4。
节点 2 拥有两个子节点：5 和 6。
节点 3 和 4 没有子节点。
返回根节点：

返回根节点 1，表示树的创建完成。
这个过程通过递归来构建N叉树的结构，遵循了递归调用、递归结束、返回结果的原则。希望这个解释更清楚。如果还有其他问题，请告诉我。*/
