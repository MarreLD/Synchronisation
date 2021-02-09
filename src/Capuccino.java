public class Capuccino extends Coffee{
    private int min = 20;
    private int max = 30;
    private String cappucino = "Cappucino";
    
 // runs the coffeeEnergy funtion as soon as created
    public Capuccino() {
        coffeeEnergy(min,max);
    }

    @Override
    // returns the cappucino and the respective value
    public String toString() {
        return cappucino +": " + getCoffeeValue();
    }

	@Override
	public String getCoffeeName() {
		// TODO Auto-generated method stub
		return cappucino;
	}
}
