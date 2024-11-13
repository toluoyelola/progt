package realestate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

public class RealEstateApp{

    public static void generateOutput(RealEstateAgent agent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("outputRealEstate.txt"))) {

            double avgPricePerSqm = getAveragePricePerSqm(agent.stock);
            writer.write("The average square meter price of real estate: " + avgPricePerSqm + "\n");
            System.out.println("The average square meter price of real estate: " + avgPricePerSqm);


            RealEstate cheapestProperty = getCheapestProperty(agent.stock);
            writer.write("The price of the cheapest property: " + cheapestProperty.price + "\n");
            System.out.println("The price of the cheapest property: " + cheapestProperty.price);



            RealEstate mostExpensiveProperty = getMostExpensiveProperty(agent.stock);
            double avgSqmPerRoomMostExpensive = mostExpensiveProperty.averageSqmPerRoom();
            writer.write("The average square meter value per room of the most expensive apartment: " + avgSqmPerRoomMostExpensive + "\n");
            System.out.println("The average square meter value per room of the most expensive apartment: " + avgSqmPerRoomMostExpensive);


            int totalPrice = getTotalPrice(agent.stock);
            writer.write("The total price of the properties: " + totalPrice + "\n");
            System.out.println("The total price of the properties: " + totalPrice);


            TreeSet<RealEstate> condominiumsUnderAvg = getCondominiumsUnderAverage(agent.stock);
            writer.write("List of condominium properties whose total price does not exceed the average price:\n");
            System.out.println("List of condominium properties whose total price does not exceed the average price:");
            for (RealEstate estate : condominiumsUnderAvg) {
                writer.write(estate.toString() + "\n");
                System.out.println(estate.toString());
            }


            writer.write("The average square meter price of real estate: " + avgPricePerSqm + "\n");
            System.out.println("The average square meter price of real estate: " + avgPricePerSqm);


            writer.write("The total price of the properties: " + totalPrice + "\n");
            System.out.println("The total price of the properties: " + totalPrice);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static double getAveragePricePerSqm(TreeSet<RealEstate> properties) {
        double totalPrice = 0;
        int totalSqm = 0;
        for (RealEstate estate : properties) {
            totalPrice += estate.price;
            totalSqm += estate.sqm;
        }
        return totalPrice / totalSqm;
    }

    private static RealEstate getCheapestProperty(TreeSet<RealEstate> properties) {
        return properties.stream()
                .min(RealEstate::compareTo)
                .orElse(null);
    }

    private static RealEstate getMostExpensiveProperty(TreeSet<RealEstate> properties) {
        return properties.stream()
                .max(RealEstate::compareTo)
                .orElse(null);
    }

    private static int getTotalPrice(TreeSet<RealEstate> properties) {
        return properties.stream()
                .mapToInt(RealEstate::getTotalPrice)
                .sum();
    }

    private static TreeSet<RealEstate> getCondominiumsUnderAverage(TreeSet<RealEstate> properties) {
        double avgPrice = getAveragePricePerSqm(properties);
        TreeSet<RealEstate> condominiumsUnderAvg = new TreeSet<>();
        properties.stream()
                .filter(p -> p.genre == Genre.CONDOMINIUM && p.getTotalPrice() <= avgPrice)
                .forEach(condominiumsUnderAvg::add);
        return condominiumsUnderAvg;
    }
}