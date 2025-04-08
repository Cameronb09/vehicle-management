
public class Van extends Vehicle {
    private boolean satNav;
    private boolean parkingSensor;
    private boolean towBar;
    private boolean roofRack;
    private int capacity;
    private Wheelbase wheelbase;

    public Van(String make, String model, int year, int VIN, int mileage, Gearbox gearbox, Colour colour, int vanCap, Wheelbase wheelbase, boolean sn, boolean ps, boolean tb, boolean rr) {
        super(make, model, year, VIN, mileage, gearbox, colour, null);
        this.satNav = sn;
        this.parkingSensor = ps;
        this.towBar = tb;
        this.roofRack = rr;
        this.capacity = vanCap;
        this.wheelbase = wheelbase;



    }
    // add extras
    public void add(String option) {
        switch (option.toLowerCase()) {
            case "sat nav":
                this.satNav = true;
                break;
            case "parking sensors":
                this.parkingSensor = true;
                break;
            case "tow bar":
                this.towBar = true;
                break;
            case "roof rack":
                this.roofRack = true;
                break;
        }
    }

    // getters
    public boolean hasSatNav() { return satNav; }
    public boolean hasParkingSensor() { return parkingSensor; }
    public boolean hasTowBar() { return towBar; }
    public boolean hasRoofRack() { return roofRack; }
    public int getCapacity() { return capacity;}
    public Wheelbase getWheelbase() { return wheelbase;}


    @Override
    public int compareTo(Vehicle o) {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Sat nav?: " + satNav + '\n' +
                "Parking sensors?: " + parkingSensor + '\n' +
                "Tow bar?: " + towBar + '\n' +
                "Roof rack?: " + roofRack + '\n' +
                "Capacity (cubic M): " + capacity + '\n' +
                "Wheelbase: " + wheelbase;

    }

}
