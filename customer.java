import java.util.Random;
abstract public class customer {
    int rollArray[];

    //A total of 1 to 12 casual customers, 1 to 3 business customers, and 1 to 3 catering customers
    public static int RandCasualCustomersNum(){//https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
        Random rand = new Random();
        int randomNum = rand.nextInt((12 - 1) + 1) + 1;
        return randomNum;
    }

    public static int RandBusinessAndCateringCustomersNum(){//https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        return randomNum;
    }

    //1 = eggRoll
    //2 = springRoll
    //3 = pastryRoll
    //4 = sausageRoll
    //5 = jellyRoll
    public static int rollChoice(customer person){//populate array with rolls based on what customer they are
        return 1;
    }

    public static void main(String args[]){
        customer casual = new casualCustomer();
        customer buis = new businessCustomer();
        customer cater = new cateringCustomer();
        System.out.println(casual.rollArray.length);
        System.out.println(buis.rollArray.length);
        System.out.println(cater.rollArray.length);
    }

    public void createCustomers(){//Make a for loop and create all of them per day
        int numCasualCustomers = customer.RandCasualCustomersNum();
        int numBusinessCustomers = customer.RandBusinessAndCateringCustomersNum();
        int numCateringCustomers = customer.RandBusinessAndCateringCustomersNum();
    }
}


//Start Customers
class casualCustomer extends customer{//make some thing here, maybe a buy function based on the rand number of rolls they wanna buy
    int totalNumCasualCustomers = 0;
    int dailyNumCasualCustomers = 0;
    casualCustomer(){//upon creation each casual customer given an array of size 3
        rollArray = new int[3];
        for (int i = 0; i < 3; i++) {
            this.rollArray[i] = -1;
        }
    }

}

class businessCustomer extends customer{
    int totalBusinessCustomers = 0;
    int dailyBusinessCustomers = 0;
    businessCustomer(){
        rollArray = new int[10];
        for (int i = 0; i < 10 ; i++) {
            this.rollArray[i] = -1;
        }
    }
}

class cateringCustomer extends customer {
    int totalCateringCustomers = 0;
    int dailyCateringCustomers = 0;
    cateringCustomer() {
        rollArray = new int[15];
        for (int i = 0; i < 15; i++) {
            this.rollArray[i] = -1;
        }
    }
}
//End customers


// Casual customers will buy 1 to 3 rolls (Rand)
// Business customers will buy 10 rolls, two of each type.
// Catering customers will buy 5 rolls of 3 different types, 15 total (Rand for type)