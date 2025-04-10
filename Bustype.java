public enum Bustype {
    SINGLE_DECK(40), DOUBLE_DECK (80), COACH (60);

    //to assign capacity
    private final int maxCapacity;

    Bustype( int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    //to hide underscores
    @Override
    public String toString() {
        switch (this) {
            case SINGLE_DECK: return "Single Deck";
            case DOUBLE_DECK: return "Double Deck";
            case COACH: return "Coach";
            default: throw new IllegalArgumentException();
        }
    }
}
