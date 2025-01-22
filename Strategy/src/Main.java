public class Main {
    public static void main(String[] args) {
        Greeter gr = new Greeter(new EnglishGreetingStrategy(),new Dot());
        Greeter hr = new Greeter(new LithuanianGreetingStrategy(), new TripleExMark());

        gr.greet("ln","fn");
        hr.greet("ln","fn");
    }
}