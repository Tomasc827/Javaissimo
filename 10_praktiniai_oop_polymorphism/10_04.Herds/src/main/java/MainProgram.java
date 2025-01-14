

public class MainProgram {

    public static void main(String[] args) {
        //you can test the program here
        Organism organism = new Organism(20,30);
        Alien alien = new Alien();
        Herd herd = new Herd();
        herd.addToHerd(new Organism(73,56));
        herd.addToHerd(new Organism(57,66));
        System.out.println(herd);
        System.out.println(alien);
    }



}
