public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(80);
        tree.insert(90);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(50);
        tree.insert(10);
        tree.insert(60);
        tree.insert(70);
        tree.insert(100);

        System.out.println("In order transversal: ");
        tree.inorder();

        int searchKey = 43;
        if (tree.search(searchKey))
            System.out.println("\nKey " + searchKey + " found in the tree. ");
        else
            System.out.println("\nKey " + searchKey + " not found in the tree. ");

        System.out.println("The minimum value in the tree : " +tree.findMin());
        System.out.println("The maximum value in the tree : " +tree.findMax());
    }
}