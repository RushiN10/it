class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BST {
    Node root;

    public BST() {
        root = null;
    }

    // Insert a new node with given key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    // A utility function to do inorder traversal of BST
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // This method mainly calls InorderRec()
    public void inorder() {
        inorderRec(root);
    }

    public static void main(String[] args) {
        BST bst = new BST();

        // Insert some elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Print inorder traversal of the BST
        System.out.println("Inorder traversal of the BST:");
        bst.inorder();
    }
}
