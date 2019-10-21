package animalparser;

public class AquaticBird extends Animal {
    public AquaticBird(int year, String name, String subtype) {
        super(year, name, subtype);
        num_of_legs = 2;
        isSwimmer = true;
    }
}
