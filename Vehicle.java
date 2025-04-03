

public abstract class Vehicle {

    private String make;
    private String model;
    private int year;    // years
    private int VIN;
    private Gearbox gearbox;
    private Colour colour;
    private Body body;

    public Vehicle(String make, String model, int year, int VIN, Gearbox gearbox, Colour colour, Body body) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.VIN = VIN;
        this.gearbox = gearbox;
        this.colour = colour;
        this.body = body;

    }

//getters and setters

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public Body getBodyType() { return body; }

    public void setColour(Colour colour) {this.colour = colour;}


    public Colour getColour() { return colour; }

    public Gearbox getGearbox() { return gearbox;}


    public void addOption(String satNav) {
    }
}
