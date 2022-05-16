package put.io.testing.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FailureOrErrorTest {

    public int add(int x, int y) {
        return x + y;
    }

    public int addPositiveNumbers(int x, int y) throws IllegalArgumentException {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("The arguments must be positive");
        } else {
            return add(x, y);
        }
    }

    @Test
    @DisplayName("42 + 28")
    void test1(){
        assertEquals(71, addPositiveNumbers(42,28));
    }

    @Test
    @DisplayName("42 + (-28)")
    void test2(){
        assertEquals(15, addPositiveNumbers(42, -28));
    }

    @Test
    void test3() throws Exception {
        try{
            assertEquals(21, addPositiveNumbers(10,10));
        }catch(Exception e){
            throw new Exception("Execution unsuccessful", e);
        }
    }
}