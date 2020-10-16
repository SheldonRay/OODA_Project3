public abstract class Extras extends Rolls {
    Rolls roll;
}

class Sauce extends Extras {
    public Sauce (Rolls roll){
        this.roll = roll;
    }

    public int getCost(){
        return (roll.getCost() + 1);
    }
}

class Filling extends Extras {
    public Filling (Rolls roll){
        this.roll = roll;
    }

    public int getCost(){
        return (roll.getCost() + 2);
    }
}


class Topping extends Extras {
    public Topping (Rolls roll){
        this.roll = roll;
    }

    public int getCost(){
        return (roll.getCost() + 3);
    }
}
