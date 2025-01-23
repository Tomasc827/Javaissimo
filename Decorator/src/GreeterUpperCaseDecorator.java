public class GreeterUpperCaseDecorator implements Greeter{
    private Greeter greeter;

    public GreeterUpperCaseDecorator(Greeter greeter) {
        this.greeter = greeter;
    }

    @Override
    public String greet(String fn, String ln) {
        return greeter.greet(fn,ln).toUpperCase();
    }
}
