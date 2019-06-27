import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Opens a file, removes any blank lines, reopens it, and prints the non-blank lines to the file.
 */
public class BlankLinesRemover {
    /**
     * Removes blank lines from the file given as argument and writes the non-blank lines
     * back to the file.
     *
     * @param fileName the name of the file to be processed.
     */
    public static void removeLines(String fileName) {
        File f = new File(fileName);

        try {
            Scanner sc = new Scanner(f);
            ArrayList<String> tempFile = new ArrayList<>();

            // read in file
            while (sc.hasNextLine()) {
                String tempLine = sc.nextLine();
                if (!tempLine.equals("")) {
                    tempFile.add(tempLine);
                }
            }

            // clear the file
            try {
                PrintWriter pw = new PrintWriter(f);
                for ( String s : tempFile ) {
                    pw.println(s);
                    pw.flush();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

