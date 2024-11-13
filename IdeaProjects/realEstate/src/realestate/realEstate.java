package realestate;

public class RealEstate implements realEstateInterface, Comparable<RealEstate> {// implement comparable

        String city;
        double price;
        int sqm;
        double numberOfRooms;
        Genre genre;



        public RealEstate(String city, double price, int sqm, double numberOfRooms, Genre genre){
            this.city = city;
            this.price = price;
            this.sqm = sqm;
            this.numberOfRooms = numberOfRooms;
            this.genre = genre;
        }

    public RealEstate(){

    }

    @Override
    public void makeDiscount(int percent) {
        if (percent > 0 && percent <= 100) {
            price -= price * percent / 100.0;
        }
    }

    @Override
    public int getTotalPrice() {
        double ratio = switch (city) {
            case "Budapest" -> 1.3;
            case "Debrecen" -> 1.2;
            case "Nyíregyháza" -> 1.15;
            default -> 1.0;
        };
        return (int) Math.round(sqm * price * ratio);
    }

    @Override
    public double averageSqmPerRoom() {
        return sqm / numberOfRooms;
    }

    @Override
    public String toString() {
        return "Property in " + city +
                " (" + genre + ")" +
                "\nPrice per sqm: " + price +
                "\nArea: " + sqm + " sqm" +
                "\nNumber of rooms: " + numberOfRooms +
                "\nTotal price: " + getTotalPrice() +
                "\nAverage sqm per room: " + averageSqmPerRoom();

    }

    @Override
    public int compareTo(RealEstate o) {
        if (price < o.price) return -1;
        else if (price > o.price) return 1;
        else if (sqm < o.sqm) return -1;
        else if (sqm > o.sqm) return 1;
        else if (numberOfRooms < o.numberOfRooms) return -1;
        else if (numberOfRooms > o.numberOfRooms) return 1;
        else return 0;
    }
}


