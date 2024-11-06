package realestate;

public class realEstate implements realEstateInterface {

        String city;
        double price;
        int sqm;
        double numberOfRooms;
        Genre genre;



        public realEstate(String city, double price, int sqm, double numberOfRooms, Genre genre){
            this.city = city;
            this.price = price;
            this.sqm = sqm;
            this.numberOfRooms = numberOfRooms;
            this.genre = genre;
        }

    public realEstate(){

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
}


