package lt.techin.philatelist.test;


import lt.techin.philatelist.Philatelist;
import lt.techin.philatelist.PhilatelistBaseTest;
import lt.techin.philatelist.model.PhilatelistImplementation;

public class PhilatelistTest extends PhilatelistBaseTest {

    @Override
    protected Philatelist getPhilatelist() {
        return new PhilatelistImplementation();
    }
}
