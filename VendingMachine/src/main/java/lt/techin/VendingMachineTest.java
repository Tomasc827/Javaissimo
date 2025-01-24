package lt.techin;

import lt.vtvpmc.vending.machine.BaseVendingMachineTest;
import lt.vtvpmc.vending.machine.VendingMachine;

public class VendingMachineTest extends BaseVendingMachineTest {

    @Override
    protected VendingMachine getNewVendingMachine() {
        return new GachaVendingMachine();
    }
}
