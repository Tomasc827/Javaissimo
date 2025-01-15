public class Book implements Comparable<Book> {
    private String name;
    private int age;

    public Book(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.name + " (recommended for " + this.age + " year-olds or older)";
    }


    @Override
    public int compareTo(Book o) {
        int ageComparison = Integer.compare(this.age, o.getAge());
        if (ageComparison != 0) {
            return ageComparison;
        } else {
            return this.name.compareToIgnoreCase(o.getName());
        }
    }
}
