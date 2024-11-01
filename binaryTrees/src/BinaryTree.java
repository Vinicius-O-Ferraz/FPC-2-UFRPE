public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int key) {root = insertRec(root, key);}

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key){root.left = insertRec(root.left, key);}
        else if (key > root.key){root.right = insertRec(root.right, key);}
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public boolean search(int key) {return searchRec(root, key);}

    private boolean searchRec(Node root, int key) {
        if (root == null){return false;}

        if (root.key == key){return true;}

        if (key < root.key){return searchRec(root.left, key);}

        else{return searchRec(root.right, key);}
    }

    public int findMin() {return findMinRec(root);}

    private int findMinRec(Node root) {
        if (root == null) {throw new IllegalArgumentException("Tree is empty");}

        if (root.left == null) {return root.key;}

        return findMinRec(root.left);
    }

    public int findMax() {return findMaxRec(root);}

    private int findMaxRec(Node root) {
        if (root == null){throw new IllegalStateException("Tree is empty");}

        if (root.right == null){return root.key;}

        return findMaxRec(root.right);
    }
}

