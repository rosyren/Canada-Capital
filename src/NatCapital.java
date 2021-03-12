import javax.swing.ImageIcon;

/**
 * This class extends the City class and represents the National Capital
 * @author Rosy Ren (251080052) CS 1027
 */

public class NatCapital extends City{
	
	/**
	 *Constructor creates a city (national capital) with the given parameters  
	 * @param name
	 * @param population
	 * @param x
	 * @param y
	 */
	
	public NatCapital(String name, int population, int x, int y) {
		// calls the parent class City's constructor with parameter name, population, x, y
		super(name, population, x, y);
		// creates a new ImageIcon object with the national marker and sets it 
		ImageIcon newMarker = new ImageIcon ("marker_nat.png");
		this.setMarker(newMarker);
	}
	
	/**
	 * Accessor method to get the name of the city in a String representation
	 * @return string format of the "city (Canada's Capital)" 
	 */
	
	public String toString() {
		return getName() + " (Canada's capital)"; 
	}
	
}
