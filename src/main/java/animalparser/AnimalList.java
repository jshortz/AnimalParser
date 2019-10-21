package animalparser;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AnimalList {

    protected ArrayList<Animal> animalList;
    protected ArrayList<Animal> allAnimals;
    protected ArrayList<Animal> swimmers;

    public AnimalList() throws FileNotFoundException {
        animalList = new ArrayList<>();
        allAnimals = createListOfAllAnimals();
        swimmers = collectSwimmers();
    }

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

    public ArrayList getAnimalsWithAtLeastXLegs(int xLegs) throws FileNotFoundException {
        ArrayList<Animal> legsList = createListOfAllAnimals();
        legsList.removeIf(animal -> (animal.num_of_legs < xLegs));
        return legsList;
    }

    public ArrayList collectSwimmers() throws FileNotFoundException {
        swimmers = createListOfAllAnimals();
        swimmers.removeIf(animal -> (!animal.isSwimmer));
        swimmers.sort(Comparator.comparing(Animal::getYear));
        return swimmers;
    }

    public void printSwimmersToCSV() throws IOException {
        BufferedWriter outputToFile = new BufferedWriter(new FileWriter("swimmers.csv", true));
        for (Animal animal : swimmers) {
            outputToFile.append(animal.subtype + "," + animal.name + "," + animal.year + "\n");
        }
        outputToFile.close();
    }

    public static void main(String[] args) throws IOException {
        AnimalList animalList = new AnimalList();
        animalList.printAllAnimals(animalList.allAnimals);
        animalList.printSwimmersToCSV();
    }
}
