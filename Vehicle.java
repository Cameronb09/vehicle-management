import java.io.Serializable;

public abstract class Vehicle implements Serializable, Comparable<Vehicle> {
    private final String make;
    private final String model;
    private final int year;    // years
    private final int VIN;
    private int mileage;
    private final Gearbox gearbox;
    private Colour colour;
    private final Body body;

    public Vehicle(String make, String model, int year, int VIN, int mileage, Gearbox gearbox, Colour colour, Body body) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.VIN = VIN;
        this.mileage = mileage;
        this.gearbox = gearbox;
        this.colour = colour;
        this.body = body;

    }

//getters and setters

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getVIN() {
        return VIN;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {this.mileage = mileage;}

    public Body getBodyType() { return body; }

    public void setColour(Colour colour) {this.colour = colour;}


    public Colour getColour() { return colour; }

    public Gearbox getGearbox() { return gearbox;}


    public void addOption(String satNav) {
    }

    @Override
    public int compareTo(Vehicle other) {
        return Integer.compare(this.VIN, other.VIN);
    }
}
