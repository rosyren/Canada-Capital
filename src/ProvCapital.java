import javax.swing.ImageIcon;

/**
* This class extends the City class and represents the Provincial Capital
* @Author Rosy Ren (251080052) CS 1027
*/

public class ProvCapital extends City{
	/**
	 * province name of each province capital 
	 */
	private String province;
	/**
	* Constructor creates a city (provincial capital) with the given parameters  
 	* @param name
 	* @param population
 	* @param x
 	* @param y
 	* @param province
 	*/
	public ProvCapital(String name, int population, int x, int y, String province){
		//calls the parent class City's constructor with name, population, x, y
		super(name, population, x, y);
		// assigning the value of parameter province to province
		this.province = province;
		// creates a new ImageIcon object with the provincial marker and sets it 
		ImageIcon newMarker = new ImageIcon ("marker_prov.png");
		this.setMarker(newMarker);
		
	}
	
	/**
	 * Accessor method to get the name of the city and its province in a String representation
	 * @return string format of the "city (province)" 
	 */
	
	public String toString() {
		return getName() + " (" + this.province + ")";
	}

	
}