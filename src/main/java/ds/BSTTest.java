package ds;

public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.insert(10);
        bst.insert(6);
        bst.insert(8);
        bst.insert(4);
        System.out.println(bst);

        System.out.println("Find 10? " + bst.find(10));
        System.out.println("Find 6? " +bst.find(6));
        System.out.println("Find 8? " +bst.find(8));
        System.out.println("Find 4? " +bst.find(4));
        System.out.println("Find 2? " +bst.find(2));

        System.out.println(bst.sorted());
    }
}
