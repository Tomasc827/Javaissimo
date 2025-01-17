
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // write your test code here
        Student sass = new Student("Sass","Under the bridge");
        Teacher teach = new Teacher("Teach", "Wastebin",3000);
        IntStream.range(0,25).forEach(x -> sass.study());
        ArrayList<Person> people = new ArrayList<>();
        people.add(sass);
        people.add(teach);
        printPersons(people);
        System.out.println(sass.credits());
        System.out.println(teach);
    }

    public static void printPersons(ArrayList<Person> people) {
        people.stream().forEach(System.out::println);
    }

}
