public class GreeterImpl implements Greeter{
    @Override
    public String greet(String fn, String ln) {
        return fn + " " + ln;
    }
}
