abstract class Greeter {

    public void greet(String fn, String ln) {
        System.out.println(getGreetingsString() + fn + " " + ln );
    }

    protected abstract String getGreetingsString();
}
