package lt.techin;

import lt.techin.classes.Product;
import lt.techin.exceptions.NameOrIdTooShortException;
import lt.techin.exceptions.UpperThresholdException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    private void assertThrowsWithMessage(Class<? extends Throwable> exceptionClass, String expectedMessage, Executable executable) {
        Throwable exception = assertThrows(exceptionClass, executable);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    @DisplayName("Test Name")
    void testProductName() {
        String errorName = "Name cannot be null, empty or above 255 characters";
        String errorShort = "Name or id needs to be at least 3 symbols long";

       assertThrowsWithMessage(IllegalArgumentException.class,
              errorName, () -> {
           new Product("a".repeat(256),5,"product");
               });
       assertThrowsWithMessage(IllegalArgumentException.class,
               errorName, () -> {
           new Product("",5,"product");
               });
        assertThrowsWithMessage(IllegalArgumentException.class,
                errorName, () -> {
            new Product(null,5,"product");
                });
        assertThrowsWithMessage(NameOrIdTooShortException.class,
                errorShort, () -> {
            new Product("aa",5,"product");
                });
    }
    @Test
    @DisplayName("Test Price")
    void testPrice() {
        assertThrowsWithMessage(UpperThresholdException.class,
            "The limit for the supermarket price is 10000", () -> {
                new Product("aaaa",10001,"aaaa");

        });
        assertThrowsWithMessage(IllegalArgumentException.class,
                "Price cannot be negative", () -> {
            new Product("aaaa",-1,"aaaa");
                }
                );


    }


}
