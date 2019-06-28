import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OccupationData {
    ArrayList<Occupation> list = new ArrayList<>();
    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';

    public OccupationData(String filename){
        File f = new File (filename);
        Scanner sc;
        try{
            sc = new Scanner(f);
            while(sc.hasNextLine()){
                List<String> line = parseLine(sc.nextLine()); //Chief executives,308.9,296.8,0.2,0.2,-12.1,-3.9,20.0
            	String title = line.get(0); //Chief executives
                String data2016 = line.get(1); //308.9               
                String data2026 = line.get(2); //296.8                
                Occupation job = new Occupation (title, Double.parseDouble(data2016), Double.parseDouble(data2026));
                list.add(job);
            }


        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
    
    public static List<String> parseLine(String cvsLine) {
        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String cvsLine, char separators) {
        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String cvsLine, char separators, char customQuote) {

        List<String> result = new ArrayList<>();

        //if empty, return!
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        }

        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = cvsLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }

                }
            } else {
                if (ch == customQuote) {

                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    //double quotes in column will hit this!
                    if (startCollectChar) {
                        curVal.append('"');
                    }

                } else if (ch == separators) {

                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;

                } else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }

        }

        result.add(curVal.toString());

        return result;
    }

    
    
    public static void main(String[] args) {
    	
    	OccupationData data = new OccupationData("Occupation.txt");
    	ArrayList<Occupation> dataList = data.list;
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
