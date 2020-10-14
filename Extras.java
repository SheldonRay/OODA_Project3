public abstract class Extras extends Rolls {
    Rolls roll;
    abstract public int cost();
}

class Sauce extends Extras {
    public Sauce (Rolls roll){
        this.roll = roll;
    }

    public int cost(){
        return roll.cost + 1;
    }
}

class Filling extends Extras {
    public Filling (Rolls roll){
        this.roll = roll;
    }

    public int cost(){
        return roll.cost + 1;
    }
}


class Topping extends Extras {
    public Topping (Rolls roll){
        this.roll = roll;
    }

    public int cost(){
        return roll.cost + 1;
    }
}
