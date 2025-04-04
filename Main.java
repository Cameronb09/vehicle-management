
import java.util.*;

import devtools.io.Data;
import devtools.ui.Application;
import devtools.ui.Menu;
import devtools.util.CollectionUtils;
import devtools.util.Reader;
import devtools.util.Sequence;

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
        Scanner scanner = new Scanner(System.in);

        //input for car
        String carMake = Reader.readLine("Enter Car Make:");
        String carModel = Reader.readLine("Enter Car Model:", 1, 10);
        int carYear = Reader.readInt("Enter Car year:", 2000, 2025);
        int carVIN = Reader.readInt("Enter Car VIN:");
        Gearbox gearbox = Reader.readEnum("Select gearbox type:", Gearbox.class);
        System.out.println("You selected: ");
        Colour colour = Reader.readEnum("Select colour:", Colour.class);
        System.out.println("You selected ");
        Body carBody = Reader.readEnum("Select body type: ", Body.class);
        System.out.println("You selected: " + carBody);


        Car car = new Car(carMake, carModel, carYear, carVIN, gearbox, colour, carBody);

        System.out.print("Add options (sat nav, parking sensors, tow bar, roof rack, all-wheel drivetrain, third row seat) ");
        String[] carOptions = scanner.nextLine().split(",");
        for (String option : carOptions) {
            car.addOption(option.trim());
        }
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
        int bikeVIN = Reader.readInt("Enter motorbike vin: ");
        Gearbox bikeGearbox = Reader.readEnum("Select gearbox type: ", Gearbox.class);
        System.out.println("You selected " + bikeGearbox);
        Colour bikeColour = Reader.readEnum("Select colour:", Colour.class);
        System.out.println("You selected " + bikeColour);
        boolean lb = Reader.readBoolean("Does it have a luggage box?");
        Motorbike motorbike = new Motorbike(bikeMake, bikeModel, bikeYear, bikeVIN, bikeGearbox, bikeColour, lb);
        vehicles.add(motorbike);
        System.out.println("Motorbike created");

    }

    @Menu(command = "L", description = "View a list of all cars and motorbikes", id=3)
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
    /*
        //print car details
        System.out.println("\nCar Details:");
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Body Type: " + car.getBodyType());
        System.out.println("Sat Nav: " + car.hasSatNav());
        System.out.println("Parking Sensors: " + car.hasParkingSensor());
        System.out.println("Tow Bar: " + car.hasTowBar());
        System.out.println("Roof Rack: " + car.hasRoofRack());
        System.out.println("All Wheel Drivetrain: " + car.hasAllWheelDrivetrain());
        System.out.println("Third Row Seat: " + car.hasThirdRowSeat());

        //print motorbike details
        System.out.println("\nMotorbike Details:");
        System.out.println("Make: " + motorbike.getMake());
        System.out.println("Model: " + motorbike.getModel());
        System.out.println("Year: " + motorbike.getYear());
        System.out.println("Luggage Box: " + motorbike.hasLuggageBox());

        scanner.close(); */
    }

