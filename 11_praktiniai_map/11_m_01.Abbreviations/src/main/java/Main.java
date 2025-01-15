
public class Main {

    public static void main(String[] args) {
        // Test your program here!
        Abbreviations abs = new Abbreviations();
        abs.addAbbreviation("lol", "league of legends");
        abs.addAbbreviation("kok", "keep or kick");
        String text = "lol kok";
        for (String one : text.split(" ")) {
            if(abs.hasAbbreviation(one)) {
                one = abs.findExplanationFor(one);
            }
            System.out.print(one);
            System.out.print(" ");
        }



    }
}
