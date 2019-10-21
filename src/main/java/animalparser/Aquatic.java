package animalparser;

public class Aquatic extends Animal implements Swimmer {

    public Aquatic(int year, String name, String subtype) {
        super(year, name, subtype);
        isSwimmer = true;
    }
}
