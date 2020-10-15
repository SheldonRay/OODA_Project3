public class CustomerFactory{ //FACTORY
    //Factory method to create the customers

    public Customer createCustomer(String type){//Make the customers given what type they are supposed to be
        if (type.equals("casual") || type.equals("Casual")){
            return new CasualCustomer();
        }
        else if (type.equals("business") || type.equals("Buisness")){
            return new BusinessCustomer();
        }
        else if (type.equals("catering") || type.equals("Catering")){
            return new CateringCustomer();
        }
        else{
            return new CasualCustomer();//return a casual customer if no input
        }
    }

}
