public class Square extends  Rectangle{

    public Square(double side, String color, boolean filled) {
        this.length = side;
        this.width = side;
        this.color = color;
        this.filled = filled;
    }

    public Square (double side) {
        super(side,side);
        this.color = "red";
        this.filled = true;
    }

    public Square () {
        super();
        this.color = "red";
        this.filled = true;
    }

    @Override
    public double getArea() {
        return this.length * this.length;
    }

    @Override
    public double getPerimeter() {
        return this.length * 4;
    }

    public double getSide() {
        return getLength();
    }
    public void setSide(double side) {
        this.length = side;
        this.width = side;
    }
   @Override
    public String toString() {
        return "A Square with a side=" + this.length + ", which is a subclass of " + super.toString();
    }

}
