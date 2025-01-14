public class Organism implements Movable{

    private int x;
    private int y;

    public Organism(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x: " + this.x + "; y: " + this.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

}
