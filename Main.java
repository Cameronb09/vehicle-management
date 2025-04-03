
/*package Vehicle;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Motorbike make:");
        String motorbikeMake = scanner.nextLine();
        System.out.println("Enter Motorbike model:");
        String motorbikeModel = scanner.nextLine();
        System.out.println("Enter Motorbike year:");
        int motorbikeYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Motorbike mileage:");
        int motorbikeMile = scanner.nextInt();
        System.out.println("Enter Motorbike fuel level:");
        int motorbikeFuelLevel = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Motorbike gearbox type (Auto/Manual):");
        Gearbox motorbikeGearbox = Gearbox.valueOf(scanner.nextLine());
        System.out.println("Enter Motorbike colour (black/blue/etc):");
        Colour motorbikeColour = Colour.valueOf(scanner.nextLine());
        System.out.println("Enter vehicle type: Saloon, Estate, Hatchback, SUV");
        Body motorbikeBody = Body.valueOf(scanner.nextLine());

        System.out.println(motorbikeColour);
        System.out.println(motorbikeMake);
        System.out.println(motorbikeModel);
        System.out.println(motorbikeYear);
        System.out.println(motorbikeMile);
        System.out.println(motorbikeFuelLevel);
        System.out.println(motorbikeGearbox);
        System.out.println(motorbikeColour);
        System.out.println(motorbikeBody);
    }
}

 */




// Main class to demonstrate functionality

/*package Vehicle;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Motorbike make:");
        String motorbikeMake = scanner.nextLine();
        System.out.println("Enter Motorbike model:");
        String motorbikeModel = scanner.nextLine();
        System.out.println("Enter Motorbike year:");
        int motorbikeYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Motorbike mileage:");
        int motorbikeMile = scanner.nextInt();
        System.out.println("Enter Motorbike fuel level:");
        int motorbikeFuelLevel = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Motorbike gearbox type (Auto/Manual):");
        Gearbox motorbikeGearbox = Gearbox.valueOf(scanner.nextLine());
        System.out.println("Enter Motorbike colour (black/blue/etc):");
        Colour motorbikeColour = Colour.valueOf(scanner.nextLine());
        System.out.println("Enter vehicle type: Saloon, Estate, Hatchback, SUV");
        Body motorbikeBody = Body.valueOf(scanner.nextLine());

        System.out.println(motorbikeColour);
        System.out.println(motorbikeMake);
        System.out.println(motorbikeModel);
        System.out.println(motorbikeYear);
        System.out.println(motorbikeMile);
        System.out.println(motorbikeFuelLevel);
        System.out.println(motorbikeGearbox);
        System.out.println(motorbikeColour);
        System.out.println(motorbikeBody);
    }
}

 */



import java.util.Scanner;
import devtools.util.Reader;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input for car
        String carMake = Reader.readLine("Enter Car Make:");
        String carModel = Reader.readLine("Enter Car Model:", 1, 10);
        int carYear = Reader.readInt("Enter Car year:" , 2000, 2025);
        int carVIN = Reader.readInt("Enter Car VIN:");
        Gearbox gearbox = Reader.readEnum("Select gearbox type:", Gearbox.class);
        System.out.println("You selected: " );
        Colour colour = Reader.readEnum("Select colour:", Colour.class);
        System.out.println("You selected " );
        Body carBody = Reader.readEnum("Select body type: ", Body.class);
        System.out.println("You selected: "+ carBody);

     //   System.out.print("Body (SALOON/ESTATE/HATCHBACK/SUV): ");
       // Body carBody = Body.valueOf(scanner.next().toUpperCase());
        //scanner.nextLine(); // Consume newline

        Car car = new Car(carMake, carModel, carYear, carVIN, gearbox, colour, carBody);

        System.out.print("Add options (sat nav, parking sensors, tow bar, roof rack, all-wheel drivetrain, third row seat) ");
        String[] carOptions = scanner.nextLine().split(",");
        for (String option : carOptions) {
            car.addOption(option.trim());
        }

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
        scanner.nextLine(); // Consume newline

        Motorbike motorbike = new Motorbike(bikeMake, bikeModel, bikeYear, bikeVIN, bikeGearbox, bikeColour);

        System.out.print("Does it have a luggage box (true/false)? ");
        boolean luggageBox = scanner.nextBoolean();
        motorbike.setLuggageBox(luggageBox);

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

        scanner.close();
    }
}
