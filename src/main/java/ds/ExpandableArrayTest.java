package ds;

import java.util.Random;

public class ExpandableArrayTest {
    public static void main(String[] args) {
        ExpandableArray<String> ea = new ExpandableArray<>();
        ea.add("a");
        ea.add("b");
        ea.add("d");
        ea.add("e");
        ea.add("f");
        ea.add(2, "c");
        System.out.println(ea);
        ea.set(0, "start");
        ea.set(ea.size() - 1, "end");
        System.out.println(ea);
        ea.remove(0);
        ea.remove(ea.size() - 1);
        System.out.println(ea);
        ea.clear();
        System.out.println(ea);

        System.out.println("--- sort tests --- ");
        ExpandableArray<Integer> sortTest = new ExpandableArray<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            sortTest.add(r.nextInt(100));
        }
        System.out.println("Initial list: " + sortTest);
        sortTest.bubbleSort();
        System.out.println("Sorted list: " + sortTest);
    }
}
