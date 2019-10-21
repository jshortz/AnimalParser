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
import java.util.ArrayList;

public class AppShell {

    public static int getNumberOfLinesInFile(String filename) throws FileNotFoundException {
        int counter = 0;
        Scanner scanner1 = new Scanner(new File(filename));
        while(scanner1.hasNextLine() && scanner1.nextLine() != "") {
            counter++;
        }
        System.out.println();
        System.out.println(counter);
        return counter;
    }

    public static void readFileContents(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        scanner.useDelimiter(",");
        while(scanner.hasNext() && scanner.next() != ""){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        AnimalList allAnimals = new AnimalList();
        getNumberOfLinesInFile("animals.csv");
        readFileContents("animals.csv");
    }
}
