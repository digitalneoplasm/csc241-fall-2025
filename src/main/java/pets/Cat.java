package pets;

public class Cat implements Petable{
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void pet() {
        System.out.println(name + " says: Purr... ");
    }
}
