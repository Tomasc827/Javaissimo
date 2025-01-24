package lt.techin;

import lt.itakademija.exam.IdGenerator;
import lt.itakademija.exam.Warehouse;
import lt.itakademija.exam.test.BaseTest;

public class WarehouseTest extends BaseTest {
    @Override
    protected Warehouse createWarehouse(IdGenerator idGenerator, IdGenerator idGenerator1, int totalSpace) {
        return new TexasBBQWarehouse(idGenerator,idGenerator,totalSpace);
    }
}
