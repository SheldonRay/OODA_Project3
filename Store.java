//Made by Sheldon Ray, Tyler Devlin, Jacob Reynolds
//08/12/2020


private class Store {
    private int storeID = 0;
    private int totalEggOrders = 0;
    private int totalSpringOrders = 0;
    private int totalPastryOrders = 0;
    private int totalSausageOrders = 0;
    private int totalJellyOrders = 0;
    private int totalSales = 0;
    private int totalOutages = 0;

    public Boolean storeClosed = false;

    public EggRolls eggRolls = new EggRolls();
    public SpringRolls springRolls = new SpringRolls();
    public PastryRolls pastryRolls = new PastryRolls();
    public SausageRolls sausageRolls = new SausageRolls();
    public JellyRolls jellyRolls = new JellyRolls();
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
      return totalSpringOrders
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
    public void refillInventory() {
      if (eggRolls.getInventory() <= 0) {
        eggRolls.setInventory(30);
      }
      if (springRolls.getInventory() <= 0) {
        springRolls.setInventory(30);
      }
      if (pastryRolls.getInventory() <= 0) {
        pastryRolls.setInventory(30);
      }
      if (sausageRolls.getInventory() <= 0) {
        sausageRolls.setInventory(30);
      }
      if (jellyRolls.getInventory() <= 0) {
        jellyRolls.setInventory(30);
      }
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
      if (customer instanceof BusinessCustomer) {
        if (eggRolls.inventory < 2 || springRolls.inventory < 2 || pastryRolls.inventory < 2 || sausageRolls.inventory < 2 || jellyRolls.inventory < 2) {
          totalOutages += 1;
          return true;
        }
      }
      Boolean outage = false;
      for (int i = 0; i < rolls.length; i++) {
        if(outage) {
          if(eggRolls.getInventory() > 0) {
            eggRolls.takeOneRoll();
            orderCost += eggRolls.calculateCost(); //expand function to include extras
          } else if(springRolls.getInventory() > 0) {
            springRolls.takeOneRoll();
            orderCost += springRolls.calculateCost();
          } else if(pastryRolls.getInventory() > 0) {
            pastryRolls.takeOneRoll();
            orderCost += pastryRolls.calculateCost();
          } else if(sausageRolls.getInventory() > 0) {
            sausageRolls.takeOneRoll();
            orderCost += sausageRolls.calculateCost();
          } else if(jellyRolls.getInventory() > 0) {
            jellyRolls.takeOneRoll();
            orderCost += jellyRolls.calculateCost();
          } else {
            storeClosed = true;
            totalSales += orderCost;
            return true;
          }
        } else {
          switch(rollArray[i]) {
            case 1:
              if(eggRolls.getInventory() > 0) {
                eggRolls.takeOneRoll();
                orderCost += eggRolls.calculateCost(sauceArray[i], fillArray[i], topArray[i], eggRolls);
              } else {
                outage = true;
                totalOutages++;
              }
              break;
            case 2:
              if(springRolls.getInventory() > 0) {
                springRolls.takeOneRoll();
                orderCost += springRolls.calculateCost();
              } else {
                outage = true;
                totalOutages++;
              }
              break;
            case 3:
              if(pastryRolls.getInventory() > 0) {
                pastryRolls.takeOneRoll();
                orderCost += pastryRolls.calculateCost();
              } else {
                outage = true;
                totalOutages++;
              }
              break;
            case 4:
              if(sausageRolls.getInventory() > 0) {
                sausageRolls.takeOneRoll();
                orderCost += sausageRolls.calculateCost();
              } else {
                outage = true;
                totalOutages++;
              }
              break;
            case 5;
              if(jellyRolls.getInventory() > 0) {
                jellyRolls.takeOneRoll();
                orderCost += jellyRolls.calculateCost();
              } else {
                outage = true;
                totalOutages++;
              }
              break;
          }
        }
      }
      return outage;
    }
}