package animalparser;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AnimalListTests {

    @Test
    public void testCreateListOfAllAnimals() throws FileNotFoundException {
        boolean allSubtypes = false;
        boolean allNames = false;
        AnimalList animalList = new AnimalList();
        ArrayList<Animal> listToCheck = animalList.createListOfAllAnimals();
        int sizeOfList = listToCheck.size();
        if (listToCheck.contains("golden retriever") && listToCheck.contains("dolphin") && listToCheck.contains("duck")
        && listToCheck.contains("chicken") && listToCheck.contains("arabian horse") && listToCheck.contains("great white shark")
        && listToCheck.contains("parakeet") && !listToCheck.contains("bengal cat") && !listToCheck.contains("german shepherd")) {
            allSubtypes = true;
        }
        if (listToCheck.contains("lucy") && listToCheck.contains("winter") && listToCheck.contains("donald")
                && listToCheck.contains("johnny") && listToCheck.contains("blueskin") && listToCheck.contains("jaws")
                && listToCheck.contains("cleo") && !listToCheck.contains("billy") && !listToCheck.contains("apollo")) {
            allNames = true;
        }

        assertEquals(7, sizeOfList);
        // assertEquals(true, allSubtypes);
        // assertEquals(true, allNames);
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
        boolean listContainsLucy = (listToCheckFourLegs.contains("lucy"));
        boolean listContainsBlueskin = (listToCheckFourLegs.contains("blueskin"));

        assertEquals(7, listToCheckZeroLegsSize);
        assertEquals(5, listToCheckTwoLegsSize);
        assertEquals(2, listToCheckFourLegsSize);
        // assertEquals(true, listContainsLucy);
        // assertEquals(true, listContainsBlueskin);
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
