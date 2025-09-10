package vehicles;

public class Main {
    public static void main(String[] args) {
        Car c = new Car("Nissan", "GT-R");
        System.out.println(c.getMake());

        Vehicle t = new Tractor("Kubota", false);
        System.out.println(t.getMake());

        System.out.println(t.drive());

        //Vehicle v = new Vehicle("Chevrolet");
        System.out.println(t);
        System.out.println(c);
    }
}
