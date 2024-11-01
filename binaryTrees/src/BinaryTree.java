//public class BinaryTree {
//    Node root;
//
//    public BinaryTree() {
//        root = null;
//    }
//
//    public void insert(int key) {
//        root = insertRec(root, key);
//    }
//
//    private Node insertRec(Node root, int key) {
//        if (root == null) {
//            root = new Node(key);
//            return root;
//        }
//
//        if (key < root.key)
//            root.left = insertRec(root.left, key);
//        else if (key > root.key)
//            root.right = insertRec(root.right, key);
//        return root;
//    }
//
//    public void inOrder() {inOrderRec(root);}
//
//    private void inOrderRec(Node root) {
//        if (root != null) {
//            inOrderRec(root.left);
//            System.out.println(root.key + " ");
//            inOrderRec(root.right);
//        }
//
//    private boolean searchRec(Node root, int key) {
//        if (root == null)
//            return false;
//
//        if (root.key == key)
//            return true;
//
//        if (key < root.key)
//            return searchRec(root.left, key);
//        else
//            return searchRec(root.right, key);
//    }
//
//    public boolean search(int key){
//        return searchRec(root,key);
//    }
//
//    }
//}


// BinaryTree Class
public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Method to insert a new node with given key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    private Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // return the (unchanged) node pointer
        return root;
    }

    // Method to print the tree inorder
    public void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Method to search for a key in the tree
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // A utility function to search for a key in BST
    private boolean searchRec(Node root, int key) {
        if (root == null)
            return false;

        if (root.key == key)
            return true;

        if (key < root.key)
            return searchRec(root.left, key);
        else
            return searchRec(root.right, key);
    }

    public int findMin() {
        return findMinRec(root);
    }

    private int findMinRec(Node root) {
        if (root == null) {throw new IllegalArgumentException("Tree is empty");}
        if (root.left == null) {return root.key;}
        return findMinRec(root.left);
    }

    public int findMax() {
        return findMaxRec(root);
    }

    // A utility function to find the maximum value in BST
    private int findMaxRec(Node root) {
        if (root == null)
            throw new IllegalStateException("Tree is empty");

        if (root.right == null)
            return root.key;

        return findMaxRec(root.right);
    }
}

