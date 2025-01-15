import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainProgram {

    public static void main(String[] args) {
        Student first = new Student("Zal");
        Student second = new Student("al");
        List<Student> students = new ArrayList<>();
        students.add(first);
        students.add(second);
        System.out.println(first.compareTo(second));
        Collections.sort(students);
        System.out.println(students);

    }
}
