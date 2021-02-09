// Emlpoyee class which are threads
public class Employee extends Thread{
    private String name;
    private volatile int energy;
    
    // Employee is created with a runnable,name and energy at start
    public Employee(Runnable run, String name, int energy) {
    	super(run);
        this.name = name;
        this.energy = (int)(Math.random() * energy + 30);
    }

    // Setter to update the employees energy after drinking
    public void setEnergy(int energy) {
        this.energy += energy;
    }

    // returns the employees name
    public String getEmployee() {
        return name;
    }

    // returns the employees current energy
    public int getEnergy() {
        return energy;
    }
    
    // This function is to used to later print out the employees name and energy at start
    public String toString() {
        return "Name: " + name + " Energy: " + energy;
    }
    
    // reduces the energy of the user by 10 whenever called
    public void reduceEnergy() {
        this.energy -= 10;
    }
}
