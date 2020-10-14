import java.util.Random;


abstract public class Customer {
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

    public static int RandRollChoice(){//https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
        Random rand = new Random();
        int randomNum = rand.nextInt((5 - 1) + 1) + 1;
        return randomNum;
    }

    //1 = eggRoll
    //2 = springRoll
    //3 = pastryRoll
    //4 = sausageRoll
    //5 = jellyRoll
    public static void rollChoice(customer person) {//populate array with rolls based on what customer "wants"
        int rollChoice = 0;
        Boolean flag = false;
        if (person.rollArray.length == 15){
            rollChoice = RandRollChoice();
            for (int i = 0; i < person.rollArray.length; i++) {//Catering customer selection
                if ( i>=5 && !flag && i<10){
                    rollChoice = RandRollChoice();
                    flag = true;
                }
                if (i>=10 && flag ){
                    rollChoice = RandRollChoice();
                    flag = false;
                }
                person.rollArray[i] = rollChoice;
            }
        } else {
            for (int i = 0; i < person.rollArray.length; i++) {//Casual Customer selection
                rollChoice = RandRollChoice();
                person.rollArray[i] = rollChoice;
            }
        }
    }
    //Should be a function in Resturant that is able to change the roll array depending on if they dont have enough stock

}

//Start Customers
class CasualCustomer extends Customer{//CONCRETE PRODUCTS
    public CasualCustomer() {//upon creation each casual customer given an array of size 3
        rollArray = new int[3];
        rollChoice(this);
    }
}

class BusinessCustomer extends Customer{
    public BusinessCustomer() {
        rollArray = new int[10];
        for (int i = 0; i < 10; i++) {
            rollArray[i] = (i/2)+1;
        }
    }
}

class CateringCustomer extends Customer {
    public CateringCustomer() {
        rollArray = new int[15];
        rollChoice(this);
    }
}
//End customers AND CONCRETE PRODUCTS


// Catering customers will buy 5 rolls of 3 different types, 15 total (Rand for type)
