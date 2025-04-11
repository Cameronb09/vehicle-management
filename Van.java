public class Van extends Vehicle {
    private final boolean satNav;
    private final boolean parkingSensor;
    private final boolean towBar;
    private final boolean roofRack;
    private final int capacity;
    private final Wheelbase wheelbase;

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



    // getters
    public boolean hasSatNav() { return satNav; }
    public boolean hasParkingSensor() { return parkingSensor; }
    public boolean hasTowBar() { return towBar; }
    public boolean hasRoofRack() { return roofRack; }
    public int getCapacity() { return capacity;}
    public Wheelbase getWheelbase() { return wheelbase;}

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
