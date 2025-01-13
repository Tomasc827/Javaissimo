package lt.techin.oop;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Dog dog = new Dog();
        Animal konjikiAshisogiJizo = new Animal("gold",120,false);
        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(bird);
        animals.add(dog);
        animals.add(konjikiAshisogiJizo);
        bird.getDescription();
        for(Animal one : animals) {
            System.out.println(one.getDescription());
        }


    }
}
