import java.util.ArrayList;
import java.util.Random;

public class CoffeeMachine {
	private int additional;
	// String to keep track of the random selected coffee
	public static String coffeeName;
	// arraylist of coffees is created
	public ArrayList<Coffee> coffeeCapacity;

	// when the CoffeeMachine is called it will create 20 different coffees.
	public CoffeeMachine() {
		coffeeCapacity = new ArrayList<>();
		fillCoffee(20);
		System.out.println("Coffee machine is created with " + coffeeCapacity.size() + " drinks");

	}

	// fills the arraylist with "x" amount of coffee, is also synchronised
	public synchronized void fillCoffee(int capacity) {
		// Will run the loop until the given amount of coffees needed are added
		for (int i = 0; i < capacity; i++) {
			// randomCoffee will get a new value between 0-2 everytime the loop starts over
			int randomCoffee = percentage(3);
			// switch to check the given value and then creates that coffee correspondingly
			// .
			switch (randomCoffee) {
			case 0:
				coffeeCapacity.add(new Latte());
				break;
			case 1:
				coffeeCapacity.add(new Capuccino());
				break;
			case 2:
				coffeeCapacity.add(new BlackCoffee());
				break;
			}
		}
	}

	// synchronised function that removes a coffee after being consumed.
	public synchronized int drinkCoffee() {
		// randomCoffee will get a value between 0-19
		int randomCoffee = percentage(coffeeCapacity.size());
		// randomCValue will get the value of the coffee that was selected and stored
		// inside the variable
		int randomCValue = coffeeCapacity.get(randomCoffee).getCoffeeValue();
		coffeeName = coffeeCapacity.get(randomCoffee).getCoffeeName();
		// removes that random coffee that was chosen
		coffeeCapacity.remove(randomCoffee);
		// returns the energy value of that random selected coffee
		return randomCValue;

	}

	// has 20% chance to create new drinks after each time someone drank a coffee
	public synchronized void chance() {
		// randomizes a value between 0-9
		additional = percentage(10);
		// if chance is 1 or less which in this case is 20% execute the following
		if (additional <= 1) {
			fillCoffee(5);
			System.out.println("5 new drinks have been added");
		}

	}

	// function that creates a number between 0 and the given number e.g.
	// percentage(20) = 0-19
	private int percentage(int amount) {
		Random randomGenerator = new Random();
		int randomValue = randomGenerator.nextInt(amount);
		return randomValue;
	}

	public void print() {

		System.out.println(coffeeCapacity);
	}

}
