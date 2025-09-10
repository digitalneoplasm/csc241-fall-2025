package graphics;

public class Main {
    public static void main(String[] args) {
//        Movable go = new GraphicObject(1,1);
//        System.out.println(go);
//        go.moveTo(2,3);
//        System.out.println(go);

        Rectangle r = new Rectangle(1,1,10,20);
        System.out.println(r);
        r.moveTo(5, 3);
        System.out.println(r);

        r.resize(.5);
        System.out.println(r);
    }
}
