import devtools.io.Data;
import devtools.ui.Application;
import devtools.ui.Menu;
import devtools.util.CollectionUtils;
import devtools.util.Reader;
import devtools.util.Sequence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    @Data
    public List<Vehicle> vehicles = new ArrayList<>();

    @Data
    public Sequence seq = new Sequence(1, 1_000_000, "C");

    public static void main(String[] args) {
        Main main = new Main();
        main.loadSampleData();
        Application.start(Main.class);
    }

    private void loadSampleData() {
        vehicles.add(new Car("Vauxhall", "Corsa", 2025, 12345, 200, Gearbox.AUTO, Colour.BLUE, Body.HATCHBACK, true, true, false, false, false, false));
        vehicles.add(new Car("Ford", "Fiesta", 2021, 12347, 1000, Gearbox.MANUAL, Colour.RED, Body.HATCHBACK, true, true, true, false, false, false));

        vehicles.add(new Car("BMW", "3 Series", 2010, 66778899, 80000, Gearbox.AUTO, Colour.BLUE, Body.SALOON, false, false, false, false, false, false));
        vehicles.add(new Car("Audi", "A3", 2018, 6688770, 19000, Gearbox.MANUAL, Colour.BLACK, Body.SALOON, false, true, true, false, false, false));

        vehicles.add(new Car("VW", "Golf", 2019, 3344557, 20000, Gearbox.AUTO, Colour.WHITE, Body.ESTATE, true, true, true, true, false, true));
        vehicles.add(new Car("Vauxhall", "Astra", 2023, 3345567, 10000, Gearbox.MANUAL, Colour.BLACK, Body.ESTATE, true, true, true, false, false, true));

        vehicles.add(new Car("Volvo", "XC40", 2021, 22446688, 8000, Gearbox.AUTO, Colour.BLACK, Body.SUV, true, true, true, true, true, false));
        vehicles.add(new Car("Kia", "Sportage", 2020, 2425577, 10000, Gearbox.MANUAL, Colour.GREY, Body.SUV, true, true, false, false, true, false));

        vehicles.add(new Motorbike("Honda", "MB1", 2023, 11223344, 500, Gearbox.MANUAL, Colour.YELLOW, true));
        vehicles.add(new Motorbike("Yamaha", "MB2", 2020, 11335577, 1200, Gearbox.MANUAL, Colour.GREEN, false));

        vehicles.add(new Bus("Mercedes", "Tourismo", 2018, 333333, 100000, Colour.BLACK, 50, Bustype.COACH, true, false, true));
    }


    // check vin
    public boolean newVIN(int vin) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVIN() == vin) {
                return false;
            }
        }
        return true;
    }

    // ----- menu -----

    // ----- car -----
    @Menu(command = "C", description = "Create vehicle", id = 0,
            subMenuIDs = {1, 2, 9, 10})
    @Menu(command = "C", description = "Create a Car", id = 1)
    public void createC() {

        //input for car
        String carMake = Reader.readLine("Enter Car Make:");
        String carModel = Reader.readLine("Enter Car Model:", 1, 10);
        int carYear = Reader.readInt("Enter Car year:", 2000, 2025);
        int carVIN;
            do {
                carVIN = Reader.readInt("Enter Car VIN:"); //must be unique
                if (!newVIN(carVIN)) {
                    System.out.println("Sorry, VIN already used - please enter a unique VIN:");
                }
            } while (!newVIN(carVIN));
        int carMileage = Reader.readInt("Enter car mileage:");
        Gearbox gearbox = Reader.readEnum("Select gearbox type:", Gearbox.class);
        System.out.println("You selected: " + gearbox);
        Colour colour = Reader.readEnum("Select colour:", Colour.class);
        System.out.println("You selected " + colour);
        Body carBody = Reader.readEnum("Select body type: ", Body.class);
        System.out.println("You selected: " + carBody);
        boolean sn = Reader.readBoolean("Does it have a sat nav?");
        boolean ps = Reader.readBoolean("Does it have parking sensors?");
        boolean tb = Reader.readBoolean("Does it have a tow bar?");
        boolean rr = Reader.readBoolean("Does it have a roof rack?");
        boolean aw = false;
            if (carBody == Body.SUV) {
                aw = Reader.readBoolean("Does it have all wheel drive?"); //SUV only
            }
        boolean tr = false;
            if (carBody == Body.ESTATE) {
                tr = Reader.readBoolean("Does it have third row seats?"); // Estates only
            }

        Car car = new Car(carMake, carModel, carYear, carVIN, carMileage, gearbox, colour, carBody, sn, ps, tb, rr, aw, tr);

        vehicles.add(car);
        System.out.println("Car created");
    }

    // ----- motorbike -----

    @Menu(command = "M", description = "Create Motorbike", id = 2)
    public void createM() {
        //input for motorbike
        System.out.println("\nEnter details for Motorbike:");
        String bikeMake = Reader.readLine("Enter motorbike make: ");
        String bikeModel = Reader.readLine("Enter motorbike model: ");
        int bikeYear = Reader.readInt("Enter motorbike year: ", 2000, 2025);
        int bikeVIN;
            do {
                bikeVIN = Reader.readInt("Enter motorbike vin: "); //must be unique
                if(!newVIN(bikeVIN)) {
                    System.out.println("Sorry, VIN already used - please enter a unique VIN:");
                }
            } while (!newVIN(bikeVIN));
        int bikeMileage = Reader.readInt("Enter motorbike mileage:");
        Gearbox bikeGearbox = Reader.readEnum("Select gearbox type: ", Gearbox.class);
        System.out.println("You selected " + bikeGearbox);
        Colour bikeColour = Reader.readEnum("Select colour:", Colour.class);
        System.out.println("You selected " + bikeColour);
        boolean lb = Reader.readBoolean("Does it have a luggage box?");

        Motorbike motorbike = new Motorbike(bikeMake, bikeModel, bikeYear, bikeVIN, bikeMileage, bikeGearbox, bikeColour, lb);

        vehicles.add(motorbike);
        System.out.println("Motorbike created");
    }

    // ----- list -----

    @Menu(command = "L", description = "View a list of all cars and motorbikes", id = 3)
    public void listVehicles() {
        Collections.sort(vehicles);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    // ----- search -----

    private Vehicle search() {
        String key = Reader.readLine("Enter details to search:");
        Collection<Vehicle> search = CollectionUtils.search(key, vehicles);
        Vehicle vehicle = Reader.readObject("Choose vehicle", search);
        return vehicle;
    }

    @Menu(command = "S", description = "Search for a car or motorbike", id = 4, global = true)
    public void searchV() {
        Vehicle vehicle = search();
        if (vehicle != null) {
            System.out.println(vehicle);
        } else {
            System.out.println("No vehicle found");
        }
    }

    // ----- update -----

    @Menu(command = "U0", description = "Update", id = 8, subMenuIDs = {5, 7})
    @Menu(command = "U", description = "Update vehicle details", id = 5)
    public void updateContact() {
        Vehicle vehicle = search();
        if (vehicle == null) {
            System.out.println("No vehicle was found!");
            return;
        }

        boolean updated = false;
        if (Reader.readBoolean("Update colour? ")) {
            vehicle.setColour(Reader.readEnum("Colour: ", Colour.class));
            updated = true;
        }

        if (Reader.readBoolean("Update mileage?")) {
            vehicle.setMileage(Reader.readInt("Mileage:"));
            updated = true;
        }

        if (vehicle instanceof Motorbike) {
            Motorbike mb = (Motorbike) vehicle;
            if (Reader.readBoolean("Update additional features? ")) {
                mb.setLuggageBox(Boolean.parseBoolean(Reader.readLine("Does it have a luggage box?: ")));
                updated = true;
            }
        }

    if (updated) {
        System.out.println("Vehicle successfully updated");
    } else {
        System.out.println("No changes have been made");
    }
    }

    // ----- delete -----

    @Menu(command = "D", description = "Delete a vehicle", id = 6)
    public void deleteVehicle() {
        Vehicle vehicle = search();
        if (vehicle == null) {
            System.out.println("No vehicle found");
            return;
        } else {
            System.out.println(vehicle);
        }
        if (Reader.readBoolean("Delete the vehicle?")) {
            vehicles.remove(vehicle);
            System.out.println("Vehicle successfully deleted");
        } else {
            System.out.println("Vehicle not deleted");
        }
    }

    // -------------- additional feature -----------------

    @Menu(command = "V", description = "Create a Van", id = 9)
    public void createV() {
        //input for van
        String vanMake = Reader.readLine("Enter Van Make:");
        String vanModel = Reader.readLine("Enter Van Model:", 1, 10);
        int vanYear = Reader.readInt("Enter Van year:", 2000, 2025);
        int vanVIN;
        do {
            vanVIN = Reader.readInt("Enter Van VIN:"); //must be unique
            if (!newVIN(vanVIN)) {
                System.out.println("Sorry, VIN already used - please enter a unique VIN:");
            }
        } while (!newVIN(vanVIN));
        int vanMileage = Reader.readInt("Enter van mileage:");
        Gearbox gearbox = Reader.readEnum("Select gearbox type:", Gearbox.class);
        Colour colour = Reader.readEnum("Select colour:", Colour.class);
        int vanCap = Reader.readInt("Enter loading capacity (in cubic metres");
        Wheelbase wheelbase = Reader.readEnum("Select Wheelbase:", Wheelbase.class);
        boolean sn = Reader.readBoolean("Does it have a sat nav?");
        boolean ps = Reader.readBoolean("Does it have parking sensors?");
        boolean tb = Reader.readBoolean("Does it have a tow bar?");
        boolean rr = Reader.readBoolean("Does it have a roof rack?");

        Van van = new Van(vanMake, vanModel, vanYear, vanVIN, vanMileage, gearbox, colour, vanCap, wheelbase, sn, ps, tb, rr);

        vehicles.add(van);
        System.out.println("Van created");
    }

    // ----- bus -----

    @Menu(command = "B", description = "Create a Bus", id = 10)
    public void createB() {

        //input for bus
        String busMake = Reader.readLine("Enter Bus Make:");
        String busModel = Reader.readLine("Enter Bus Model:", 1, 10);
        int busYear = Reader.readInt("Enter Bus year:", 2000, 2025);
        int busVIN;
        do {
            busVIN = Reader.readInt("Enter Bus VIN:"); //must be unique
            if (!newVIN(busVIN)) {
                System.out.println("Sorry, VIN already used - please enter a unique VIN:");
            }
        } while (!newVIN(busVIN));
        int busMileage = Reader.readInt("Enter bus mileage:");
        Colour colour = Reader.readEnum("Select colour:", Colour.class);
        Bustype busType = Reader.readEnum("Select bus type:", Bustype.class);
        int busCap;
            do {
                busCap = Reader.readInt("Enter seating capacity:");
                if (busCap > busType.getMaxCapacity()) {
                    System.out.println("Seating capacity too high for a " + busType + ". Please enter seating capacity below the max of: " + busType.getMaxCapacity());
                }
            } while (busCap > busType.getMaxCapacity());
        boolean sn = Reader.readBoolean("Does it have a sat nav?");
        boolean ps = Reader.readBoolean("Does it have parking sensors?");
        boolean ft = Reader.readBoolean("Fuel tank over 200 Litres?");

        Bus bus = new Bus(busMake, busModel, busYear, busVIN, busMileage, colour, busCap, busType, sn, ps, ft);

        vehicles.add(bus);
        System.out.println("Bus created");
    }
}

