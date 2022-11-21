package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Tree {

    static Node root = null;
    private static class Node {
        int data;
        Node left , right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Scanner sc = new Scanner(System.in);

    public static Node buildTree(Node root){
        System.out.println("Enter The data : ");
        int data = sc.nextInt();

        if(data == -1) return null;
        
        root = new Node(data);
        System.out.println("Enter the data to insert in left " + data);
        root.left = buildTree(root.left);

        System.out.println("Enter data for inserting in right " + data);
        root.right = buildTree(root.right);

        return root;
    }

    public static void buildTreeLevelOrder(){
        Queue<Node> queue = new LinkedList<>();
        System.out.println("Enter Data For root :");
        int data = sc.nextInt();
        root = new Node(data);
        queue.offer(root);


        while(!queue.isEmpty()){
            Node temp = queue.poll();

            System.out.println("Enter data for left node of " + temp.data);
            int leftData = sc.nextInt();

            if(leftData != -1){
                temp.left = new Node(leftData);
                queue.offer(temp.left);
            }

            System.out.println("Enter data for right node of " + temp.data);
            int rightData = sc.nextInt();
            if(rightData != -1){
                temp.right = new Node(rightData);
                queue.offer(temp.right);
            }

        }


    }

    public static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        System.out.println("Printing Level Order Traversel");

        while(!q.isEmpty()){
            Node temp = q.poll();
            
            if(temp == null){
                System.out.println();
                if(!q.isEmpty()) q.offer(null);
            } else {
                System.out.print(temp.data +  " ");
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }

        }
    }

    public static void reverseLevelOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(node);
        queue.offer(null);
        stack.add(null);
        
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            stack.push(temp);
            if(temp == null){
                if(!queue.isEmpty()) queue.add(null);
            } else {
                if(temp.right != null) queue.offer(temp.right);
                if(temp.left != null) queue.offer(temp.left);
            } 

        }

        stack.pop();
        System.out.println("Printing Reverse Level Order traversel");
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            if(pop == null) System.out.println();
            else System.out.print(pop.data + " ");
        }
        
    }

    public static void inOrderTraversal(Node node) {
        if(node == null) return;

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);

    }

    public static void preOrderTraversal(Node node){
        if(node == null) return;

        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void postOrderTraversal(Node node){
        if(node == null) return;

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public static void inOrderIterative(Node node){
        Stack<Node> stack = new Stack<>();
        while(node != null || stack.size() > 0){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.data + " ");
            node = node.right;
        }
        System.out.println();
    }

    public static void preOrderIterative(Node node){
        Stack<Node> stack = new Stack<>();
        while(node != null || stack.size() > 0){
            while(node != null){
                System.out.print(node.data + " ");
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        System.out.println();
    }

    // 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
;
    public static void main(String[] args) {
        // root = buildTree(root);
        // buildTreeLevelOrder();
        // levelOrderTraversal(root);
        // reverseLevelOrder(root);
        // inOrderTraversal(root);
        // preOrderTraversal(root);
        // postOrderTraversal(root);
        // inOrderIterative(root);
        // preOrderIterative(root);
    }
}
