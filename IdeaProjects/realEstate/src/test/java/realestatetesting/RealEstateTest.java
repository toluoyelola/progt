package realestatetesting;

import org.junit.jupiter.api.Test;
import realestate.Genre;
import realestate.RealEstate;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class RealEstateTest {
    @Test
    void testMakeDiscount() {
        RealEstate property = new RealEstate("Budapest", 100000, 50, 2, Genre.CONDOMINIUM);
        property.makeDiscount(10);
        assertEquals(90000, property.price, 0.01);
    }

    @Test
    void testGetTotalPrice() {
        RealEstate property = new RealEstate("Budapest", 100000, 50, 2, Genre.CONDOMINIUM);
        assertEquals(65000, property.getTotalPrice());

        property = new RealEstate("Debrecen", 100000, 50, 2, Genre.CONDOMINIUM);
        assertEquals(60000, property.getTotalPrice());

        property = new RealEstate("Nyíregyháza", 100000, 50, 2, Genre.CONDOMINIUM);
        assertEquals(57500, property.getTotalPrice());

        property = new RealEstate("Eger", 100000, 50, 2, Genre.CONDOMINIUM);
        assertEquals(50000, property.getTotalPrice());
    }

    @Test
    void testAverageSqmPerRoom() {
        RealEstate property = new RealEstate("Budapest", 100000, 80, 4, Genre.FAMILYHOUSE);
        assertEquals(20, property.averageSqmPerRoom(), 0.01);
    }

    @Test
    void testCompareTo() {
        RealEstate prop1 = new RealEstate("Budapest", 100000, 50, 2, Genre.CONDOMINIUM);
        RealEstate prop2 = new RealEstate("Budapest", 120000, 60, 3, Genre.FAMILYHOUSE);
        RealEstate prop3 = new RealEstate("Budapest", 100000, 50, 2, Genre.CONDOMINIUM);

        assertTrue(prop1.compareTo(prop2) < 0);
        assertTrue(prop2.compareTo(prop1) > 0);
        assertEquals(0, prop1.compareTo(prop3));
    }
}
