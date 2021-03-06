import java.util.Random;


abstract public class Customer {
    int rollArray[];
    int sauceArray[];
    int fillArray[];
    int topArray[];
    Boolean outage = false;
    Boolean wentToStore = false;
    int customerspent = 0;

    public static int RandRollChoice(){//https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
        Random rand = new Random();
        int randomNum = rand.nextInt((5 - 1) + 1) + 1;
        return randomNum;
    }

    public static int RandSauceChoice(){//https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 0) + 1) + 0;
        return randomNum;
    }

    public static int RandFillChoice(){//https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
        Random rand = new Random();
        int randomNum = rand.nextInt((1 - 0) + 1) + 0;
        return randomNum;
    }

    public static int RandTopChoice(){//https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
        Random rand = new Random();
        int randomNum = rand.nextInt((2 - 0) + 1) + 0;
        return randomNum;
    }


    //1 = eggRoll
    //2 = springRoll
    //3 = pastryRoll
    //4 = sausageRoll
    //5 = jellyRoll
    public static void rollChoice(Customer person) {//populate array with rolls based on what customer "wants"
        int rollChoice = 0;
        int pickThree[] = new int[3];
        if (person.rollArray.length == 15){
            rollChoice = RandRollChoice();
            pickThree[0] = rollChoice;
            while(rollChoice == pickThree[0]){
                rollChoice = RandRollChoice();
            }
            pickThree[1] = rollChoice;
            while(rollChoice == pickThree[0] || rollChoice == pickThree[1]){
                rollChoice = RandRollChoice();
            }
            pickThree[2] = rollChoice;
            for (int i = 0; i < person.rollArray.length; i++) {//Catering customer selection
                if (i>=0 && i<5){
                    person.rollArray[i] = pickThree[0];
                }
                if (i>=5 && i<10){
                    person.rollArray[i] = pickThree[1];
                }
                if (i>=10 && i<15 ){
                    person.rollArray[i] = pickThree[2];
                }
            }
        } else if (person.rollArray.length == 3) {
            for (int i = 0; i < person.rollArray.length; i++) {//Casual Customer selection
                rollChoice = RandRollChoice();
                person.rollArray[i] = rollChoice;
            }
        } else {
            for (int i = 0; i < 10; i++) { //Business Customer selection
                person.rollArray[i] = (i/2)+1;
            }
        }

        //extras
        for(int i = 0; i < person.rollArray.length; i++){
            person.sauceArray[i] = RandSauceChoice();
            person.fillArray[i] = RandFillChoice();
            person.topArray[i] = RandTopChoice();
        }

    }

    public void makeOrder(Store store) {
      outage = store.takeOrder(rollArray, sauceArray, fillArray, topArray, this);
      wentToStore = true;
    }


}

//Start Customers
class CasualCustomer extends Customer{//CONCRETE PRODUCTS
    public CasualCustomer() {//upon creation each casual customer given an array of size 3
        rollArray = new int[3];
        sauceArray = new int[3];
        fillArray= new int[3];
        topArray= new int[3];
        rollChoice(this);
    }
}

class BusinessCustomer extends Customer{
    public BusinessCustomer() {
        rollArray = new int[10];
        sauceArray = new int[10];
        fillArray= new int[10];
        topArray= new int[10];
        rollChoice(this);
    }
}

class CateringCustomer extends Customer {
    public CateringCustomer() {
        rollArray = new int[15];
        sauceArray = new int[15];
        fillArray= new int[15];
        topArray= new int[15];
        rollChoice(this);
    }
}
//End customers AND CONCRETE PRODUCTS


// Catering customers will buy 5 rolls of 3 different types, 15 total (Rand for type)
