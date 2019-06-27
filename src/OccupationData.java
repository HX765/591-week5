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
                String row = sc.nextLine();

                String title = row
            }


        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
