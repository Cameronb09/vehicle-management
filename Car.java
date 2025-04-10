public class Car extends Vehicle {
    private boolean satNav;
    private boolean parkingSensor;
    private boolean towBar;
    private boolean roofRack;
    private boolean allWheelDrive;
    private boolean thirdRow;

    public Car(String make, String model, int year, int VIN, int mileage, Gearbox gearbox, Colour colour, Body body, boolean sn, boolean ps, boolean tb, boolean rr, boolean aw, boolean tr) {
        super(make, model, year, VIN, mileage, gearbox, colour, body);
            this.satNav = sn;
            this.parkingSensor = ps;
            this.towBar = tb;
            this.roofRack = rr;
            this.allWheelDrive = aw;
            this.thirdRow = tr;
    }

// getters
    public boolean hasSatNav() { return satNav; }
    public boolean hasParkingSensor() { return parkingSensor; }
    public boolean hasTowBar() { return towBar; }
    public boolean hasRoofRack() { return roofRack; }
    public boolean hasAllWheelDrivetrain() { return allWheelDrive; }
    public boolean hasThirdRowSeat() { return thirdRow; }

    @Override
    public String toString() {
        return super.toString() + '\n' +
        "Sat nav?: " + satNav + '\n' +
        "Parking sensors?: " + parkingSensor + '\n' +
        "Tow bar?: " + towBar + '\n' +
        "Roof rack?: " + roofRack + '\n' +
        "All wheel drive?: " + allWheelDrive + '\n' +
         "Third row seats?: " + thirdRow;
    }

}
