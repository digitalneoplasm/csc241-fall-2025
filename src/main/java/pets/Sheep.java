package pets;

public class Sheep implements Petable{
    private String color;

    public Sheep(String color) {
        this.color = color;
    }

    @Override
    public void pet() {
        System.out.println("The " + color + " sheep says: Baaaahhhh... ");
    }
}
