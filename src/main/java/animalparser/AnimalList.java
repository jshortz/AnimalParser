package animalparser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalList {

    protected ArrayList<Animal> animalList;
    protected ArrayList<Animal> allAnimals;

    public AnimalList() throws FileNotFoundException {
        animalList = new ArrayList<>();
        allAnimals = createListOfAllAnimals();
    }

    public void add(Animal animal) {
        animalList.add(animal);
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

    public void printAllAnimals() {
        for (Animal animal : allAnimals) {
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

    public static void main(String[] args) throws FileNotFoundException {
        AnimalList animalList = new AnimalList();
        animalList.printAllAnimals();
    }
}
