import java.util.ArrayList;

public class Handler implements Runnable {
	private ArrayList<Employee> employees;
	public CoffeeMachine coffeeMachine;
	private boolean flag = true;
	public int coffeeSelected;

	public Handler() {
		// arraylist for employees
		employees = new ArrayList<>();
		coffeeMachine = new CoffeeMachine();
		// creates the employees and connects them to this runnable class
		Employee luigi = new Employee(this, "Luigi", 60);
		Employee mario = new Employee(this, "Mario", 60);
		Employee bowser = new Employee(this, "Bowser", 60);

		// add them to the arraylist
		employees.add(luigi);
		employees.add(mario);
		employees.add(bowser);

		// start the threads
		mario.start();
		luigi.start();
		bowser.start();

		// calls on the printout function for coffeeMachine and the one in this class
		coffeeMachine.print();
		print();

	}

	// run function that handles everything
	public void run() {

		// while this statement is true run the following and sleep it
		while (employees.size() != 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// if the current employee running has energy below 0 remove it from the list
			if (employees.get(threadCheck()).getEnergy() <= 0) {
				stopEmployee();
			}

			// if the current employee has below 30 energy and the flag is true and the
			// coffee machine is not empty, drink a coffee
			else if (employees.get(threadCheck()).getEnergy() < 30 && flag && coffeeMachine.coffeeCapacity.size() > 0) {
				drinking();

				// otherwise lose energy
			} else {
				employees.get(threadCheck()).reduceEnergy();
			}

		}
	}

	public void print() {
		System.out.println(employees);
	}

	// keeps track of the current thread running
	private int threadCheck() {
		int index = 0;
		for (int i = 0; i < employees.size(); i++) {
			if (Thread.currentThread().equals(employees.get(i))) {
				index = i;
			}
		}
		return index;
	}

	// synchronised method as soon as someone enters set the flag to false so nobody
	// else can access this function and then drink
	public synchronized void drinking() {
		flag = false;
		System.out.println(employees.get(threadCheck()).getEmployee() + " has "
				+ employees.get(threadCheck()).getEnergy() + " energy right now and goes to the cofferoom");
		// if the current employee running has below 100 energy drink once and sleep it

		if (employees.get(threadCheck()).getEnergy() <= 100) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			employees.get(threadCheck()).setEnergy(coffeeMachine.drinkCoffee());
			System.out.println(employees.get(threadCheck()).getEmployee() + " drank " + CoffeeMachine.coffeeName
					+ " and now has " + employees.get(threadCheck()).getEnergy() + " energy \n"
					+ "The coffee machine has now " + coffeeMachine.coffeeCapacity.size() + " drinks");
		} else {
			System.out.println(employees.get(threadCheck()).getEmployee() + " went back to work");
		}
		// runs the chance function that has a possibility to add 5 new drinks before
		// setting the flag to true
		coffeeMachine.chance();
		flag = true;

	}

	// stop the thread and remove it from the list
	public void stopEmployee() {
		System.out.println(employees.get(threadCheck()).getEmployee() + " reached too low energy and went home");
		employees.get(threadCheck()).stop();
		employees.remove(threadCheck());
	}

}
