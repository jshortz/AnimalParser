package animalparser;

public class GreatWhiteShark extends Animal implements Swimmer {
    public GreatWhiteShark(int year, String name, String subtype) {
        super(year, name, subtype);
        num_of_legs = 0;
        isSwimmer = true;
    }
}
