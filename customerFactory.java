public class customerFactory{ //FACTORY
    //Factory method to create the customers

    public customer createCustomer(String type){//Make the customers given what type they are supposed to be
        if (type.equals("casual") || type.equals("Casual")){
            return new casualCustomer();
        }
        else if (type.equals("business") || type.equals("Buisness")){
            return new businessCustomer();
        }
        else if (type.equals("catering") || type.equals("Catering")){
            return new cateringCustomer();
        }
        else{
            return new casualCustomer();//return a casual customer if no input
        }
    }

}
