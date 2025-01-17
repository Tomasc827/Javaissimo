public class Student extends Person{
    private int counter;

    public Student(String name, String address) {
        super(name,address);
    }
    public void study() {
        counter++;
    }

    @Override
    public String toString(){
        return getName() + "\n" + super.toString();
    }

    public int credits() {
        return counter;
    }
}
