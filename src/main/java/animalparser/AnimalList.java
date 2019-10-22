/**
 * Container of animal lists and getters/setters for lists
 *
 * @author Jessica Shortz
 * @version 2019.10.22
 */
package animalparser;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AnimalList {

    protected ArrayList<Animal> animalList;
    protected ArrayList<Animal> allAnimals;
    protected ArrayList<Animal> swimmers;

    /**
     * Constructor
     * @throws FileNotFoundException due to file in createListOfAllAnimals()
     */
    public AnimalList() throws FileNotFoundException {
        animalList = new ArrayList<>();
        allAnimals = createListOfAllAnimals();
        swimmers = collectSwimmers();
    }

    /**
     * Creates a list of all the animals in the file
     * Animals are stored as generic objects of appropriate child class
     * @return ArrayList holding all the animal objects
     * @throws FileNotFoundException in event that animals.csv is not found
     */
    public ArrayList createListOfAllAnimals() throws FileNotFoundException {
        AppShell appShell = new AppShell();
        ArrayList<Animal> listToReturn = new ArrayList<>();
        Scanner readFromFile = new Scanner(new File("animals.csv"));
        for (int i = 0; i < (appShell.getNumberOfLinesInFile("animals.csv")); i++) {
            String line = readFromFile.nextLine();
            Scanner readFromLine = new Scanner(line);
            readFromLine.useDelimiter(",");
            String subtype = readFromLine.next();
            String name = readFromLine.next();
            int year = 0;
            if (readFromLine.hasNextInt()) {
                year = readFromLine.nextInt();
                switch (subtype) {
                    case "german shepherd" :
                        listToReturn.add(new GermanShepherd(year, name, subtype));
                        break;
                    case "golden retriever" :
                        listToReturn.add(new GoldenRetriever(year, name, subtype));
                        break;
                    case "dolphin" :
                        listToReturn.add(new Dolphin(year, name, subtype));
                        break;
                    case "great white shark" :
                        listToReturn.add(new GreatWhiteShark(year, name, subtype));
                        break;
                    case "duck" :
                        listToReturn.add(new Duck(year, name, subtype));
                        break;
                    case "bengal cat" :
                        listToReturn.add(new BengalCat(year, name, subtype));
                        break;
                    case "arabian horse" :
                        listToReturn.add(new ArabianHorse(year, name, subtype));
                        break;
                    case "parakeet" :
                        listToReturn.add(new Parakeet(year, name, subtype));
                        break;
                    case "chicken" :
                        listToReturn.add(new Chicken(year, name, subtype));
                        break;
                }
            } else {
                System.out.println("No year given, " + name + " not added to list!");
            }
        }
        return listToReturn;
    }

    /**
     * Prints all the animals in a given ArrayList
     * @param listToPrint the ArrayList of animals to print
     */
    public void printAllAnimals(ArrayList<Animal> listToPrint) {
        listToPrint.sort(Comparator.comparing(Animal::getName));
        for (Animal animal : listToPrint) {
            System.out.println();
            System.out.println("Subtype: " + animal.subtype);
            System.out.println("Name: " + animal.name);
            System.out.println("Year: " + animal.year);
            System.out.println("Number of Legs: " + animal.num_of_legs);
            if (animal.isSwimmer) {
                System.out.println("Swims: yes");
            } else {
                System.out.println("Swims: no");
            }
            System.out.println();
        }
    }

    /**
     * Customer getter method that returns an ArrayList with all the animals with at least X legs (param X)
     * @param xLegs The minimum number of legs
     * @return ArrayList of animals with at least xLegs
     * @throws FileNotFoundException in event that animals.csv is not found
     */
    public ArrayList getAnimalsWithAtLeastXLegs(int xLegs) throws FileNotFoundException {
        ArrayList<Animal> legsList = createListOfAllAnimals();
        legsList.removeIf(animal -> (animal.num_of_legs < xLegs));
        return legsList;
    }

    /**
     * Collects all the animals with interface Swimmer
     * @return ArrayList of all Swimmer animals
     * @throws FileNotFoundException if animals.csv not found
     */
    public ArrayList collectSwimmers() throws FileNotFoundException {
        swimmers = createListOfAllAnimals();
        swimmers.removeIf(animal -> (!animal.isSwimmer));
        swimmers.sort(Comparator.comparing(Animal::getYear));
        return swimmers;
    }

    /**
     * Prints the list of swimmers to a swimmers.csv in csv format
     * @throws IOException if file unable to be written to
     */
    public void printSwimmersToCSV() throws IOException {
        BufferedWriter outputToFile = new BufferedWriter(new FileWriter("swimmers.csv", true));
        for (Animal animal : swimmers) {
            outputToFile.append(animal.subtype + "," + animal.name + "," + animal.year + "\n");
        }
        outputToFile.close();
    }

    /**
     * Main method that runs other methods
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        AnimalList animalList = new AnimalList();
        animalList.printAllAnimals(animalList.allAnimals);
        animalList.printSwimmersToCSV();
    }
}
