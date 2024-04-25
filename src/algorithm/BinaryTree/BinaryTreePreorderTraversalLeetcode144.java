package src.algorithm.BinaryTree;

/**
 * @Author：zz
 * @Package：src.algorithm.BinaryTree
 * @Project：algorithmCode
 * @name：BinaryTreePreorderTraversalLeetcode144
 * @Date：2024/4/15 14:03
 */


//深度优先遍历包含前中后，广度优先遍历包含层序遍历
import java.util.Scanner;

public class BinaryTreePreorderTraversalLeetcode144 {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        public BinarySearchTree() {
            root = null;
        }

        // 插入新节点的方法
        public void insert(int value) {
            root = insertRec(root, value);
        }

        private Node insertRec(Node root, int value) {
            if (root == null) {
                root = new Node(value);
                return root;
            }
            if (value < root.value) {
                root.left = insertRec(root.left, value);
            } else if (value > root.value) {
                root.right = insertRec(root.right, value);
            }
            return root;
        }

        // 前序遍历
        public void preorderTraversal() {
            preorderRec(root);
            System.out.println(); // 输出换行，以美化输出格式
        }

        private void preorderRec(Node root) {
            if (root != null) {
                System.out.print(root.value + " ");
                preorderRec(root.left);
                preorderRec(root.right);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入二叉树的元素数:");
        int elementsCount = scanner.nextInt();

        System.out.println("输入元素值:");
        for (int i = 0; i < elementsCount; i++) {
            bst.insert(scanner.nextInt());
        }

        System.out.println("前序遍历输出:");
        bst.preorderTraversal();
        scanner.close();
    }
}
