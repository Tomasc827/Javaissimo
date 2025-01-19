public class Person {
    private String name;
    private Education level;


    public Person(String name, Education level) {
        if (name == null || name.length() > 255 || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or over 255 characters");
        }
        this.name = name;
        this.level = level;
    }

    public Education getEducation() {
        return level;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", " + level;
    }
}
