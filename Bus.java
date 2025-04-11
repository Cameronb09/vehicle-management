public class Bus extends Vehicle {
    private final boolean satNav;
    private final boolean parkingSensor;
    private final Bustype busType;
    private int busCap;
    private final boolean fueltank;

    public Bus(String make, String model, int year, int VIN, int mileage, Colour colour, int busCap, Bustype busType, boolean sn, boolean ps, boolean ft) {
        super(make, model, year, VIN, mileage, Gearbox.AUTO, colour, null);
        this.satNav = sn;
        this.parkingSensor = ps;
        this.busType = busType;
        this.fueltank = ft;
    }

    // getters
    public boolean hasSatNav() { return satNav; }
    public boolean hasParkingSensor() { return parkingSensor; }

    @Override
    public String toString() {
        return super.toString() + '\n' +
        "Sat nav?: " + satNav + '\n' +
        "Seating Capacity: " + busCap + '\n' +
        "Type: " + busType + '\n' +
        "Parking sensors?: " + parkingSensor + '\n' +
        "Fuel tank over 200 Litres?: " + fueltank;
    }
}
