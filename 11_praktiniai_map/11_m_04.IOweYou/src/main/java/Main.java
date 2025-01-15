
public class Main {

    public static void main(String[] args) {
        // Test your program here
        IOU i = new IOU();
        i.setSum("zaz",22);
        i.setSum("lil", 25);
        System.out.println(i.howMuchDoIOweTo("zaz"));

    }
}
