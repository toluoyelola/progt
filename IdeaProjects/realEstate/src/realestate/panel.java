package realestate;

public class panel extends realEstate {
    // New fields
    private int floor;
    private boolean isInsulated;

    // Constructor with all fields
    public panel(String city, double price, int sqm,
                 double numberOfRooms, Genre genre,
                 int floor, boolean isInsulated) {
        super(city, price, sqm, numberOfRooms, genre);  // Call parent constructor
        this.floor = floor;
        this.isInsulated = isInsulated;
    }

    // Empty constructor
    public panel() {
        super();  // Call parent's empty constructor
    }

    @Override
    public int getTotalPrice() {
        double totalPrice = super.getTotalPrice();  // Get base price from parent

        // Apply floor modifier
        if (floor >= 0 && floor <= 2) {
            totalPrice *= 1.05;  // +5% for floors 0-2
        } else if (floor == 10) {
            totalPrice *= 0.95;  // -5% for 10th floor
        }

        // Apply insulation modifier
        if (isInsulated) {
            totalPrice *= 1.05;  // +5% if insulated
        }

        return (int) Math.round(totalPrice);
    }

    // Override toString to include modified information
    @Override
    public String toString() {
        return "Panel Apartment in " + city +
                " (" + genre + ")" +
                "\nPrice per sqm: " + price +
                "\nArea: " + sqm + " sqm" +
                "\nNumber of rooms: " + numberOfRooms +
                "\nFloor: " + floor +
                "\nInsulated: " + (isInsulated ? "Yes" : "No") +
                "\nTotal price: " + getTotalPrice() +
                "\nAverage sqm per room: " + averageSqmPerRoom();
    }

    // PanelInterface method
    public boolean hasSameAmount(realEstate other) {
        return this.getTotalPrice() == other.getTotalPrice();
    }

    public int roomprice() {
        return (int) (price * sqm / numberOfRooms);
    }
}