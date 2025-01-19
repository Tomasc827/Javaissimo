import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employees {
    private List<Person> workers;

    public Employees() {
        this.workers = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        if (personToAdd == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        if (workers.stream().anyMatch(x -> x.getName().equalsIgnoreCase(personToAdd.getName()))) {
            throw new IllegalArgumentException("Person with the same name cannot be added");
        }

        workers.add(personToAdd);

    }

    public void add(List<Person> peopleToAdd) {
        if(peopleToAdd == null || peopleToAdd.isEmpty()) {
            throw  new IllegalArgumentException("List cannot be null or empty");
        }
        workers.addAll(peopleToAdd);
    }
    public void print() {
        workers.forEach(System.out::println);
    }
    public void print(Education education) {
        workers.stream().filter(x -> x.getEducation().equals(education)).forEach(System.out::println);
    }

    public void fire(Education education) {
        workers.removeIf(x -> x.getEducation().equals(education));
    }

}
