public abstract class Coffee {
    private int coffeeValue;

    public Coffee() {

    }
    
    // random function for given min and max coffee value, then saved the value on the coffeeValue int
    public void coffeeEnergy(int min, int max) {
        int random = (int) (Math.random() * (max - min + 1)) + min;
        coffeeValue = random;

    }

    // returns the coffeeValue based on the specific generated coffee
    public int getCoffeeValue() {
        return coffeeValue;
    }
    public abstract String getCoffeeName();



}

