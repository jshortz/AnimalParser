/**
 * Parent class that defines and can stores objects of type Animal
 *
 * @author  Jessica Shortz
 * @version 2019.10.21
 */

package animalparser;

public class Animal {

    protected boolean isSwimmer;
    protected int num_of_legs;
    protected int year;
    protected String name;
    protected String subtype;

    /**
     * Constructor for Animal
     * @param year year animal was born
     * @param name name of animal
     * @param subtype subtype or breed of animal
     */
    public Animal(int year, String name, String subtype) {
        isSwimmer = false;
        num_of_legs = 4;
        this.year = year;
        this.name = name;
        this.subtype = subtype;
    }

    /**
     * Getter for animal name
     * @return String of animal name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for animal birth year
     * @return int birth year
     */
    public int getYear() {
        return year;
    }
}
