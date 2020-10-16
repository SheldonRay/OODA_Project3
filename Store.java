//Made by Sheldon Ray, Tyler Devlin, Jacob Reynolds
//08/12/2020


class Store {
    private int storeID = 0;
    private int totalEggOrders = 0;
    private int totalSpringOrders = 0;
    private int totalPastryOrders = 0;
    private int totalSausageOrders = 0;
    private int totalJellyOrders = 0;
    private int totalSales = 0;
    private int totalOutages = 0;

    public Boolean storeClosed = false;

    public EggRolls eggRolls = new EggRolls(0);
    public SpringRolls springRolls = new SpringRolls(0);
    public PastryRolls pastryRolls = new PastryRolls(0);
    public SausageRolls sausageRolls = new SausageRolls(0);
    public JellyRolls jellyRolls = new JellyRolls(0);
    public Store(int storeID) {
      this.storeID = storeID;
    }

    public int getTotalOrders() {
        return totalEggOrders + totalSpringOrders + totalPastryOrders + totalSausageOrders + totalJellyOrders;
    }

    public int getTotalEggOrders() {
      return totalEggOrders;
    }
    public int getTotalSpringOrders() {
      return totalSpringOrders;
    }
    public int getTotalPastryOrders() {
      return totalPastryOrders;
    }
    public int getTotalSausageOrders() {
      return totalSausageOrders;
    }
    public int getTotalJellyOrders() {
      return totalJellyOrders;
    }
    public int getTotalSales() {
      return totalSales;
    }
    public int getTotalOutages() {
      return totalOutages;
    }
    public Boolean getStoreClosed() {
        return storeClosed;
      }
    public void printInventory() {
      System.out.println(eggRolls.inventory + " egg rolls in inventory");
      System.out.println(springRolls.inventory + " spring rolls in inventory");
      System.out.println(pastryRolls.inventory + " pastry rolls in inventory");
      System.out.println(sausageRolls.inventory + " sausage rolls in inventory");
      System.out.println(jellyRolls.inventory + " jelly rolls in inventory");
    }
    public void refillInventory(int size) {
      if (eggRolls.getInventory() <= 0) {
        eggRolls.setInventory(size);
      }
      if (springRolls.getInventory() <= 0) {
        springRolls.setInventory(size);
      }
      if (pastryRolls.getInventory() <= 0) {
        pastryRolls.setInventory(size);
      }
      if (sausageRolls.getInventory() <= 0) {
        sausageRolls.setInventory(size);
      }
      if (jellyRolls.getInventory() <= 0) {
        jellyRolls.setInventory(size);
      }
      storeClosed = false;
    }
    public void printDailyOrders() {
      eggRolls.printDailyOrderCount();
      springRolls.printDailyOrderCount();
      pastryRolls.printDailyOrderCount();
      sausageRolls.printDailyOrderCount();
      jellyRolls.printDailyOrderCount();
    }
    public void resetDailyOrders() {
      eggRolls.dailyOrders = 0;
      springRolls.dailyOrders = 0;
      pastryRolls.dailyOrders = 0;
      sausageRolls.dailyOrders = 0;
      jellyRolls.dailyOrders = 0;
    }
    public Boolean takeOrder(int rollArray[], int sauceArray[], int fillArray[], int topArray[], Customer customer) { //return true if outage, false if no outage
      int orderCost = 0;
      int numeggrolls = 0;
      int numspringrolls = 0;
      int numpastryrolls = 0;
      int numsausagerolls = 0;
      int numjellyrolls = 0;
      double totextras = 0.0;
      if (customer instanceof BusinessCustomer) {
        if (eggRolls.getInventory() < 2 || springRolls.getInventory() < 2 || pastryRolls.getInventory() < 2 || sausageRolls.getInventory() < 2 || jellyRolls.getInventory() < 2) {
          totalOutages += 1;
          return true;
        }
      }
      Boolean outage = false;
      for (int i = 0; i < rollArray.length; i++) {
        if(outage) {
          if(eggRolls.getInventory() > 0) {
            eggRolls.takeOneRoll();
            numeggrolls++;
            orderCost += eggRolls.calculateCost(0,0,0); //expand function to include extras
          } else if(springRolls.getInventory() > 0) {
            springRolls.takeOneRoll();
            numspringrolls++;
            orderCost += springRolls.calculateCost(0,0,0);
          } else if(pastryRolls.getInventory() > 0) {
            pastryRolls.takeOneRoll();
            numpastryrolls++;
            orderCost += pastryRolls.calculateCost(0,0,0);
          } else if(sausageRolls.getInventory() > 0) {
            sausageRolls.takeOneRoll();
            numsausagerolls++;
            orderCost += sausageRolls.calculateCost(0,0,0);
          } else if(jellyRolls.getInventory() > 0) {
            jellyRolls.takeOneRoll();
            numjellyrolls++;
            orderCost += jellyRolls.calculateCost(0,0,0);
          } else {
            storeClosed = true;
            totalSales += orderCost;
            customer.customerspent += orderCost;
            printOrderGiven(numeggrolls, numspringrolls, numpastryrolls, numsausagerolls, numjellyrolls, totextras, orderCost, customer);
            return true;
          }
        } else {
          switch(rollArray[i]) {
            case 1:
              if(eggRolls.getInventory() > 0) {
                eggRolls.takeOneRoll();
                numeggrolls++;
                orderCost += eggRolls.calculateCost(sauceArray[i], fillArray[i], topArray[i]);
                totextras += (sauceArray[i] + fillArray[i] + topArray[i]);
                totalEggOrders += 1;
              } else {
                outage = true;
                totalOutages++;
              }
              break;
            case 2:
              if(springRolls.getInventory() > 0) {
                springRolls.takeOneRoll();
                numspringrolls++;
                orderCost += springRolls.calculateCost(sauceArray[i], fillArray[i], topArray[i]);
                totextras += (sauceArray[i] + fillArray[i] + topArray[i]);
                totalSpringOrders += 1;
              } else {
                outage = true;
                totalOutages++;
              }
              break;
            case 3:
              if(pastryRolls.getInventory() > 0) {
                pastryRolls.takeOneRoll();
                numpastryrolls++;
                orderCost += pastryRolls.calculateCost(sauceArray[i], fillArray[i], topArray[i]);
                totextras += (sauceArray[i] + fillArray[i] + topArray[i]);
                totalPastryOrders += 1;
              } else {
                outage = true;
                totalOutages++;
              }
              break;
            case 4:
              if(sausageRolls.getInventory() > 0) {
                sausageRolls.takeOneRoll();
                numsausagerolls++;
                orderCost += sausageRolls.calculateCost(sauceArray[i], fillArray[i], topArray[i]);
                totextras += (sauceArray[i] + fillArray[i] + topArray[i]);
                totalSausageOrders += 1;
              } else {
                outage = true;
                totalOutages++;
              }
              break;
            case 5:
              if(jellyRolls.getInventory() > 0) {
                jellyRolls.takeOneRoll();
                numjellyrolls++;
                orderCost += jellyRolls.calculateCost(sauceArray[i], fillArray[i], topArray[i]);
                totextras += (sauceArray[i] + fillArray[i] + topArray[i]);
                totalJellyOrders += 1;
              } else {
                outage = true;
                totalOutages++;
              }
              break;
          }
        }
      }
      totalSales += orderCost;
      customer.customerspent += orderCost;
      printOrderGiven(numeggrolls, numspringrolls, numpastryrolls, numsausagerolls, numjellyrolls, totextras, orderCost, customer);
      return outage;
    }
    public void printOrderGiven(int egg, int spring, int pastry, int sausage, int jelly, double extras, int cost, Customer customer) {
      if(customer instanceof CasualCustomer) {
        System.out.println("Casual Customer Orders:");
      }
      if(customer instanceof BusinessCustomer) {
        System.out.println("Business Customer Orders:");
      }
      if(customer instanceof CateringCustomer) {
        System.out.println("Catering Customer Orders:");
      }
      System.out.println(egg + " EggRolls, " + spring + " SpringRolls, " + pastry + " PastryRolls, " + sausage + " SausageRolls, and " + jelly + " JellyRolls.");
      double extaverage = extras / (egg + spring + pastry + sausage + jelly);
      System.out.println("They got " + extaverage + " Extras per Roll");
      System.out.println("Order Cost: " + cost);
    }
}
