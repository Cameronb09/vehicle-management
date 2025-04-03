
public class Car extends Vehicle {
    private boolean satNav;
    private boolean parkingSensor;
    private boolean towBar;
    private boolean roofRack;
    private boolean allWheelDrive;
    private boolean thirdRow;

    public Car(String make, String model, int year, int VIN, Gearbox gearbox, Colour colour, Body body) {
        super(make, model, year, VIN, gearbox, colour, body);

    }
// add extras
    public void add(String option){
        switch (option.toLowerCase()) {
            case "sat nav": this.satNav = true; break;
            case "parking sensors": this.parkingSensor = true; break;
            case "tow bar": this.towBar = true; break;
            case "roof rack": this.roofRack = true; break;
            case "all wheel drivetrain":
                if (getBodyType() == Body.SUV) this.allWheelDrive = true;
                break;
            case "third row seat":
                if (getBodyType() == Body.ESTATE) this.thirdRow = true;
                break;
            default:
                System.out.println("Option not available for vehicle type");
        }
    }

// getters
    public boolean hasSatNav() { return satNav; }
    public boolean hasParkingSensor() { return parkingSensor; }
    public boolean hasTowBar() { return towBar; }
    public boolean hasRoofRack() { return roofRack; }
    public boolean hasAllWheelDrivetrain() { return allWheelDrive; }
    public boolean hasThirdRowSeat() { return thirdRow; }
}
