import org.junit.Test;

import static org.junit.Assert.*;

public class MyUnitTest {

    @Test
    public void checkOutages() {
        System.out.println("Test: check if outages are being counted");
        Store store = new Store(1);
        CasualCustomer customer = new CasualCustomer();
        store.eggRolls.setInventory(0);
        store.springRolls.setInventory(0);
        store.pastryRolls.setInventory(0);
        store.sausageRolls.setInventory(0);
        store.jellyRolls.setInventory(6);
        int rollArray[] = {1,2,3,4,5};
        int sauceArray[] = {0,0,0,0,0};
        int fillArray[] = {0,0,0,0,0};
        int topArray[] = {0,0,0,0,0};
        store.takeOrder(rollArray, sauceArray, fillArray, topArray, customer);
        assertEquals(store.getTotalOutages(),1);
        System.out.println("Status: Passed");

    }

    @Test
    public void checkInventoryIsRefilled() {
        System.out.println("Test: check if Inventory is refilled");
        Store store = new Store(1);
        store.eggRolls.setInventory(0);
        store.springRolls.setInventory(5);
        store.refillInventory(30);
        assertEquals(store.eggRolls.getInventory(), 30);
        assertEquals(store.springRolls.getInventory(), 5);
        System.out.println("Status: Passed");

    }

    @Test
    public void checkStoreClosedEarly() {
        System.out.println("Test: check if store closed when all inventory is out");
        Store store = new Store(1);
        CasualCustomer customer = new CasualCustomer();
        store.eggRolls.setInventory(0);
        store.springRolls.setInventory(0);
        store.pastryRolls.setInventory(0);
        store.sausageRolls.setInventory(0);
        store.jellyRolls.setInventory(0);
        int rollArray[] = {1,2,3,4,5};
        int sauceArray[] = {0,0,0,0,0};
        int fillArray[] = {0,0,0,0,0};
        int topArray[] = {0,0,0,0,0};
        store.takeOrder(rollArray, sauceArray, fillArray, topArray, customer);
        assertEquals(store.getStoreClosed(), true);
        System.out.println("Status: Passed");

    }

    @Test
    public void checkTotalEggRollOrders() {
        System.out.println("Test: check total eggroll orders");
        Store store = new Store(1);
        CasualCustomer customer = new CasualCustomer();
        store.eggRolls.setInventory(30);
        int rollArray[] = {1,1,1,1,1};
        int sauceArray[] = {0,0,0,0,0};
        int fillArray[] = {0,0,0,0,0};
        int topArray[] = {0,0,0,0,0};
        store.takeOrder(rollArray, sauceArray, fillArray, topArray, customer);
        assertEquals(store.getTotalEggOrders(), 5);
        System.out.println("Status: Passed");

    }
    @Test
    public void checkCustomerOutageOrderIsFullfilled() {
        System.out.println("Test: check customer outage order is correct");
        Store store = new Store(1);
        CasualCustomer customer = new CasualCustomer();
        store.eggRolls.setInventory(0);
        store.springRolls.setInventory(0);
        store.pastryRolls.setInventory(5);
        store.sausageRolls.setInventory(5);
        store.jellyRolls.setInventory(5);
        int rollArray[] = {1,2,3,4,5};
        int sauceArray[] = {0,0,0,0,0};
        int fillArray[] = {0,0,0,0,0};
        int topArray[] = {0,0,0,0,0};
        store.takeOrder(rollArray, sauceArray, fillArray, topArray, customer);
        assertEquals(store.getStoreClosed(), false);
        System.out.println("Status: Passed");

    }
    @Test
    public void checkDailySalesAreAddedToTotal() {
        System.out.println("Test: check if daily sales are added to total sales");
        Store store = new Store(1);
        CasualCustomer customer = new CasualCustomer();
        store.eggRolls.setInventory(2);
        store.springRolls.setInventory(2);
        store.pastryRolls.setInventory(2);
        store.sausageRolls.setInventory(2);
        store.jellyRolls.setInventory(2);
        int rollArray[] = {1,2,3,4,5};
        int sauceArray[] = {0,0,0,0,0};
        int fillArray[] = {0,0,0,0,0};
        int topArray[] = {0,0,0,0,0};
        store.takeOrder(rollArray, sauceArray, fillArray, topArray, customer);
        assertEquals(store.getTotalSales(), 20);
        System.out.println("Status: Passed");

    }

    @Test
    public void checkTotalSpringRollOrders() {
        System.out.println("Test: check total springroll orders");
        Store store = new Store(1);
        CasualCustomer customer = new CasualCustomer();
        store.eggRolls.setInventory(30);
        int rollArray[] = {2,2,2,2,2};
        int sauceArray[] = {0,0,0,0,0};
        int fillArray[] = {0,0,0,0,0};
        int topArray[] = {0,0,0,0,0};
        store.takeOrder(rollArray, sauceArray, fillArray, topArray, customer);
        assertEquals(store.getTotalSpringOrders(), 5);
        System.out.println("Status: Passed");

    }

    @Test
    public void checkCasualCustomerGetsCorrectOrder() {
        System.out.println("Test: check if casual customer gets order correct");
        CasualCustomer customer = new CasualCustomer();
        if(customer.rollArray.length > 0 && customer.rollArray.length <=3 ){
            System.out.println("Status: Passed");
        }else{
            System.out.println("Status: Failed");
        }
    }

    @Test
    public void checkBusinessCustomerGetsCorrectOrder() {
        System.out.println("Test: check if business customer gets order correct");
        BusinessCustomer customer = new BusinessCustomer();
        if(customer.rollArray.length == 10){
            System.out.println("Status: Passed");
        }else{
            System.out.println("Status: Failed");
        }
    }

    @Test
    public void checkCateringCustomerGetsCorrectOrder() {
        System.out.println("Test: check if catering customer gets order correct");
        CateringCustomer customer = new CateringCustomer();
        if(customer.rollArray.length == 15){
            System.out.println("Status: Passed");
        }else{
            System.out.println("Status: Failed");
        }
    }
}
