

import java.util.Comparator;
import java.util.Date;

/**
* Home class
*
* @author  Jay Shi
* @version 1.0
* @since   2017-05-12 
*/
public class Home implements Comparable<Home>{
	String street;

	String unit;

	String city;

	String state;

	Integer zip;

	Date dateLastRented;

	Double price;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public Date getDateLastRented() {
		return dateLastRented;
	}

	public void setDateLastRented(Date dateLastRented) {
		this.dateLastRented = dateLastRented;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int compareTo(Home o) {
		return this.city.compareTo(o.city);
	}

	public static final class CityComparator implements Comparator<Home>{
		boolean asc = true;
		
		public CityComparator(boolean asc){
			this.asc = asc;
		}
		
		@Override
		public int compare(Home home1, Home home2) {
			if(asc) return home1.getCity().compareTo(home2.getCity());
			return home2.getCity().compareTo(home1.getCity());
		}
	}

	public static final class StateComparator implements Comparator<Home>{
		boolean asc = true;

		public StateComparator(boolean asc){
			this.asc = asc;
		}

		@Override
		public int compare(Home home1, Home home2) {
			if(asc)	return home1.getState().compareTo(home2.getState());
			return home2.getState().compareTo(home1.getState());
		}
	}


	public static final class PriceComparator implements Comparator<Home>{
		boolean asc = true;

		public PriceComparator(boolean asc){
			this.asc = asc;
		}
		
		@Override
		public int compare(Home home1, Home home2) {
			if(asc)	return (int) (home1.getPrice() - home2.getPrice());
			return (int) (home2.getPrice() - home1.getPrice());
		}
	}


	public static final class StreetComparator implements Comparator<Home>{
		boolean asc = true;

		public StreetComparator(boolean asc){
			this.asc = asc;
		}
		
		@Override
		public int compare(Home home1, Home home2) {
			if(asc) return home1.getStreet().compareTo(home2.getStreet()); 
			return home2.getStreet().compareTo(home1.getStreet());
		}
	}


	public static final class UnitComparator implements Comparator<Home>{
		
		boolean asc = true;

		public UnitComparator(boolean asc){
			this.asc = asc;
		}
		
		@Override
		public int compare(Home home1, Home home2) {
			if(asc) return home1.getUnit().compareTo(home2.getUnit());
			return home2.getUnit().compareTo(home1.getUnit());
		}
	}

	public static final class ZipComparator implements Comparator<Home>{
		boolean asc;

		public ZipComparator(boolean asc){
			this.asc = asc;
		}
		
		@Override
		public int compare(Home home1, Home home2) {
			if(asc) return home1.getZip() - home2.getZip();
			return home2.getZip() - home1.getZip();
		}
	}

	public static final class DateLastRentedComparator implements Comparator<Home>{
		boolean asc;

		public DateLastRentedComparator(boolean asc){
			this.asc = asc;
		}
		
		@Override
		public int compare(Home home1, Home home2) {
			// TODO Auto-generated method stub
			if(asc) return home1.getDateLastRented().compareTo(home2.getDateLastRented());
			return home2.getDateLastRented().compareTo(home1.getDateLastRented());
		}
	}


}
