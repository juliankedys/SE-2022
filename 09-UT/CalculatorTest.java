package put.io.testing.junit;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertThrows;

//import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    //private Calculator objCalcUnderTest = new Calculator();
    private Calculator objCalcUnderTest;

    @BeforeEach
    public void setUp() {
//Arrange
        objCalcUnderTest = new Calculator();
    }

    @Test
    public void testAdd() {
        int a = 15; int b = 20;
        int expectedResult = 35;
        int result = objCalcUnderTest.add(a, b);
        Assert.assertEquals(expectedResult, result);

        int c = 15; int d = -15;
        int expectedResult2 = 0;
        int result2 = objCalcUnderTest.add(c, d);
        Assert.assertEquals(expectedResult2, result2);
    }

    @Test
    public void testMultiply() {
        int a = 10; int b = 25;
        int expectedResult = 250;
        int result = objCalcUnderTest.multiply(a, b);
        Assert.assertEquals(expectedResult, result);

        int c = -12; int d = -10;
        int expectedResult2 = 120;
        int result2 = objCalcUnderTest.multiply(c, d);
        Assert.assertEquals(expectedResult2, result2);

    }


    @Test
            //(expected = IllegalArgumentException.class)
    public void testAddPositiveNumbers() {
        //int a = -15; int b = 10;
        //objCalcUnderTest.addPositiveNumbers(a, b);
        assertThrows(IllegalArgumentException.class, () -> objCalcUnderTest.addPositiveNumbers(-10,10));
    }


}

//Question 3.1: Yes, the tests would stop working



