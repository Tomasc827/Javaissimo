
public class MainProgram {

    public static void main(String[] args) {
        // test your classes here
        Person anna = new Person("Anna", Education.PHD);
        Person karenina = new Person("Karenina", Education.BA);
        Employees e = new Employees();
        e.add(anna);
        e.add(karenina);
        e.fire(Education.PHD);
        e.print();
    }
}
