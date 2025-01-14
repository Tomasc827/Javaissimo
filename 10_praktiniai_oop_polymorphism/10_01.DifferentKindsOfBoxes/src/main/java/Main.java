

public class Main {

    public static void main(String[] args) {
        // You can test your program here
        BoxWithMaxWeight box = new BoxWithMaxWeight(10);
        box.add(new Item("Cof",5));
        box.add(new Item("Cof",4));

        RealBox box3 = new RealBox();

        try {
            box.add((new Item("Coff",6)));
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("Error: "  + e.getMessage());
            System.out.println();
        }

        OneItemBox box1 = new OneItemBox();
        box1.add(new Item("cof",5));

        try {
            box1.add((new Item("cof",6)));
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("Error: "  + e.getMessage());
            System.out.println();
        }

        try {
            box1.add((new Item("Coff",6)));
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("Error: "  + e.getMessage());
            System.out.println();
        }

        MisplacingBox boxRandom = new MisplacingBox();
        boxRandom.add(new Item("new",5));
        boxRandom.add(new Item("new2",5));
        boxRandom.add(new Item("new1",5));


        System.out.println(boxRandom.isInBox(new Item("Cof")));
        System.out.println(box.isInBox(new Item("Cof")));
        System.out.println(box3.getArt());


    }
}
