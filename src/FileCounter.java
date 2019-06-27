import java.util.Scanner;

/**
   A class to count the number characters, words, and lines in an
   input source.
*/
public class FileCounter
{
   private int chars;
   private int words;
   private int lines;

   /**
      Construct a FileCounter object.
   */
   public FileCounter()
   {
      chars = 0;
      words = 0;
      lines = 0;
   }

   /**
      Processes an input source and adds its character, word, and line
      counts to this counter.
      @param in the scanner to process
   */
   public void read(Scanner in)
   {
      while (in.hasNextLine())
      {
         String line = in.nextLine();
         lines++;
         chars += line.length() + 1;

         Scanner lineIn = new Scanner(line);
         while (lineIn.hasNext()) { lineIn.next(); words++; }
      }
   }

   /**
      Gets the number of words in this counter.
      @return the number of words
   */
   public int getWordCount()
   {
      return words;
   }

   /**
      Gets the number of lines in this counter.
      @return the number of lines
   */
   public int getLineCount()
   {
      return lines;
   }

   /**
      Gets the number of characters in this counter.
      @return the number of characters
   */
   public int getCharacterCount()
   {
      return chars;
   }
}
