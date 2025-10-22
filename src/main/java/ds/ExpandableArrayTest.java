package ds;

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
    }
}
