import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OccupationData {
    ArrayList<Occupation> list = new ArrayList<>();

    public OccupationData(String filename){
        File f = new File (filename);
        Scanner sc;
        try{
            sc = new Scanner(f);
            while(sc.hasNextLine()){
                String row = sc.nextLine(); //Chief executives,11-1011,Line item,308.9,296.8,0.2,0.2,-12.1,-3.9,20.0
                String title = row.substring(0, row.indexOf(",")); //Chief executives
                String placeholder1 = substringComma(row, ","); //11-1011
                String placeholder2 = substringComma(placeholder1, ","); //Line item
                String data2016 = substringComma(placeholder2, ","); //308.9
                String data2026 = substringComma(data2016, ","); //296.8
                Occupation temp = new Occupation (title, Double.parseDouble(data2016), Double.parseDouble(data2026));
                list.add(temp);
            }


        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public String substringComma(String s, String c) {
    	int indexOfComma = s.indexOf(c);
    	String remainingString = s.substring(indexOfComma + 1);
    	return remainingString.substring(0, remainingString.indexOf(c));
    }
    
   
    public static void main (String[] args) {
    	OccupationData data = new OccupationData("occupation.csv");
    	ArrayList<Occupation> dataList = new ArrayList<Occupation>();
    	double num2016 = 0;
    	double num2026 = 0;
    	double delta = -100.0;
    	String jobMostIncrease = "";
    	for(int i = 0; i < dataList.size(); i++){
    		num2016 = dataList.get(i).getNum2016();
    		num2026 = dataList.get(i).getNum2026();
    		double deltatemp = num2026 - num2016;
    		if(deltatemp > delta) {
    			delta = deltatemp;
    			jobMostIncrease = dataList.get(i).getTitle();
    			
    		}
    	}
    	
    	System.out.println("Most increase job is " + jobMostIncrease);
    	System.out.println("Job increase from 2016 to 2026 is " + delta);
    	
    	
    }
    
 
}
