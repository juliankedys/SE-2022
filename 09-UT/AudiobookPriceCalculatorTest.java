package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    Audiobook audiobook;

    @BeforeEach
    void setUp(){
        audiobook = new Audiobook("Software Engineering for Dummies", 42.0);
    }

    @Test
    @DisplayName("Is subscriber")
    void calculate1(){
        Customer customer = new Customer("Chinese Elon Musku", Customer.LoyaltyLevel.STANDARD, true);
        AudiobookPriceCalculator calculator = new AudiobookPriceCalculator();
        assertEquals(0.0, calculator.calculate(customer, audiobook));
    }

    @Test
    @DisplayName("Premium")
    void calculate2(){
        Customer customer = new Customer("Jeff B.", Customer.LoyaltyLevel.PREMIUM, false);
        AudiobookPriceCalculator calculator = new AudiobookPriceCalculator();
        assertEquals(0.75 * audiobook.getStartingPrice(), calculator.calculate(customer, audiobook));
    }

    @Test
    @DisplayName("Premium+")
    void calculate3(){
        Customer customer = new Customer("Gwen Stefani", Customer.LoyaltyLevel.PREMIUMP, false);
        AudiobookPriceCalculator calculator = new AudiobookPriceCalculator();
        assertEquals(0.5 * audiobook.getStartingPrice(), calculator.calculate(customer, audiobook));
    }

    @Test
    @DisplayName("Standard")
    void calculate4(){
        Customer customer = new Customer("John Anthony Gillis", Customer.LoyaltyLevel.STANDARD, false);
        AudiobookPriceCalculator calculator = new AudiobookPriceCalculator();
        assertEquals(audiobook.getStartingPrice(), calculator.calculate(customer, audiobook));
    }


}