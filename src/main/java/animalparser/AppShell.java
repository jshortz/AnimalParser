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

    private static AnimalList allAnimals;

    public static int getNumberOfLinesInFile(String filename) throws FileNotFoundException {
        int counter = 0;
        Scanner scanner1 = new Scanner(new File(filename));
        while(scanner1.hasNextLine() && scanner1.nextLine() != "") {
            counter++;
        }
        return counter;
    }

    public static void readFileContents(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();
    }

    public static void separateCSVFieldsInAnimals() throws FileNotFoundException {
        Scanner readFromFile = new Scanner(new File("animals.csv"));
        for (int i = 0; i < (getNumberOfLinesInFile("animals.csv")); i++) {
            String line = readFromFile.nextLine();
                Scanner readFromLine = new Scanner(line);
                readFromLine.useDelimiter(",");
                System.out.println("Subtype: " + readFromLine.next());
                System.out.println("Name: " + readFromLine.next());
                System.out.println("Year Born: " + readFromLine.next());
        }
    }



    public static void main(String[] args) throws FileNotFoundException {
        // getNumberOfLinesInFile("animals.csv");
        // readFileContents("animals.csv");
        // separateCSVFieldsInAnimals();
        // allAnimals.printAllAnimals();
    }
}
