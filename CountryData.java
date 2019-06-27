import java.io.*;
import java.util.*;

public class CountryData {
	private ArrayList<Country> countries = new ArrayList<Country>();
	
	/**
	 * given a string s and a character c
	 * return the substring of s between the first two locations
	 * of character c.
	 * @param s
	 * @param c
	 * @return
	 */
	private String findSubstringBetweenFirstTwoLocations(String s, String c) {
		int index1 = s.indexOf(c);
		String remainingString = s.substring(index1 + 1);
		return remainingString.substring(0, remainingString.indexOf(c));
	}
	
	public long computeTotalPop() {
		long total = 0;
		for (Country country : countries) {
			total += country.getPopulation();
		}
		return total;
	}
	
	
	public CountryData(String countryDataFileName) {
		File f = new File(countryDataFileName);
		Scanner scanner;
		try {
			scanner = new Scanner(f);
			while(scanner.hasNextLine()) {
				String row = scanner.nextLine();
				System.out.println(row);
				String countryName = findSubstringBetweenFirstTwoLocations(row, ",");
				String pop = findSubstringBetweenFirstTwoLocations(row, "\"");
				pop = pop.replace(",", "");
				Country country = new Country(countryName, Integer.parseInt(pop));
				countries.add(country);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		CountryData cd = new CountryData("population.csv");
		long totalPop = cd.computeTotalPop();
		long indoChina = (long)cd.countries.get(0).getPopulation() + (long)cd.countries.get(1).getPopulation();
		System.out.println(indoChina);
		System.out.println(totalPop);
		System.out.println(indoChina * 1.0 / totalPop);
	}
}
