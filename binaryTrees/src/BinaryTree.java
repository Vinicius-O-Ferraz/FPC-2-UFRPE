public class BinaryTree {
    Node root;

    public BinaryTree() {root = null;}

    public void insert(int key) {root = insertRec(root, key);} // O(log n).

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key){root.left = insertRec(root.left, key);}
        else if (key > root.key){root.right = insertRec(root.right, key);}
        return root;
    }

    public void inorder() {inorderRec(root);}

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

    private Node searchNode(Node root, int key) {
        if (root == null || root.key == key ){return root;}

        if (key < root.key){return searchNode(root.left, key);}

        else{return searchNode(root.right, key);}
    }
    public int treeSuccessor(int key) {
        Node current = searchNode(root, key);
        if (current == null) {
            throw new IllegalArgumentException("Key not found in tree");
        }

        if (current.right != null) {
            return findMinRec(current.right); // Sucessor é o menor da subárvore à direita
        }

        Node successor = null;
        Node ancestor = root;
        while (ancestor != current) {
            if (current.key < ancestor.key) {
                successor = ancestor;
                ancestor = ancestor.left;
            } else {
                ancestor = ancestor.right;
            }
        }
        return successor != null ? successor.key : -1; // Retorna -1 se não houver sucessor
    }

    public int treePredecessor(int key) {
        Node current = searchNode(root, key);
        if (current == null) {
            throw new IllegalArgumentException("Key not found in tree");
        }

        if (current.left != null) {
            return findMaxRec(current.left); // Predecessor é o maior da subárvore à esquerda
        }

        Node predecessor = null;
        Node ancestor = root;
        while (ancestor != current) {
            if (current.key > ancestor.key) {
                predecessor = ancestor;
                ancestor = ancestor.right;
            } else {
                ancestor = ancestor.left;
            }
        }
        return predecessor != null ? predecessor.key : -1; // Retorna -1 se não houver predecessor
    }
}

