/**
 * Class that creates an application shell that runs the functionalities of the program
 *
 * @author  Jessica Shortz
 * @version 2019.10.21
 */

package animalparser;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class AppShell {

    public static int getNumberOfLinesInFile(String filename) throws FileNotFoundException {
        int counter = 0;
        Scanner scanner1 = new Scanner(new File(filename));
        while(scanner1.hasNextLine() && scanner1.nextLine() != "") {
            counter++;
        }
        return counter;
    }

}
