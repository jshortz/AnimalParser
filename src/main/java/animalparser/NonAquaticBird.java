package animalparser;

public class NonAquaticBird extends Animal {
    public NonAquaticBird(int year, String name, String subtype) {
        super(year, name, subtype);
        num_of_legs = 2;
    }
}
