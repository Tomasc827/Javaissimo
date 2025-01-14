
public class Main {

    public static void main(String[] args) {
        // you can test how your classes work here
    Dog dog = new Dog();
    dog.bark();
    dog.eat();
    Dog fido = new Dog("Fido");
    fido.bark();

    Cat cat1 = new Cat();
    cat1.purr();
    cat1.eat();
    Cat gar = new Cat("Gar");
    gar.purr();

    NoiseCapable doggie = new Dog();
    doggie.makeNoise();

        NoiseCapable cat = new Cat("Grin");
        cat.makeNoise();
        Cat c = (Cat) cat;
        c.purr();
        System.out.println(c.getAnimal());
        System.out.println(fido.getAnimal());



    }

}
