
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
        Application.start(Main.class);
    }

    @Menu(command = "C", description = "Create vehicle", id = 0,
            subMenuIDs = {1, 2})
    @Menu(command = "C", description = "Create a Car", id = 1)
    public void createC() {

        //public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);

        //input for car
        String carMake = Reader.readLine("Enter Car Make:");
        String carModel = Reader.readLine("Enter Car Model:", 1, 10);
        int carYear = Reader.readInt("Enter Car year:", 2000, 2025);
        int carVIN = Reader.readInt("Enter Car VIN:"); //must be unique
        int carMileage = Reader.readInt("Enter car mileage:");
        Gearbox gearbox = Reader.readEnum("Select gearbox type:", Gearbox.class);
        System.out.println("You selected: ");
        Colour colour = Reader.readEnum("Select colour:", Colour.class);
        System.out.println("You selected ");
        Body carBody = Reader.readEnum("Select body type: ", Body.class);
        System.out.println("You selected: " + carBody);
        boolean sn = Reader.readBoolean("Does it have a sat nav?");
        boolean ps = Reader.readBoolean("Does it have parking sensors?");
        boolean tb = Reader.readBoolean("Does it have a tow bar?");
        boolean rr = Reader.readBoolean("Does it have a roof rack?");
        boolean aw = Reader.readBoolean("Does it have all wheel drive?"); //SUV only
        boolean tr = Reader.readBoolean("Does it have third row seats?"); // Estates only

        Car car = new Car(carMake, carModel, carYear, carVIN, carMileage, gearbox, colour, carBody, sn, ps, tb, rr, aw, tr);


        vehicles.add(car);
        System.out.println("Car created");
    }

    @Menu(command = "M", description = "Create Motorbike", id = 2)
    public void createM() {
        //input for motorbike
        System.out.println("\nEnter details for Motorbike:");
        String bikeMake = Reader.readLine("Enter motorbike make: ");
        String bikeModel = Reader.readLine("Enter motorbike model: ");
        int bikeYear = Reader.readInt("Enter motorbike year: ", 2000, 2025);
        int bikeVIN = Reader.readInt("Enter motorbike vin: "); //must be unique
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

    @Menu(command = "L", description = "View a list of all cars and motorbikes", id = 3)
    public void listVehicles() {
        Collections.sort(vehicles);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }


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
}

