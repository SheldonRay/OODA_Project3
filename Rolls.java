//need a decorator method to make the toppings and sauces
abstract class Rolls {
    protected int inventory = 30;
    protected int dailyOrders = 0;
    protected int dailyPayment = 0;
    protected int cost = 1;
    public void setInventory(int inventory) {
      this.inventory = inventory;
    }
    public int getInventory() {
      return inventory;
    }

}

class EggRolls extends Rolls{
    public EggRolls(int inventory){
        this.inventory = inventory;
    }
}

class SpringRolls extends Rolls{
    SpringRolls(int inventory){
        this.inventory = inventory;
    }
}

class PastryRolls extends Rolls{
    PastryRolls(int inventory){
        this.inventory = inventory;
    }
}

class SausageRolls extends rolls{
    SausageRolls(int inventory){
        this.inventory = inventory;
    }
}
class JellyRolls extends rolls{
    JellyRolls(int inventory){
        this.inventory = inventory;
    }
}
