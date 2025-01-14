import java.util.ArrayList;

public class Herd implements Movable {
    private ArrayList<Movable> organisms;

    public Herd() {
        this.organisms = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        organisms.add(movable);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Movable one : organisms) {
            sb.append(one).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void move(int dx,int dy) {
        for(Movable one: organisms) {
            if (one instanceof Organism) {
                Organism org = (Organism) one;
                org.move(dx,dy);
            }
        }
    }


}
