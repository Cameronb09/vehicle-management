
public class Motorbike extends Vehicle {

    public boolean luggageBox;
    public Motorbike(String make, String model, int year, int VIN, Gearbox gearbox, Colour colour) {
        super(make, model, year, VIN, gearbox, colour, null);
    }

// add luggage box
public void setLuggageBox(boolean luggageBox){
        this.luggageBox = luggageBox;
}

public boolean hasLuggageBox() {return luggageBox;}
}
