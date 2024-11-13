package realestate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.DisplayName;




package realestate;
public class RealEstateTest {
    private RealEstate underTest;
    private RealEstate compareProperty;

    @BeforeEach
    void setup() {
        underTest = new RealEstate("Nyíregyháza", 500000.0, 40, 2, Genre.CONDOMINIUM);
    }

    @Test
    @DisplayName("Constructor should initialize all fields correctly")
    void testConstructorInitialization() {
        assertEquals("Nyíregyháza", underTest.getLocation());
        assertEquals(500000.0, underTest.getPrice());
        assertEquals(40, underTest.getSize());
        assertEquals(2, underTest.getRooms());
        assertEquals(Genre.CONDOMINIUM, underTest.getGenre());
    }

    @Test
    @DisplayName("Price per square meter calculation should be correct")
    void testPricePerSquareMeter() {
        double expected = 500000.0 / 40; // price / size
        assertEquals(expected, underTest.getPricePerSquareMeter());
    }

    @Test
    @DisplayName("Negative discount should not change the price")
    void testMakeDiscountWithNegativePercent() {
        double originalPrice = underTest.getPrice();
        underTest.makeDiscount(-10);
        assertEquals(originalPrice, underTest.getPrice());
    }

    @Test
    @DisplayName("Properties with different attributes should not be equal")
    void testNotEquals() {
        compareProperty = new RealEstate("Budapest", 600000.0, 45, 3, Genre.CONDOMINIUM);
        assertNotEquals(underTest, compareProperty);
    }

}