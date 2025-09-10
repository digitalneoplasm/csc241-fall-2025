package vehicles;

public class Car extends Vehicle {
    private final String model;

    public Car ( String make, String model ) {
        super (make);
        this.model = model ;
    }

    public String getModel() {
        return model;
    }


    /**
     * Print out the sound the vehicle makes.
     */
    @Override
    public String drive() {
        return "Vroom!";
    }
}