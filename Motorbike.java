public class Motorbike extends Vehicle {

    public boolean luggageBox;
    public Motorbike(String make, String model, int year, int VIN, int mileage, Gearbox gearbox, Colour colour, boolean lb) {
        super(make, model, year, VIN, mileage, gearbox, colour, null);
        this.luggageBox = lb;
    }

// add luggage box
public void setLuggageBox(boolean luggageBox){
        this.luggageBox = luggageBox;
}

public boolean hasLuggageBox() {return luggageBox;}

    @Override
    public String toString() {
        return super.toString() + '\n' +
        "Luggage box?: " + luggageBox + '\n';
    }
}
