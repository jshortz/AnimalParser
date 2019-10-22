/**
 * Creates an application shell that determines the number of lines in a given file
 *
 * @author  Jessica Shortz
 * @version 2019.10.21
 */

package animalparser;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class AppShell {

    /**
     * Takes a filename as parameter and determines the number of lines in the file
     * @param filename the file to be processed
     * @return int number of lines in the file
     * @throws FileNotFoundException
     */
    public static int getNumberOfLinesInFile(String filename) throws FileNotFoundException {
        int counter = 0;
        Scanner scanner1 = new Scanner(new File(filename));
        while(scanner1.hasNextLine() && scanner1.nextLine() != "") {
            counter++;
        }
        return counter;
    }

}
