package ds;

public class LLTest {
    public static void main(String[] args) {
        SinglyLinkedList<String> sll = new SinglyLinkedList<>();
        sll.addFirst("c");
        sll.addFirst("b");
        sll.addFirst("a");
        System.out.println(sll);

        System.out.println("Index 0 : " + sll.get(0));
        System.out.println("Index 2 : " + sll.get(2));
        //System.out.println("Index 3 : " + sll.get(3));

        SinglyLinkedList<Integer> sllIntegers = new SinglyLinkedList<>();
        sllIntegers.addFirst(12);
        sllIntegers.addFirst(4);
        sllIntegers.addFirst(4700);
        System.out.println(sllIntegers);
    }
}
