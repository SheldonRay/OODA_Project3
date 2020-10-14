import org.junit.Test;

import jdk.internal.jshell.tool.resources.version;

import static org.junit.Assert.*;

public class MyUnitTest {

    @Test
    public void checkOutages() {
        System.out.println("Test: check if outages are being counted");
        Store store = new Store(1);
        CasualCustomer customer = new CasualCustomer(1);
        store.eggRolls.setInventory(0);
        store.springRolls.setInventory(0);
        store.pastryRolls.setInventory(0);
        store.sausageRolls.setInventory(0);
        store.jellyRolls.setInventory(6);
        store.takeOrder([1,2,3,4,5], [0,0,0,0,0], [0,0,0,0,0], [0,0,0,0,0], customer);
        assertEqual(store.getTotalOutages(), 1);
        System.out.println("Status: Passed");

    }

    @Test
    public void checkInventoryIsRefilled() {
        System.out.println("Test: check if Inventory is refilled");
        Store store = new Store(1);
        store.eggRolls.setInventory(0);
        store.springRolls.setInventory(5);
        store.refillInventory();
        assertEquals(store.eggRolls.getInventory(), 30);
        assertEquals(store.springRolls.getInventory(), 5);
        System.out.println("Status: Passed");

    }

    @Test
    public void checkStoreClosedEarly() {
        System.out.println("Test: check if store closed when all inventory is out");
        Store store = new Store(1);
        CasualCustomer customer = new CasualCustomer(1);
        store.eggRolls.setInventory(0);
        store.springRolls.setInventory(0);
        store.pastryRolls.setInventory(0);
        store.sausageRolls.setInventory(0);
        store.jellyRolls.setInventory(0);
        store.takeOrder([1,2,3,4,5], [0,0,0,0,0], [0,0,0,0,0], [0,0,0,0,0], customer);
        assertEqual(store.getStoreClosed(), True);
        System.out.println("Status: Passed");

    }

    @Test
    public void checkTotalEggRollOrders() {
        System.out.println("Test: check total eggroll orders");
        Store store = new Store(1);
        CasualCustomer customer = new CasualCustomer(1);
        store.eggRolls.setInventory(30);
        store.takeOrder([1,1,1,1,1], [0,0,0,0,0], [0,0,0,0,0], [0,0,0,0,0], customer);
        assertEqual(store.eggRolls.getTotalEggOrders(), 5);
        System.out.println("Status: Passed");

    }
    @Test
    public void checkCustomerOutageOrderIsFullfilled() {
        System.out.println("Test: check customer outage order is correct");
        Store store = new Store(1);
        CasualCustomer customer = new CasualCustomer(1);
        store.eggRolls.setInventory(0);
        store.springRolls.setInventory(0);
        store.pastryRolls.setInventory(5);
        store.sausageRolls.setInventory(5);
        store.jellyRolls.setInventory(5);
        store.takeOrder([1,2,3,4,5], [0,0,0,0,0], [0,0,0,0,0], [0,0,0,0,0], customer);
        assertEqual(store.getStoreClosed(), False);
        System.out.println("Status: Passed");

    }
    @Test
    public void checkDailySalesAreAddedToTotal() {
        System.out.println("Test: check if daily sales are added to total sales");
        Store store = new Store(1);
        CasualCustomer customer = new CasualCustomer(1);
        assertEqual(store.getTotalSales(), 0);
        store.eggRolls.setInventory(2);
        store.springRolls.setInventory(2);
        store.pastryRolls.setInventory(2);
        store.sausageRolls.setInventory(2);
        store.jellyRolls.setInventory(2);
        store.takeOrder([1,2,3,4,5], [0,0,0,0,0], [0,0,0,0,0], [0,0,0,0,0], customer);
        assertEqual(store.getTotalSales(), 20);
        System.out.println("Status: Passed");

    }

    @Test
    public void checkExtrasAreAdded() {
        System.out.println("Test: check if extras are added");
        Store store = new Store(1);
        CasualCustomer customer = new CasualCustomer(1);
        store.eggRolls.setInventory(2);
        store.springRolls.setInventory(2);
        store.pastryRolls.setInventory(2);
        store.sausageRolls.setInventory(2);
        store.jellyRolls.setInventory(2);
        store.takeOrder([1,2,3,4,5], [1,0,0,1,0], [0,1,0,0,0], [0,1,0,0,0], customer);
        assertEqual(store.getTotalSales(), 24);
        System.out.println("Status: Passed");

    }

    @Test
    public void checkCasualCustomerGetsCorrectOrder() {
        System.out.println("Test: check if casual customer gets order correct");
        CasualCustomer customer = new CasualCustomer(1);
        if(customer.arrayList.length > 0 && customer.arrayList.length <=3 ){
            System.out.println("Status: Passed");
        }else{
            System.out.println("Status: Failed");
        }
    }

    @Test
    public void checkBusinessCustomerGetsCorrectOrder() {
        System.out.println("Test: check if business customer gets order correct");
        BusinessCustomer customer = new BusinessCustomer(1);
        if(customer.arrayList.length == 10){
            System.out.println("Status: Passed");
        }else{
            System.out.println("Status: Failed");
        }
    }

    @Test
    public void checkCateringCustomerGetsCorrectOrder() {
        System.out.println("Test: check if catering customer gets order correct");
        CateringCustomer customer = new CateringCustomer(1);
        if(customer.arrayList.length == 15){
            System.out.println("Status: Passed");
        }else{
            System.out.println("Status: Failed");
        }
    }
}