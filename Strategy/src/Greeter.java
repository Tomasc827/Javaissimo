public class Greeter {
    private GreeterLanguageStrategy gls;
    private getEnding ge;

    public Greeter(GreeterLanguageStrategy gls,getEnding ge) {
        this.gls = gls;
        this.ge = ge;
    }

    public void greet(String fn, String ln) {
        System.out.println(gls.getGreetingString() + " " + fn + " " + ln + ge.ending());
    }

}
