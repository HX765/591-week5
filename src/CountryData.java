import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountryData {
    private ArrayList<Country> countries = new ArrayList<Country>();

    private String findSubstringBetweenFirstTwoLocations(String s, String c) {
        int index1 = s.indexOf(c);
        String remainingString = s.substring(index1 + 1);
        return remainingString.substring(0, remainingString.indexOf(c));
    }

    public long computeTotalPop() {
        long total = 0;
        for(Country country: countries){
            total += country.getPopulation();
        }
        return total;
    }

    public CountryData(String countryDataFileName){
        File f = new File(countryDataFileName);
        Scanner scanner;
        try{
            scanner = new Scanner(f);
            while(scanner.hasNextLine()){
                String row = scanner.nextLine();
                //System.out.println(row);

                //country name is between two commas.
                String countryName = findSubstringBetweenFirstTwoLocations(row, ",");
                //population is between the first " "
                String pop = findSubstringBetweenFirstTwoLocations(row,"\"");
                //remove the commas inside a number
                pop = pop.replace(",", "");

                Country country = new Country(countryName, Integer.parseInt(pop));
                countries.add(country);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    //public ArrayList<Country>


    public static void main(String[] args) {
        CountryData data = new CountryData("population.csv");
        ArrayList<Country> countryList = data.countries;
        long popChina = 0;
        long popIndia = 0;

        for (Country c: countryList){
            if(c.getName().equals("China ")){ //can use trim() method to remove spaces at the beginning and end
                popChina = c.getPopulation();
            }
            if(c.getName().equals("India ")){
                popIndia = c.getPopulation();
            }
        }

        long indiChina = popChina + popIndia;
        long totalPop = data.computeTotalPop();

        //double average = (popChina + popIndia) * 1.0 / totalPop;
        //System.out.println(average);

        System.out.println(indiChina * 1.0 / totalPop);



    }
}
