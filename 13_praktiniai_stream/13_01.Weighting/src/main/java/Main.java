

public class Main {

    public static void main(String[] args) {
        // Use this main program for testing your classes!
        Item item1 = new Item("sad",12);
        Item item2 = new Item("fsdf",5);
        Item item3 = new Item("sada",8);
        Item item4 = new Item("dasda",13);
        Suitcase i1 = new Suitcase(100);
        Suitcase i2 = new Suitcase(100);
        Hold hold = new Hold(1000);
        i1.addItem(item1);
        i1.addItem(item2);
        i2.addItem(item3);
        i2.addItem(item4);
        hold.addSuitcase(i1);
        hold.addSuitcase(i2);

        hold.printItems();

    }

}
