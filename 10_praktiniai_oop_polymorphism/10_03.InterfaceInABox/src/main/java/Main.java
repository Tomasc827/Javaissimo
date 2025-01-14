
public class Main {

    public static void main(String[] args) {
        // test your classes here
        CD rock = new CD("gram", "wheow", 1982);
        Book pot = new Book("Harry","Potter",5);
        Book pot2 = new Book("Harry1","Potter2",5);
        BetterBox happy = new BetterBox();
        Box boxSmall = new Box(6);
        boxSmall.add(rock);
        boxSmall.add(rock);
        boxSmall.add(rock);
        boxSmall.add(rock);
        boxSmall.add(rock);
        boxSmall.add(pot);
        Box boxSmallest = new Box(1);
        boxSmallest.add(rock);
        boxSmallest.add(rock);
        boxSmall.add(boxSmallest);

        try {
            Box boxMed = new Box(-6);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            boxSmall.add(pot2);
        } catch (ItemTooHeavyException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try{
            CD punk = new CD("gram", "wheow", 1982);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(boxSmall);
        System.out.println(happy.getHappyMeal());
    }

}
