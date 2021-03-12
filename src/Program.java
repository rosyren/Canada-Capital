
/**
 * this class is the entry point, it reads the files, returns the array
 * find cities within a parameter, and produces a list of population calculations 
 * @author Rosy Ren (251080052) CS 1027
 */

public class Program {
	
	/**
	 * declaring an array of type City called cityArray
	 */
	
	private static City[] cityArray;

	/**
	 * Constructor that reads the given file and collects each object into an array
	 * @param showMap
	 */
	public Program(boolean showMap){
		
		// initializes the array with 5 slots 
		cityArray = new City[5];

		// creates a file reader for cities.txt
		MyFileReader reader = new MyFileReader("cities.txt");
		
		// skips the header first line
		reader.readString();
		
		int index = 0;
		
		// as long as there is more lines in the file, this loop will run
		while (!reader.endOfFile()) {
			
			// this reads each line into a variable in the order of name, population, x, y, and type
			String name = reader.readString();
			int pop = reader.readInt();
			int x = reader.readInt();
			int y = reader.readInt();
			String type = reader.readString();
			
			// this calls the expand capacity method if there is no more space in the cityArray	
			if (cityArray.length == index) {
				expandCapacity();
			}
			
			/* if the city is type provincial capital as read by the filereader, it will create a new ProvCapital object
			 * which contains the parameter of province which needs to be stored in the object 
			*/
			if (type.equals("prov_cap")) {
					String province = reader.readString();
					ProvCapital newProvCapital = new ProvCapital(name, pop, x, y, province);
					// places the new provcapital object into the cityArray
					cityArray[index] = newProvCapital;
					index++;
			/*
			 * if the city is type national capital as read, it will create a new NatCapital object 
			 * which will be stored as an object in the cityArray
			 */
			
			} else if (type.equals("nat_cap")) {
				NatCapital newNatCapital = new NatCapital(name, pop, x, y);
				// stores the new NatCapital object into the cityArray
				cityArray[index] = newNatCapital;
				index++;
				
			/*
			 * if it is just a regular city, it will create a City object and store it within the array
			 */
			} else if (type.equals("city")){
				City newCity = new City(name, pop, x, y);
				cityArray[index] = newCity;
				index++;
		}
			/*
			 * if showMap is true, it will run the program with a visual component 
			 */
			
			if (showMap) {

				Map newMap = new Map();

				// add city for each city in the array
				for (City city : cityArray) {
					// catches the null pointer exception within the array
					if(city!=null){
					newMap.addCity(city);
				
				
				// calls the defaultext method within the map class
				newMap.defaultText();

			}
			}
			}
		}
			
		}

	/**
	 * Accessor method that returns the cityArray
	 * @return cityArray
	 */
	
	public City[] getCityList() {
		return cityArray;
	}
	
	/**
	 * expands the capacity of the cityArray by creating a newArray with 5 extra slots 
	 * then copying everything from newArray and pointing it back to old array
	 */
	
	private void expandCapacity() {
		// creates a new array of a bigger size
		City[] newCityArray = new City[5+cityArray.length];
		for (int i = 0; i < cityArray.length; i++) {
			// copying everything over
			newCityArray[i] = cityArray[i];
		}
		// pointing back to old array
		cityArray = newCityArray;
		
	}
	/**
	 * this method takes in 4 coordinates and collects all of the cities within the parameter into an array 
	 * @param sx
	 * @param sy
	 * @param ex
	 * @param ey
	 * @return a City type array of all the cities within the selected parameter
	 */
	
	public static City[] findCitiesInRect(int sx, int sy, int ex, int ey) {
		City[]rectCities = new City[10];
		int index = 0;
		
		// loops through the entire cityArray to linear search for cities that fall within those parameters 
		for (int i = 0; i < cityArray.length; i++) {
			// try catch for null pointer exceptions within the cityArray
			try {
				
				/*
				 *  the if and else if loops through the 4 possibilities of how the cities can fall
				 *  within the boundaries depending on how the parameters are drawn  
				 */
				
				if ((sx <= cityArray[i].getX()) && (cityArray[i].getX() <= ex) 
					&& (sy <= cityArray[i].getY()) && (cityArray[i].getY() <= ey)){
				rectCities[index] = cityArray[i];
				index++;
				
			} else if ((sx >= cityArray[i].getX()) && (cityArray[i].getX() >= ex) 
					&& (sy <= cityArray[i].getY() && (cityArray[i].getY() <= ey))) {
				rectCities[index] = cityArray[i];
				index++;
				
			} else if ((sx >= cityArray[i].getX()) && (cityArray[i].getX() >= ex) 
					&& (sy >= cityArray[i].getY() && (cityArray[i].getY() >= ey))) {
				rectCities[index] = cityArray[i];
				index++;
				
			} else if ((sx <= cityArray[i].getX()) && (cityArray[i].getX() <= ex) 
					&& (sy >= cityArray[i].getY() && (cityArray[i].getY() >= ey))) {
				rectCities[index] = cityArray[i];
				index++;
			}
		}
			/*
			 *  this is set to catch null pointer in case there are null spots in cityArray
			 *  it skips it and keeps going
			 */
			catch(NullPointerException e) {
				index++;
			}
	
		}
		// returns the new type City array of cities with the rectangle 
		return rectCities;
		
	}
	
	/**
	 * this will loop through 
	 * @return an array of type Object containing all of the population calculations 
	 * for capitals and non capitals
	 */
	public static Object [] defaultTextboxInfo() {
		// sets all of the values to 0 or null in order for new values to take it's place as we search through
		// this is the sum of all capital and national capital cities populations
		double sum = 0.0;
		// this is how many of those cities there are 
		double num = 0.0;
		int min = 100000000;
		int max = 0;
		City maxCity = null;
		City minCity = null;
		// creating an array of type object to hold all the values
		Object[] cityCalc = new Object[10];

		// loops through the cityArray
		for (int i = 0; i < cityArray.length; i++) {
			// this will catch the null pointer exception, so as long as it is not null, the rest will run
			if (cityArray[i]!=null) {
				// if the object is either of provcapital or natcapital 
				if ((cityArray[i] instanceof ProvCapital)|| (cityArray[i] instanceof NatCapital)) {
					// we increase the number of provcap and natcap cities by one
					num++;
					// we add their population to the sum
					sum = sum + cityArray[i].getPopulation();
					// if they're bigger than the max, we set the new max to the new city's population
					if (cityArray[i].getPopulation() > max) {
					max = cityArray[i].getPopulation();
					// we set the object equal to maxCity, this is used later to obtain the name of the city with the max population
					maxCity = cityArray[i];
					}
				
				if (cityArray[i].getPopulation() < min) {
					// if they're smaller than the min, we set the new min to the new city's population
					min = cityArray[i].getPopulation();
					// we set the object equal to minCity, this is used later to obtain the name of the city with the min population
					minCity = cityArray[i];
				}
				
			}				
		}

		}
		// this calculates the average of all provcap and natcap cities' populations
		double cityAverage = Double.valueOf(sum / num);
		
		// this inputs each number into the array 
		cityCalc[0] = cityAverage;	
		cityCalc[1] = min;
		cityCalc[2] = minCity;
		cityCalc[3] = max;
		cityCalc[4] = maxCity;
		
		// the process is then repeated again for noncap cities
		double newSum = 0.0;
		double newNum = 0.0;
		int newMin = 100000000;
		int newMax = 0;
		City maxNewCity = null;
		City minNewCity = null;
	
		// this searches through the cityArray
		for (int i = 0; i < cityArray.length; i++) {
			// this catches the null pointer exception when searching through
			if (cityArray[i]!=null) {
				// this searches for non provcap and non natcap cities 
				if (!(cityArray[i] instanceof ProvCapital) && !(cityArray[i] instanceof NatCapital)) {
				// add 1 to the the number of non capcities 
				newNum++;
				//add the population to the sum 
				newSum = newSum + cityArray[i].getPopulation();
				// if they're bigger than the max, we set the new max to the new city's population
				if (cityArray[i].getPopulation() > newMax) {
					newMax = cityArray[i].getPopulation();
					// we set the object equal to maxNewCity, this is used later to obtain the name of the city with the max population
					maxNewCity= cityArray[i];
				}
				// if they're smaller than the min, we set the new min to the new city's population
				if (cityArray[i].getPopulation() < newMin) {
					newMin = cityArray[i].getPopulation();
					// we set the object equal to minNewCity, this is used later to obtain the name of the city with the min population
					minNewCity = cityArray[i];
				}
			}
		}
	}
		// this calculates the average of all non provcap and non natcap cities' populations
		double newAverage = Double.valueOf(newSum / newNum);
		
		// this inputs each number into the array 
		cityCalc[5] = newAverage; 
		cityCalc[6] = newMin;
		cityCalc[7] = minNewCity;
		cityCalc[8] = newMax;
		cityCalc[9] = maxNewCity;
	
	// lastly, this will return the array filled with the new population calculations 
	return cityCalc;
	
	
}

	
}
