public class Rectangle extends Shape{
    protected double width;
    protected double length;

    public Rectangle() {
        super();
        this.width = 1.0;
        this.length = 1.0;
    }
    public Rectangle(double length, double width) {
        super();
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double length, double width ) {
        this.color = color;
        this.filled = filled;
        this.length = length;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    @Override
    public double getArea() {
        return this.length * this.width;
    }
    @Override
    public double getPerimeter() {
        return (this.length + this.width) * 2;
    }

    @Override
    public String toString() {
        return "A Rectangle with length=" + this.length + " and width=" + this.width + ", which is a subclass of " + super.toString();
    }

}
