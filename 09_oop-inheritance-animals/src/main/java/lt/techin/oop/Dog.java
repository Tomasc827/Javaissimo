package lt.techin.oop;

public class Dog extends Animal {

    public Dog() {
        super("brown",4,true);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Moreover, claims to be humans best friend.";
    }

}
