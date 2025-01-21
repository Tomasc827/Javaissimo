package lt.techin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {
    Calc calc;

    @BeforeEach
    void setup() {
        calc = new Calc();
    }

    @Test
    void testSum(){

        int actual = calc.sum(2,2);
        int expected = 4;
        assertEquals(expected,actual);
        assertEquals(5,calc.sum(2,3), "2 + 3 should be 5");
    }

     // @DisplayName() sets the name of the test

}
