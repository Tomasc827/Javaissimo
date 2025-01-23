package solid.srp.correct;

import solid.srp.correct.transformation.Transform;
import solid.srp.correct.transformation.TransformType;
import solid.srp.correct.transformation.Transformation;
import solid.srp.correct.transformationtypes.Lowercase;
import solid.srp.correct.transformationtypes.Split;
import solid.srp.correct.transformationtypes.Uppercase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessUI {

    public void processUI() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;

            printSign();

            while ((input = reader.readLine()) != null) {
                int colonIdx = input.indexOf(':');
                String transformed = getString(input, colonIdx);
                System.out.println("Transformed:" + transformed);

                printSign();
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to present user interface", e);
        }
    }

    private static String getString(String input, int colonIdx) {
        String command = input.substring(0, colonIdx).toUpperCase();
        String text = input.substring(colonIdx + 1);
        Transformation transformation = new Transform();
        switch (command) {
            case "UPPERCASE" -> transformation = new Uppercase(transformation);
            case "LOWERCASE" -> transformation = new Lowercase(transformation);
            case "SPLIT" -> transformation = new Split(transformation);
            default -> throw new IllegalArgumentException("Transformation type is not supported: " + command);
        }


        return transformation.transform(text);
    }

    public void printSign() {
        System.out.print("$ ");
    }

}


