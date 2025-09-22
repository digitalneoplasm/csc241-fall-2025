package ds;

public class ExpandableArrayTest {
    public static void main(String[] args) {
        ExpandableArray ea = new ExpandableArray();
        ea.add("a");
        ea.add("b");
        ea.add("d");
        ea.add("e");
        ea.add("f");
        ea.add(2, "c");
        System.out.println(ea);
    }
}
