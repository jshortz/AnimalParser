package animalparser;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class AnimalListTests {

    @Test
    public void testCreateListOfAllAnimals() throws FileNotFoundException {
        boolean allSubtypes = false;
        boolean allNames = false;
        AnimalList animalList = new AnimalList();
        ArrayList<Animal> listToCheck = animalList.createListOfAllAnimals();
        int sizeOfList = listToCheck.size();

        ArrayList<String> subtypesList = new ArrayList<>();
        for (Animal animal : listToCheck) {
            subtypesList.add(animal.subtype);
        }
        if (subtypesList.contains("golden retriever") && subtypesList.contains("dolphin") && subtypesList.contains("duck")
        && subtypesList.contains("chicken") && subtypesList.contains("arabian horse") && subtypesList.contains("great white shark")
        && subtypesList.contains("parakeet") && !subtypesList.contains("bengal cat") && !subtypesList.contains("german shepherd")) {
            allSubtypes = true;
        }

        ArrayList<String> namesList = new ArrayList<>();
        for (Animal animal : listToCheck) {
            namesList.add(animal.name);
        }
        if (namesList.contains("lucy") && namesList.contains("winter") && namesList.contains("donald")
                && namesList.contains("johnny") && namesList.contains("blueskin") && namesList.contains("jaws")
                && namesList.contains("cleo") && !namesList.contains("billy") && !namesList.contains("apollo")) {
            allNames = true;
        }

        assertEquals(7, sizeOfList);
        assertEquals(true, allSubtypes);
        assertEquals(true, allNames);
    }

    @Test
    public void testGetAnimalsWithXLegs() throws FileNotFoundException {
        AnimalList animalList = new AnimalList();

        ArrayList<Animal> listToCheckZeroLegs = animalList.getAnimalsWithAtLeastXLegs(0);
        int listToCheckZeroLegsSize = listToCheckZeroLegs.size();

        ArrayList<Animal> listToCheckTwoLegs = animalList.getAnimalsWithAtLeastXLegs(2);
        int listToCheckTwoLegsSize = listToCheckTwoLegs.size();

        ArrayList<Animal> listToCheckFourLegs = animalList.getAnimalsWithAtLeastXLegs(4);
        int listToCheckFourLegsSize = listToCheckFourLegs.size();

        ArrayList<String> animalNames = new ArrayList<>();
        for (Animal animal : listToCheckFourLegs) {
            animalNames.add(animal.name);
        }
        boolean listContainsLucy = (animalNames.contains("lucy"));
        boolean listContainsBlueskin = (animalNames.contains("blueskin"));

        assertEquals(7, listToCheckZeroLegsSize);
        assertEquals(5, listToCheckTwoLegsSize);
        assertEquals(2, listToCheckFourLegsSize);
         assertEquals(true, listContainsLucy);
         assertEquals(true, listContainsBlueskin);
    }

    @Test
    public void testCollectSwimmers() throws FileNotFoundException {
        AnimalList animalList = new AnimalList();
        boolean legs = true;
        boolean swims = true;

        ArrayList<Animal> checkSwimmersList = animalList.swimmers;
        int listSize = checkSwimmersList.size();

        for (Animal swimmer : checkSwimmersList) {
            if (swimmer.num_of_legs == 4) {
                legs = false;
            }
            if (swimmer.num_of_legs == 2 && !swimmer.isSwimmer) {
                legs = false;
            }
        }

        for (Animal swimmer : checkSwimmersList) {
            if (!swimmer.isSwimmer) {
                swims = false;
            }
        }

        assertEquals(3, listSize);
        assertEquals(true, legs);
        assertEquals(true, swims);
    }

}
