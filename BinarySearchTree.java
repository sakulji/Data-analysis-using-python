import java.util.Scanner;

public class BinarySearchTree {
    
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    
    public static int findSecondSmallest(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            throw new IllegalArgumentException("BST must have at least two nodes."); 
        }

        Node current = root;
        Node parent = null;

        
        while (current.left != null) {
            parent = current;
            current = current.left;
        }

        
        if (current.right != null) {
            return findMin(current.right);
        }

        
        return parent.data;
    }

    
    private static int findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    
    public static Node createBST() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements to insert into the BST: ");
        int n = scanner.nextInt();
        Node root = null;

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            root = insert(root, data);
        }

        return root;
    }

    
    public static void main(String[] args) {
        Node root = createBST();

        try {
            System.out.println("Second smallest element: " + findSecondSmallest(root));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}