public class Latte extends Coffee {
    private int min = 25;
    private int max = 35;
    private String latte = "Latte";

    // runs the coffeeEnergy funtion as soon as created
    public Latte() {
        coffeeEnergy(min,max);
    }
    
    @Override
    // returns the latte and the respective value
    public String toString() {
        return latte +": " + getCoffeeValue();
    }

	@Override
	public String getCoffeeName() {
		// TODO Auto-generated method stub
		return latte;
	}
}
