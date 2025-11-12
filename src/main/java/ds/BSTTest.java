package ds;

public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.insert(10);
        bst.insert(6);
        bst.insert(8);
        bst.insert(4);
        System.out.println(bst);
    }
}
