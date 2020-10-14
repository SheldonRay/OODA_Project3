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

    public static void main(String args[]){//Main for testing customer stuff
        //Delete this main when doing testing for the resturant, when all is done get rid of this main
        customerFactory factory = new customerFactory();//AN ABSTRACT CLASS THAT HAS THE PRODUCTS OF THE FACTORY
        customer casual = factory.createCustomer("casual");
        customer cater = factory.createCustomer("catering");
        customer buis = factory.createCustomer("business");
        for (int i = 0; i < 3 ; i++) {
            System.out.println(casual.rollArray[i]);
        }
        return;
    }
}

//Start Customers
class casualCustomer extends customer{//CONCRETE PRODUCTS
    casualCustomer(){//upon creation each casual customer given an array of size 3
        rollArray = new int[3];
        rollChoice(this);
    }
}

class businessCustomer extends customer{
    businessCustomer(){
        rollArray = new int[10];
        rollChoice(this);
    }
}

class cateringCustomer extends customer {
    cateringCustomer() {
        rollArray = new int[15];
        rollChoice(this);
    }
}
//End customers AND CONCRETE PRODUCTS


// Catering customers will buy 5 rolls of 3 different types, 15 total (Rand for type)
