/**
 * Holds Animal of subtype Chicken
 *
 * @author Jessica Shortz
 * @version 2019.10.21
 */

package animalparser;

public class Chicken extends Animal {
    public Chicken(int year, String name, String subtype) {
        super(year, name, subtype);
        num_of_legs = 2;
    }
}
