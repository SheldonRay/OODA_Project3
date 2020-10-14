//need a decorator method to make the toppings and sauces
abstract class Rolls {
    protected int inventory = 30;
    public int dailyOrders = 0;
    protected int dailyPayment = 0;
    public double cost = 1.0;
    public void setInventory(int inventory) {
      this.inventory = inventory;
    }
    public int getInventory() {
      return inventory;
    }
    public void takeOneRoll() {
      inventory -= 1;
      dailyOrders += 1;
    }
    public int calculateCost() {
      return cost;
    } //expand function to include extras
    abstract public void printDailyOrderCount();
}

class EggRolls extends Rolls {
    cost = 2.0;
    public EggRolls(int inventory) {
        this.inventory = inventory;
    }
    public void printDailyOrderCount() {
      System.out.prinln("Daily Eggroll orders: " + dailyOrders);
    }
}

class SpringRolls extends Rolls {
    cost = 2.5;
    SpringRolls(int inventory){
        this.inventory = inventory;
    }
    public void printDailyOrderCount() {
      System.out.prinln("Daily Springroll orders: " + dailyOrders);
    }
}

class PastryRolls extends Rolls {
    cost = 2.75;
    PastryRolls(int inventory){
        this.inventory = inventory;
    }
    public void printDailyOrderCount() {
      System.out.prinln("Daily Pastryroll orders: " + dailyOrders);
    }
}

class SausageRolls extends rolls {
    cost = 3.0;
    SausageRolls(int inventory) {
        this.inventory = inventory;
    }
    public void printDailyOrderCount() {
      System.out.prinln("Daily Sausageroll orders: " + dailyOrders);
    }
}
class JellyRolls extends rolls {
    cost = 3.25;
    JellyRolls(int inventory) {
        this.inventory = inventory;
    }
    public void printDailyOrderCount() {
      System.out.prinln("Daily Jellyroll orders: " + dailyOrders);
    }
}
