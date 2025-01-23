import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students;
    private String name;

    public University() {
        this.students = new ArrayList<>();
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

}
