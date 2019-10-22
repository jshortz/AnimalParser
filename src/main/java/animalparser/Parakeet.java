/**
 * Holds Animal of subtype Parakeet
 *
 * @author Jessica Shortz
 * @version 2019.10.21
 */

package animalparser;

public class Parakeet extends Animal {
    public Parakeet(int year, String name, String subtype) {
        super(year, name, subtype);
        num_of_legs = 2;
    }
}
