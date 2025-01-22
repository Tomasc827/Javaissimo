public class GreeterExclamationMarkDecoration implements Greeter{
    private Greeter greeter;
     public GreeterExclamationMarkDecoration(Greeter greeter) {
         this.greeter = greeter;
     }

    @Override
    public String greet(String ln, String fn) {
        return greeter.greet(fn,ln) + "!" ;
    }
}
