package lt.techin;

import lt.techin.classes.CashRegister;
import lt.techin.enum_interface.Coins;
import lt.techin.exceptions.NotEnoughChangeExceptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CashRegisterTest {
    CashRegister cashRegister;

    @BeforeEach
    void Start() {
        cashRegister = new CashRegister();
    }

    @Test
    @DisplayName("Test addCoin viability")
    void testAddCoin() {
    double amount = 0.50;
    Coins expectedCoin = Coins.FIFTY_CENT;
    cashRegister.addCoin(amount);
    assertTrue(cashRegister.getCoins().get(expectedCoin).equals(30+1));
    assertTrue(cashRegister.getCurrentTransactionCoins().get(expectedCoin).equals(1));
    }


    @Test
    @DisplayName("Adding invalid Coin")
    void testAddInvalid() {
        double amount = 2.20;
        assertThrows(IllegalArgumentException.class, () -> {
            cashRegister.addCoin(amount);
        });

    }

    @Test
    @DisplayName("Adding Multiple Coins")
    void testAddMultiple() {
        double amount50 = 0.50,amount502 =0.50, amount503 = 0.50, amount504 = 0.50;
        double amount100 = 1.00,amount1002 = 1.00, amount1003 = 1.00;

        Coins expectedCoin = Coins.FIFTY_CENT;
        Coins expectedCoin2 = Coins.POUND;

        List<Double> amounts = Arrays.asList(amount50,amount502,amount503,amount504,amount100,amount1002,amount1003);
        cashRegister.addAllCoins(amounts);

        assertTrue(cashRegister.getCoins().get(expectedCoin).equals(30+4));
        assertTrue(cashRegister.getCurrentTransactionCoins().get(expectedCoin).equals(4));
        assertTrue(cashRegister.getCoins().get(expectedCoin2).equals(15+3));
        assertTrue(cashRegister.getCurrentTransactionCoins().get(expectedCoin2).equals(3));

}

    @Test
    @DisplayName("CalculatingChange")
    void testCalcChange() {
    double changeAmount = 6.0, changeAmount2 = 5.5;

        HashMap<Coins,Integer> change = cashRegister.calcChange(changeAmount);

        assertEquals(3,change.get(Coins.TWO_POUND));

        HashMap<Coins,Integer> change2 = cashRegister.calcChange(changeAmount2);

        assertEquals(2,change2.get(Coins.TWO_POUND));
        assertEquals(1,change2.get(Coins.POUND));
        assertEquals(1,change2.get(Coins.FIFTY_CENT));
        assertNotEquals(2,change2.get(Coins.TEN_CENT));
    }

    @Test
    @DisplayName("Can't get exact change")
    void testCantGetChange(){

        double changeAmount = 5.99;
        double impossibleAmount = 99999;

        assertThrows(NotEnoughChangeExceptions.class, () -> {
            cashRegister.calcChange(changeAmount);
        });
        assertThrows(NotEnoughChangeExceptions.class, () -> {
            cashRegister.calcChange(impossibleAmount);
        });

    }
}
