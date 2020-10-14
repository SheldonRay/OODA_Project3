import org.junit.Test;

import jdk.internal.jshell.tool.resources.version;

import static org.junit.Assert.*;

public class MyUnitTest {

    @Test
    public void checkDaySalesAreReset() {


    }

    @Test
    public void checkInventoryIsRefilled() {
        Store store = new Store(1);
        store.eggRolls.setInventory(0);
        store.springRolls.setInventory(5);
        store.refillInventory();
        assertEquals(store.eggRolls.getInventory(), 30);
        assertEquals(store.springRolls.getInventory(), 5);
    }

    @Test
    public void checkStoreClosedEarly() {


    }

    @Test
    public void checkCustomerOrderIsFullfilled() {


    }
    @Test
    public void checkCustomerOutageOrderIsFullfilled() {


    }
    @Test
    public void checkDailySalesAreAddedToTotal() {


    }

    @Test
    public void checkExtrasAreAdded() {


    }

    @Test
    public void checkCasualCustomerGetsCorrectOrder() {


    }

    @Test
    public void checkBusinessCustomerGetsCorrectOrder() {


    }

    @Test
    public void checkCateringCustomerGetsCorrectOrder() {


    }
}
