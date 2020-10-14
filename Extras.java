public abstract class Extras extends Rolls{
    
    public class Sauce extends Extras{
        Rolls roll;

        public Sauce (Rolls roll){
            this.roll = roll;
        }

        public double cost(){
            return roll.cost() + (0.50 * (rand.nextInt((3 - 0) + 1) + 0));
        }
    }

    public class Filling extends Extras{
        Rolls roll;

        public Filling (Rolls roll){
            this.roll = roll;
        }

        public double cost(){
            return roll.cost() + (0.25 * (rand.nextInt((1 - 0) + 1) + 0));
        }
    }


    public class Topping extends Extras{
        Rolls roll;

        public Topping (Rolls roll){
            this.roll = roll;
        }

        public double cost(){
            return roll.cost() + (1.00 * (rand.nextInt((2 - 0) + 1) + 0));
        }
    }
}
