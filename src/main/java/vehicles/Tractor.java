package vehicles;

public class Tractor extends Vehicle{
    private final boolean hasTracks;

    public Tractor(String make, boolean hasTracks) {
        super(make);
        this.hasTracks = hasTracks;
    }

    public boolean getHasTracks() {
        return hasTracks;
    }

    /**
     * Print out the sound the vehicle makes.
     */
    @Override
    public String drive() {
        return "Chug-a-chug-a";
    }
}
