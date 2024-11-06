package realestate;

public interface realEstateInterface {
    void makeDiscount(int percent);
    int getTotalPrice();
    double averageSqmPerRoom();
    String toString(); // It is superfluous
}