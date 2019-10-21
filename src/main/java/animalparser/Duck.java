package animalparser;

public class Duck extends Animal implements Swimmer {
    public Duck(int year, String name, String subtype) {
        super(year, name, subtype);
        num_of_legs = 2;
        isSwimmer = true;
    }
}
