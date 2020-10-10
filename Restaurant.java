//Made by Sheldon Ray, Tyler Devlin, Jacob Reynolds
//08/12/2020


public class Restaurant {
    int storeID = 1;
    int day = 0;

    //sales numbers
    int casualSales = 0;
    int businessSales = 0;
    int cateringSales = 0;
}

//class storeManager extends Observable

//need a decorator method to make the toppings and sauces
abstract class rolls extends Restaurant {
    public int inventory = 30;

}

//Start of Rolls
class eggRoll extends rolls{
    eggRoll(int invent){
        this.inventory = invent;
    }
    int dailyOrders = 0;
    int totalOrders = 0;
    int cost = 1;

}

class springRoll extends rolls{
    springRoll(int invent){
        this.inventory = invent;
    }
    int dailyOrders = 0;
    int totalOrders = 0;
    int cost = 1;
}

class pastryRoll extends rolls{
    pastryRoll(int invent){
        this.inventory = invent;
    }
    int dailyOrders = 0;
    int totalOrders = 0;
    int cost = 1;
}

class sausageRoll extends rolls{
    sausageRoll(int invent){
        this.inventory = invent;
    }
    int dailyOrders = 0;
    int totalOrders = 0;
    int cost = 1;
}
class jellyRoll extends rolls{
    jellyRoll(int invent){
        this.inventory = invent;
    }
    int dailyOrders = 0;
    int totalOrders = 0;
    int cost = 1;
}
//End of Rolls