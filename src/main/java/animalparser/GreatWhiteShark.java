/**
 * Holds Animal of subtype Great White Shark
 *
 * @author Jessica Shortz
 * @version 2019.10.21
 */

package animalparser;

public class GreatWhiteShark extends Animal implements Swimmer {
    public GreatWhiteShark(int year, String name, String subtype) {
        super(year, name, subtype);
        num_of_legs = 0;
        isSwimmer = true;
    }
}
