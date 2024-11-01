public class Node {
    int key;
    Node left,right;

    public int getKey() {
        return key;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node(int item) {
        key = item;
        left = right  = null;
    }
}
