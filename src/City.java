import javax.swing.ImageIcon;

/**
* This class represents a city. Each city has its own unique name, population, x and y coordinate
* @Author Rosy Ren (251080052) CS 1027
*/

public class City {
	
	/**
	 * declaring name of the city 
	 * population of the city 
	 * x, y, coordinates of the city 
	 * visual marker for the city
	 */
	
	private String name;
	private int population;
	private int x, y;
	private ImageIcon marker; 
	
	/**
	 * constructor creates a City with the given parameters 
	 * @param name
	 * @param population
	 * @param x
	 * @param y
	 */
	
	public City(String name, int population, int x, int y) {
		// assigns the parameter name to the variable name
		this.name = name;
		// assigns the parameter population to the variable population
		this.population = population;
		// assigns the parameter coordinate x to the variable x
		this.x = x;
		// assigns the parameter coordinate y to the variable y
		this.y = y;
		// assigns a new ImageIcon for the city
		marker = new ImageIcon("marker_city.png");
	}
	
	/**
	 * Accessor method to get the name of the city 
	 * @return name of the city
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * Accessor method to get the population of the city 
	 * @return population of the city
	 */
	
	public int getPopulation() {
		return population;
	}
	
	/**
	 * Accessor method to get the x coordinate of the city 
	 * @return coordinate X
	 */
	
	public int getX() {
		return x;
	}
	
	/**
	 * Accessor method to get the y coordinate of the city 
	 * @return coordinate Y
	 */
	
	public int getY() {
		return y;
	}
	
	/**
	 * Accessor method to get the visual marker of the city 
	 * @return visual marker
	 */
	
	public ImageIcon getMarker() {
		return marker;
	}
	
	/**
	 * sets the name of the city 
	 * @param newName	takes in new name parameter
	 */
	
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * sets the population of the city
	 * @param newPopulation		takes in new population parameter
	 */
	
	public void setPopulation(int newPopulation) {
		population = newPopulation;
	}
	
	/**
	 * sets the visual marker of the city
	 * @param newMarker		takes in new marker parameter
	 */
	
	public void setMarker(ImageIcon newMarker) {
		marker = newMarker;
	}
	
	/**
	 * checks if cities are the same by checking the distance between x and y coordinates of both cities 
	 * @param other
	 * @return boolean false or true 
	 */
	
	public boolean equals(City other) {
		if ((Math.abs(this.x - other.x)<=5) && (Math.abs(this.y - other.y)<=5) ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Accessor method to get the name of the city in String representation
	 * @return name in string format 
	 */
	
	public String toString() {
		 return this.name;
	}
	
}
