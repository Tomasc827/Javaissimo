import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(2,"green",false);
        Rectangle rectangle = new Rectangle("brown",true, 2,2 );
        Square square = new Square(2,"brown",false);

        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(square);
        double totalArea = 0;
        for (Shape one : shapes) {
            System.out.println(one.getArea());
            System.out.println(one);
            totalArea = one.getArea() + totalArea;
        }

        Shape shapeWithHighestPerimeter = null;
        double maxPerimeter = 0;

        // Iterate over the list of shapes
        for (Shape shape : shapes) {
            double perimeter = shape.getPerimeter();
            if (perimeter > maxPerimeter) {
                maxPerimeter = perimeter;
                shapeWithHighestPerimeter = shape;
            }
        }

        System.out.println(totalArea);
        System.out.println(shapeWithHighestPerimeter);
        System.out.println(maxPerimeter);
        }
    }
