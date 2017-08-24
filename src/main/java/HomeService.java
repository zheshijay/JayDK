
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
* HomeService class
* 
* 
* @author  Jay Shi
* @version 1.0
* @since   2017-05-12 
*/
public class HomeService {

	static List<Home> sort(List<Home> homes, String sortField, boolean ascending, int limit){
		Class<?> clazz;
		try {
			clazz = Class.forName("zillow.Home$" + sortField + "Comparator");
			Class[] parameter = new Class[1];
			parameter[0] = boolean.class;
			Object args[] = new Object[] { ascending };
			Constructor constructor = clazz.getConstructor(parameter);
			Comparator<Home> comparator =(Comparator<Home>) constructor.newInstance(args);
			Collections.sort(homes, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return homes.subList(0, limit);
	}

	public void printHomes(List<Home> sortedHomes ){
		for(Home eachHome: sortedHomes){
			System.out.print(
					" City: " + eachHome.getCity() 
					+ " | Unit: " + eachHome.getUnit()
					+ " | State: " + eachHome.getState()
					+ " | Price: " + eachHome.getPrice()
					+ " | Zip: " + eachHome.getZip()
					+ " | DateLastRented: " + eachHome.getDateLastRented() 
					+ "\n"
					);
		}
	}
	
	public List<Home> getHomesFromDB(){
		Home home1 = new Home();
		Home home2 = new Home();
		Home home3 = new Home();

		home1.setCity("San Francisco");
		home1.setDateLastRented(Util.getLastRenteDate(2017, 1, 10));
		home1.setPrice(3000d);
		home1.setState("CA");
		home1.setStreet("Mission Street");
		home1.setUnit("unit#1");
		home1.setZip(95111);

		home2.setCity("New York");
		home2.setDateLastRented(Util.getLastRenteDate(2016, 5, 20));
		home2.setPrice(2200d);
		home2.setState("NY ");
		home2.setStreet("5th Avenue");
		home2.setUnit("unit#2");
		home2.setZip(10011);

		home3.setCity("Seattle ");
		home3.setDateLastRented(Util.getLastRenteDate(2005, 5, 20));
		home3.setPrice(2800d);
		home3.setState("WA");
		home3.setStreet("Second Avenue");
		home3.setUnit("unit#3");
		home3.setZip(98101);

		List<Home> homes = new ArrayList<>();
		homes.add(home1);
		homes.add(home2);
		homes.add(home3);
		
		return homes;
		
	}
	

	public static void main(String[] args){
		HomeService test = new HomeService();
		
		List<Home> homes = test.getHomesFromDB();
		
		List<Home> sortedHomes = null;
		System.out.println("1.1 Sort by city asc");
		sortedHomes = test.sort(homes, "City", true, 2);
		test.printHomes(sortedHomes);
		
		System.out.println("1.2. Sort by city desc");
		sortedHomes = test.sort(homes, "City", false, 2);
		test.printHomes(sortedHomes);
		
		System.out.println("2.1 Sort by State asc");
		sortedHomes = test.sort(homes, "State", true, 3);
		test.printHomes(sortedHomes);
		
		System.out.println("2.2 Sort by State desc");
		sortedHomes = test.sort(homes, "State", false, 3);
		test.printHomes(sortedHomes);
		
		System.out.println("3.1 Sort by Zip asc ");
		sortedHomes = test.sort(homes, "Zip", true, 3);
		test.printHomes(sortedHomes);
		
		System.out.println("3.2 Sort by Zip desc ");
		sortedHomes = test.sort(homes, "Zip", false, 3);
		test.printHomes(sortedHomes);
		
		System.out.println("4.1 Sort by Price asc");
		sortedHomes = test.sort(homes, "Price", true, 3);
		test.printHomes(sortedHomes);
		
		System.out.println("4.2 Sort by Price desc");
		sortedHomes = test.sort(homes, "Price", false, 3);
		test.printHomes(sortedHomes);
		
		System.out.println("5.1 Sort by DateLastRented asc");
		sortedHomes = test.sort(homes, "DateLastRented", true, 3);
		test.printHomes(sortedHomes);
		
		System.out.println("5.2 Sort by DateLastRented desc");
		sortedHomes = test.sort(homes, "DateLastRented", false, 3);
		test.printHomes(sortedHomes);
		
		System.out.println("6.1 Sort by Unit asc");
		sortedHomes = test.sort(homes, "Unit", true, 3);
		test.printHomes(sortedHomes);

		System.out.println("6.2 Sort by Unit desc desc");
		sortedHomes = test.sort(homes, "Unit", false, 3);
		test.printHomes(sortedHomes);
	}

}
