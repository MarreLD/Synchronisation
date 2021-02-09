public class BlackCoffee extends Coffee {
    private int min = 20;
    private int max = 40;
    private String blackCoffee = "Black Coffee";

 // runs the coffeeEnergy funtion as soon as created
    public BlackCoffee() {
        coffeeEnergy(min,max);
    }

    @Override
    // returns the blackCoffee and the respective value
    public String toString() {
        return blackCoffee + ": " +getCoffeeValue();
    }

	@Override
	public String getCoffeeName() {
		// TODO Auto-generated method stub
		return blackCoffee;
	}
}
