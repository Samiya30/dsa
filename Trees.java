import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class trees {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    
// 1. inorder traversal
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

// 2. preorder traversal
    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
// 3. postorder trversal
    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

// 4. height of the tree
    public static int height(Node root){
        if(root==null) return 0;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return Math.max(leftHeight, rightHeight);

    }

// 5. count the number of nodes
    public static int count(Node root){
        if(root==null) return 0;
        return 1+count(root.left)+count(root.right);
    }

// 6. search the node
    public static boolean search(Node root,int k){
        if(root==null) return false;
        if(root.data==k) return true;
        return search(root.left,k)||search(root.right,k);
    }

// 7. print the levels of tree
    public static void printlevel(Node root,int k){
        if(root==null) return;
        if(k==1) {
            System.out.println(root.data+" ");
        }
        else{
            printlevel(root.left, k-1);
            printlevel(root.right, k-1);
        }
    }

// 7. max value of the node in tree
    public static int maxValue(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int leftMax=maxValue(root.left);
        int rightMax=maxValue(root.right);
        return Math.max(root.data,Math.max(leftMax,rightMax));
    }

// 8. count the number of leaf nodes
    public static int leafNode(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        return leafNode(root.left)+leafNode((root.right));
    }

// 9. sum of all the nodes
    public static int sum(Node root){
        if(root==null) return 0;
        return root.data+sum(root.left)+sum(root.right);
    }

// 10. insert at first available position in level order insertion
    public static Node InsertatfirstPosition(Node root,int value){
        Node newNode = new Node(value);
         if (root == null) {
            return newNode;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left == null) {
                temp.left = newNode;
                return root;
            } else {
                queue.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = newNode;
                return root;
            } else {
                queue.add(temp.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        // Tree t = new Tree();
        // t.root = t.insert(t.root, 5);
        // t.insert(t.root, 3);
        // t.insert(t.root, 7);
        // t.insert(t.root, 2);
        // t.insert(t.root, 4);
        // t.insert(t.root, 6);
        // t.insert(t.root, 8);
        // System.out.println("Inorder traversal:");
        // t.inorder(t.root);
        // System.out.println("\nPreorder traversal:");
        // t.preorder(t.root);
        // System.out.println("\nPostorder traversal:");
        // t.postorder(t.root);
        // System.out.println(height(t));

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        System.out.println("Inorder traversal: ");
        inorder(root);
        System.out.println("\nHeight of tree is : " + height(root));
        System.out.println("\nno of nodes in tree is : " + count(root));
        System.out.println("Is 3 in tree: "+search(root, 3));
        System.out.println("Is 19 in tree: "+search(root, 19));
        System.out.println("Nodes at level 2 : ");
        printlevel(root, 2);
        System.out.println("Maximum value : "+maxValue(root));
        System.out.println("Number of leaves in binary tree is : "+leafNode(root));
        System.out.println("sum of all nodes : "+sum(root));
        System.out.println("post order traversal : ");
        postorder(root);
        InsertatfirstPosition(root,10);
        printlevel(root, 1);
        printlevel(root, 2);
        printlevel(root, 3);
    }
}
