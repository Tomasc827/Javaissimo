

public class Checker {

public Checker() {
}

public boolean isDayOfWeek(String string) {
    String stringLower = string.toLowerCase();
    for (DaysOfWeek one : DaysOfWeek.values()) {
        if (stringLower.matches(one.getAbbreviation())) {
            System.out.println("The form is correct");
            return true;

        }
    }
    System.out.println("The form is incorrect");
    return false;


}
public boolean allVowels(String string) {
    String stringVowels = string.toLowerCase();
    for(char one : stringVowels.toCharArray()){
        boolean isVowel = false;
        for(Vowel each : Vowel.values()) {
            if(one == each.getVowel()) {
                isVowel = true;
                break;
            }
        }
        if(!isVowel) {
            System.out.println("The form is incorrect");
            return false;
        }
    }
    System.out.println("the form is correct");
    return true;
}

public boolean timeOfDay(String string) {
    if(string.matches("^([01]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])$")) {

        System.out.println("The form is correct");
        return true;
    }
    System.out.println("The form is incorrect");
    return false;

}

}
