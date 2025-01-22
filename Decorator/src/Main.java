public class Main {
    public static void main(String[] args) {
        Greeter g = new GreeterImpl();

        g = new GreeterUpperCaseDecorator(new GreeterExclamationMarkDecoration(g));

        System.out.println(g.greet("sass","zazz"));
    }
}