import java.util.Random;

class StoreSim {
  Store store;
  CustomerFactory factory = new CustomerFactory();//A CLASS THAT HAS THE PRODUCTS OF THE FACTORY
  Customer custarray[];
  int day = 1;

  //A total of 1 to 12 casual customers, 1 to 3 business customers, and 1 to 3 catering customers
  public static int RandCasualCustomersNum(){//https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
      Random rand = new Random();
      int randomNum = rand.nextInt((12 - 1) + 1) + 1;
      return randomNum;
  }

  public static int RandThree(){//https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
      Random rand = new Random();
      int randomNum = rand.nextInt((3 - 1) + 1) + 1;
      return randomNum;
  }

  public Customer[] populateCustomers() {
    int cas = RandCasualCustomersNum();
    int bus = RandThree();
    int cat = RandThree();
    int tot = cas+bus+cat;
    int i = 0;
    Customer[] custarr = new Customer[tot];
    while(cas > 0 || bus > 0 || cat > 0) {
      int custnum = RandThree();
      if(custnum == 1 && cas > 0) {
        custarr[i] = factory.createCustomer("casual");
        i++;
        cas--;
      }
      if(custnum == 2 && bus > 0) {
        custarr[i] = factory.createCustomer("business");
        i++;
        bus--;
      }
      if(custnum == 3 && cat > 0) {
        custarr[i] = factory.createCustomer("catering");
        i++;
        cat--;
      }
    }
    return custarr;
  }

  public static void main(String args[]) {
    System.out.println("Tests:");
    MyUnitTest test = new MyUnitTest();
    test.checkOutages();
    test.checkInventoryIsRefilled();
    test.checkStoreClosedEarly();
    test.checkTotalEggRollOrders();
    test.checkCustomerOutageOrderIsFullfilled();
    test.checkDailySalesAreAddedToTotal();
    test.checkTotalSpringRollOrders();
    test.checkCasualCustomerGetsCorrectOrder();
    test.checkBusinessCustomerGetsCorrectOrder();
    test.checkCateringCustomerGetsCorrectOrder();
    System.out.println("----------------------------------------");
    StoreSim sim = new StoreSim();
    int size;
    try { //https://stackoverflow.com/questions/5585779/how-do-i-convert-a-string-to-an-int-in-java
      size = Integer.parseInt(args[0]);
    } catch(NumberFormatException e) {
      size = 30;
    }
    sim.runSimulation(size);
  }

  public void runSimulation(int size) {
    this.store = new Store(1);
    for(int day = 0; day < 30; day++) {
      System.out.println("Day: " + (day + 1));
      store.refillInventory(size);
      store.printInventory();
      this.custarray = populateCustomers(); //randomize number of customers and order
      int custlength = custarray.length;

      for(int i = 0; i < custlength; i++) { //takes orders of cusomers for the day
        if(store.storeClosed) {
          System.out.println("Store closed for the day: Out of Stock!");
          break;
        }
        this.custarray[i].makeOrder(this.store);
      }
      //calculate and print outages and spending by customer type
      int casspent = 0;
      int casout = 0;
      int busspent = 0;
      int busout = 0;
      int catspent = 0;
      int catout = 0;
      for(int i = 0; i < custlength; i++) {
        //spending counting
        if(this.custarray[i] instanceof CasualCustomer) {
          casspent += custarray[i].customerspent;
        }
        if(this.custarray[i] instanceof BusinessCustomer) {
          busspent += custarray[i].customerspent;
        }
        if(this.custarray[i] instanceof CateringCustomer) {
          catspent += custarray[i].customerspent;
        }
        //outage counting
        if(this.custarray[i].outage == true && this.custarray[i].wentToStore == true) {
          if(this.custarray[i] instanceof CasualCustomer) {
            casout+=1;
          }
          if(this.custarray[i] instanceof BusinessCustomer) {
            busout+=1;
          }
          if(this.custarray[i] instanceof CateringCustomer) {
            catout+=1;
          }
        }
      }
      System.out.println("Casual Customers Spent: " + casspent);
      System.out.println("Business Customers Spent: " + busspent);
      System.out.println("Catering Customers Spent: " + catspent);
      System.out.println("Total Daily Sales: " + (casspent + busspent + catspent));
      System.out.println("Casual Customer Outages: " + casout);
      System.out.println("Business Customer Outages: " + busout);
      System.out.println("Catering Customer Outages: " + catout);

      store.printDailyOrders();
      store.resetDailyOrders();
      store.printInventory();
      System.out.println("-----------------------------------------");
    }
    //all the stuff printed out at the end of the 30 days
    System.out.println("Total EggRolls Sold: " + store.getTotalEggOrders());
    System.out.println("Total SpringRolls Sold: " + store.getTotalSpringOrders());
    System.out.println("Total PastryRolls Sold: " + store.getTotalPastryOrders());
    System.out.println("Total SausageRolls Sold: " + store.getTotalSausageOrders());
    System.out.println("Total JellyRolls Sold: " + store.getTotalJellyOrders());
    System.out.println("Total Rolls Sold: " + store.getTotalOrders());
    System.out.println("Total Sales: " + store.getTotalSales());
    System.out.println("Total Outage Impacts: " + store.getTotalOutages());
  }
}
