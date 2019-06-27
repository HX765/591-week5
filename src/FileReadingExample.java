import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReadingExample {
    public static void main(String[] args) {
        //File myFile = new File("C:\\Users\\NJ288XG\\Desktop\\Upenn\\591\\Week 5 codes\\sampleFile");
        File myFile = new File("C:\\Users\\NJ288XG\\Desktop\\Upenn\\591\\Week 5 codes\\testScore");
        ArrayList<Double> scores = new ArrayList<Double>();

        try {
            Scanner s = new Scanner(myFile);
            //int count = 0;
            //String s1 = s.nextLine();
            while (s.hasNext()) {
                //String temp = s.next();
                //count++;
                String score = s.nextLine();
                if(isNumeric(score)){
                    double scoreAsDouble = Double.parseDouble(score);
                    scores.add(scoreAsDouble);
                }
            }
            double summation = 0;
            for ( Double double1 : scores ) {
                summation += double1;
            }
            double average = summation / scores.size();

            double summation2 = 0;
            for ( Double double1 : scores ) {
                double temp = Math.pow((double1 - average), 2);
                summation2 += temp;
            }

            double stdDiv = Math.sqrt(summation2 / scores.size());

            try {
                FileWriter fw = new FileWriter("testScore", true);
                PrintWriter pw = new PrintWriter(fw);
                //pw.println("The average is " + average);
                pw.println("The standard division is " + stdDiv);
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }


            //System.out.println("The number of words is " + count);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean isNumeric (String s){
        try{
            Double.parseDouble(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
