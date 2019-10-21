package animalparser;

public class Animal {

    protected boolean isSwimmer;
    protected int num_of_legs;
    protected int year;
    protected String name;
    protected String subtype;

    public Animal(int year, String name, String subtype) {
        isSwimmer = false;
        num_of_legs = 4;
        this.year = year;
        this.name = name;
        this.subtype = subtype;
    }
}
