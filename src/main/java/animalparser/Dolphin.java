/**
 * Holds Animal of subtype Dolphin
 *
 * @author Jessica Shortz
 * @version 2019.10.21
 */

package animalparser;

public class Dolphin extends Animal implements Swimmer {

    public Dolphin(int year, String name, String subtype) {
        super(year, name, subtype);
        isSwimmer = true;
        num_of_legs = 0;
    }
}
