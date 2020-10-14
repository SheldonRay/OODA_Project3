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
    public int calculateCost(int sauce, int fill, int top) { //what do I put in place or "roll"??????
      while(sauce > 0){
          roll = new Sauce (roll);
          sauce -= 1;
      }
      while(fill > 0){
          roll = new Filling (roll);
          fill -= 1;
      }
      while(top > 0){
          roll = new Topping (roll);
          top -= 1;
      }
      return cost;
    } //expand function to include extras
    abstract public void printDailyOrderCount();
}

class EggRolls extends Rolls {s
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