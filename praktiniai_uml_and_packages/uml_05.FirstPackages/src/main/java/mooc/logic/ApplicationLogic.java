package mooc.logic;

import mooc.ui.UserInterface;

import java.util.stream.Stream;

public class ApplicationLogic {
    private UserInterface ui;

    public ApplicationLogic(UserInterface ui) {
        this.ui = ui;
    }

    public void execute(int times) {
        Runnable app = () -> System.out.println("Application is working");
        Stream.generate(() -> app).limit(times).forEach(x -> {
            x.run();
            ui.update();
        });

    }
}
