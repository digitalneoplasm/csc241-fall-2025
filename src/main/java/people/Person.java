package people;

import pets.Petable;

import java.util.ArrayList;

public class Person {
    private String name;
    private ArrayList<Petable> petablePets;

    public Person(String name) {
        this.name = name;
        petablePets = new ArrayList<>();
    }

    public void adoptPet(Petable pet) {
        petablePets.add(pet);
    }

    public void petAllPets() {
        for (Petable p : petablePets) {
            p.pet();
        }
    }
}
