public class Main {
    public static void main(String[] args) {
        Greeter gr = new LithuanianGreeter();
        Greeter hr = new EnglishGreeter();
        gr.greet("sass","zazz");
        hr.greet("sass","zazz");
    }
}