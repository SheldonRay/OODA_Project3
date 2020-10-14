abstract class Rolls {
    protected int inventory = 30;
    public int dailyOrders = 0;
    protected int dailyPayment = 0;
    public int cost = 1;
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
    public int calculateCost(int sauce, int fill, int top) {
      return cost;
    }
    public void printDailyOrderCount() {
      System.out.println("Daily roll orders: " + dailyOrders);
    }
}

class EggRolls extends Rolls {
    public EggRolls(int inventory) {
        this.inventory = inventory;
        this.cost = 2;
    }
    public void printDailyOrderCount() {
      System.out.println("Daily Eggroll orders: " + dailyOrders);
    }
    public int calculateCost(int sauce, int fill, int top) {
      Rolls temp = new EggRolls(1);
      while(sauce > 0){
          temp = new Sauce(temp);
          sauce -= 1;
      }
      while(fill > 0){
          temp = new Filling(temp);
          fill -= 1;
      }
      while(top > 0){
          temp = new Topping(temp);
          top -= 1;
      }
      return temp.cost;
    }
}

class SpringRolls extends Rolls {
    SpringRolls(int inventory){
        this.inventory = inventory;
        this.cost = 3;
    }
    public void printDailyOrderCount() {
      System.out.println("Daily Springroll orders: " + dailyOrders);
    }
    public int calculateCost(int sauce, int fill, int top) {
      Rolls temp = new SpringRolls(1);
      while(sauce > 0){
          temp = new Sauce(temp);
          sauce -= 1;
      }
      while(fill > 0){
          temp = new Filling(temp);
          fill -= 1;
      }
      while(top > 0){
          temp = new Topping(temp);
          top -= 1;
      }
      return temp.cost;
    }
}

class PastryRolls extends Rolls {
    PastryRolls(int inventory){
        this.inventory = inventory;
        this.cost = 4;
    }
    public void printDailyOrderCount() {
      System.out.println("Daily Pastryroll orders: " + dailyOrders);
    }
    public int calculateCost(int sauce, int fill, int top) {
      Rolls temp = new PastryRolls(1);
      while(sauce > 0){
          temp = new Sauce(temp);
          sauce -= 1;
      }
      while(fill > 0){
          temp = new Filling(temp);
          fill -= 1;
      }
      while(top > 0){
          temp = new Topping(temp);
          top -= 1;
      }
      return temp.cost;
    }
}

class SausageRolls extends Rolls {
    SausageRolls(int inventory) {
        this.inventory = inventory;
        this.cost = 5;
    }
    public void printDailyOrderCount() {
      System.out.println("Daily Sausageroll orders: " + dailyOrders);
    }
    public int calculateCost(int sauce, int fill, int top) {
      Rolls temp = new SausageRolls(1);
      while(sauce > 0){
          temp = new Sauce(temp);
          sauce -= 1;
      }
      while(fill > 0){
          temp = new Filling(temp);
          fill -= 1;
      }
      while(top > 0){
          temp = new Topping(temp);
          top -= 1;
      }
      return temp.cost;
    }
}
class JellyRolls extends Rolls {
    JellyRolls(int inventory) {
        this.inventory = inventory;
        this.cost = 6;
    }
    public void printDailyOrderCount() {
      System.out.println("Daily Jellyroll orders: " + dailyOrders);
    }
    public int calculateCost(int sauce, int fill, int top) {
      Rolls temp = new JellyRolls(1);
      while(sauce > 0){
          temp = new Sauce(temp);
          sauce -= 1;
      }
      while(fill > 0){
          temp = new Filling(temp);
          fill -= 1;
      }
      while(top > 0){
          temp = new Topping(temp);
          top -= 1;
      }
      return temp.cost;
    }
}
