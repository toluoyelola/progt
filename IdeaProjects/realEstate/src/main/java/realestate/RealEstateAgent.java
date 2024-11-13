package realestate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class RealEstateAgent {
    public TreeSet<RealEstate> stock = new TreeSet<>();// need to compare method cause of treeset

    RealEstateAgent() {
        loadPropertiesFromFile();
    }

    private void loadPropertiesFromFile() {
        try (Scanner scanner = new Scanner(new File("realestates.txt"))) {
            while (scanner.hasNextLine()) {
                processLine(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("No such file.");
        }
    }

    private void processLine(String line) {
        String[] pieces = line.split("#");

        if (!isValidPieceLength(pieces)) {
            System.err.println("There is input problem: no six or eight parts in a row");
            return;
        }

        if (pieces.length == 6 && pieces[0].equals("REALESTATE")) {
            processRealEstate(pieces);
        } else if (pieces.length == 8 && pieces[0].equals("PANEL")) {
            processPanel(pieces);
        } else {
            System.err.println(pieces.length == 6 ?
                    "Six pieces but no REALESTATE start" :
                    "Eight pieces but no PANEL start");
        }
    }

    private boolean isValidPieceLength(String[] pieces) {
        return pieces.length == 6 || pieces.length == 8;
    }

    private void processRealEstate(String[] pieces) {
        Genre genre = parseGenre(pieces[5]);
        stock.add(new RealEstate(
                pieces[1],
                Double.parseDouble(pieces[2]),
                Integer.parseInt(pieces[3]),
                Double.parseDouble(pieces[4]),
                genre
        ));
    }

    private void processPanel(String[] pieces) {
        Genre genre = parseGenre(pieces[5]);
        boolean isInsulated = pieces[6].equals("yes");

        stock.add(new panel
                (pieces[1],
                Double.parseDouble(pieces[2]),
                Integer.parseInt(pieces[3]),
                Double.parseDouble(pieces[4]),
                genre,
                Integer.parseInt(pieces[6]),
                isInsulated
        ));
    }

    private Genre parseGenre(String genreStr) {
        return switch (genreStr) {
            case "CONDOMINIUM" -> Genre.CONDOMINIUM;
            case "FARM" -> Genre.FARM;
            case "FAMILYHOUSE" -> Genre.FAMILYHOUSE;
            default -> Genre.FARM;
        };
    }
}