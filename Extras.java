public abstract class Extras extends Rolls{
    
    public class Sauce extends Extras{
        Rolls roll;

        public Sauce (Rolls roll){
            this.roll = roll;
        }

        public double cost(int num){
            return roll.cost() + (0.50 * num);
        }
    }

    public class Filling extends Extras{
        Rolls roll;

        public Filling (Rolls roll){
            this.roll = roll;
        }

        public double cost(int num){
            return roll.cost() + (0.25 * num);
        }
    }


    public class Topping extends Extras{
        Rolls roll;

        public Topping (Rolls roll){
            this.roll = roll;
        }

        public double cost(int num){
            return roll.cost() + (1.00 * num);
        }
    }
}
