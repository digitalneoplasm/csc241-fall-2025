package pets;

import people.Person;

public class Main {
    public static void main(String[] args) {
        Person adam = new Person("Adam");
        Cat timmy = new Cat("Timmy");
        adam.adoptPet(timmy);
        adam.adoptPet(new Cat("Dog"));
        adam.adoptPet(new Sheep("black"));

        adam.petAllPets();
    }
}
