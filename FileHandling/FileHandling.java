// Import io.file for handling files
import java.io.File;
 // Import this class to handle errors
import java.io.FileNotFoundException;
// Import the Scanner class to read text files
import java.util.Scanner;

public class FileHandling{

 /*** Main ***/
 public static void main(String[] Args){

    // Take first argumente as filename to read
    String Filename = Args[0];

    // And log it
    System.out.println(Filename);

    // Stream in Java? It's a sequence of data (Two types of data).
    // 1. Byte Stream
    // 2. Character Stream
    // In this script, we are working with Char Streams

    try{
      // Create Object to File
      File fp = new File(Filename);

      // If file is readable, read and print each line
      if(fp.canRead()){
        // Log that it's readable
        System.out.println("It's readable, bro!");

        // Create a scanner to read files
        Scanner reader = new Scanner(fp);

        // Read file until its end
        while(reader.hasNextLine()){
          // Get line
          String Line = reader.nextLine();
          // Log line
          System.out.println(Line);
        }

        // CLoser Scanner
        reader.close();

      }

    }catch(FileNotFoundException error){
      System.out.println("File doesn't exist");

    }



 }

}
