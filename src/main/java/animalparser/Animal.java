package animalparser;

public class Animal {

    protected boolean isSwimmer;
    protected int num_of_legs;

    public Animal(int num_of_legs) {
        isSwimmer = false;
        this.num_of_legs = num_of_legs;
    }
}
