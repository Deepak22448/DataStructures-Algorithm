package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IntroToBst {
    static Node root = null;
    public static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void levelOrderTraversal(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        System.out.println("Printing LevelOrder of Tree");

        while (!queue.isEmpty()) {
            Node pop = queue.poll();

            if (pop == null) {
                System.out.println();
                if (!queue.isEmpty())
                    queue.offer(null);
            } else {
                System.out.print(pop.data + " ");

                if (pop.left != null)
                    queue.offer(pop.left);
                if (pop.right != null)
                    queue.offer(pop.right);
            }

        }
    }

    public static Node insertIntoBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data > root.data)
            root.right = insertIntoBST(root.right, data);
        else
            root.left = insertIntoBST(root.left, data);

        return root;
    }

    public static Node takeInput(Node root) {
        System.out.println("Enter data to create a BST");
        int data = sc.nextInt();

        while (data != -1) {
            root = insertIntoBST(root, data);
            data = sc.nextInt();
        }

        return root;

    }

    public static int minVal(Node root) {
        if (root == null)
            return -1;
        if (root.left == null)
            return root.data;

        return minVal(root.left);
    }

    public static Node deleteFromBST(Node root, int data) {
        if (root == null)
            return root;

        if (data > root.data) {
            root.right = deleteFromBST(root.right, data);
            return root;
        } else if (data < root.data) {
            root.left = deleteFromBST(root.left, data);
            return root;
        } else {
            if (root.left == null && root.right == null)
                return null;
            else if (root.left == null && root.right != null)
                return root.left;
            else if (root.left != null && root.right == null)
                return root.right;
            else {
                int minVal = minVal(root.right);
                root.data = minVal;
                root.right = deleteFromBST(root.right, minVal);
                return root;
            }

        }

    }

    public static void main(String[] args) {
        root = takeInput(root);
        levelOrderTraversal(root);
        System.out.println("The Minimum Value is " + minVal(root));
        deleteFromBST(root, 10);
        levelOrderTraversal(root);
    }
}
