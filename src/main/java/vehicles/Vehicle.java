package vehicles;

public abstract class Vehicle {
    private final String make;

    public Vehicle ( String make ) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    /**
     * Print out the sound the vehicle makes.
     */
    public abstract String drive();

    @Override
    public String toString() {
        return "The " + make + " makes a " + drive() + " sound.";
    }
}
