/* This is a stub for the Cafe class */
/**
 * Cafe is a subclass of Building that represents a cafe.
 * It tracks inventory of coffee, sugar, cream, and cups.
 */
public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces;   // ounces of coffee remaining
    private int nSugarPackets;   // sugar packets remaining
    private int nCreams;         // splashes of cream remaining
    private int nCups;           // cups remaining

    /**
     * Creates a Cafe with the given details and starting inventory.
     * @param name Name of the cafe
     * @param address Address of the cafe
     * @param nFloors Number of floors
     * @param nCoffeeOunces Starting ounces of coffee
     * @param nSugarPackets Starting number of sugar packets
     * @param nCreams Starting number of cream splashes
     * @param nCups Starting number of cups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe ☕");
    }
    public void sellCoffee(int size) {
        sellCoffee(size, 0, 0);
    }

    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(int size, int sugar, int cream)");
    }
    /**
     * Sells a coffee and reduces inventory. If inventory is too low, restocks first.
     * @param size ounces of coffee
     * @param nSugarPackets number of sugar packets
     * @param nCreams number of cream splashes
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock(100, 50, 50, 20); // example restock values
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Sold a coffee! ☕");
    }

    /**
     * Restocks the cafe's inventory.
     * @param nCoffeeOunces ounces of coffee to add
     * @param nSugarPackets sugar packets to add
     * @param nCreams cream splashes to add
     * @param nCups cups to add
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Restocked inventory!");
    }

    /**
     * Main method to test creating a Cafe.
     */
    public static void main(String[] args) {
        Cafe cafe = new Cafe("Campus Cafe", "1 Main Street", 1, 50, 30, 20, 10);
        cafe.sellCoffee(12, 2, 2);
    }

    public Cafe(String name, String address) {
        this(name, address, 1, 100, 50, 50, 20);
    }
}
