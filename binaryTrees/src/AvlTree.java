public class AvlTree extends BinaryTree {
    public AvlTree() {}

    // Método de rotação à esquerda
    public void leftRotate(BinaryTree tree, Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != null) { y.left.root = x; }

        y.root = x.root;

        if (x.root == null) {
            tree.root = y;
        } else if (x == x.root.left) {
            x.root.left = y;
        } else {
            x.root.right = y;
        }

        y.left = x;
        x.root = y;
    }

    // Método de rotação à direita
    public void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;

        if (y.right != null) { y.right.root = x; }

        y.root = x.root;

        if (x.root == null) {
            root = y;
        } else if (x == x.root.right) {
            x.root.right = y;
        } else {
            x.root.left = y;
        }

        y.right = x;
        x.root = y;
    }
}
