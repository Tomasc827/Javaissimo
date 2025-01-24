package solid.srp.correct.transformationtypes;

import solid.srp.correct.transformation.Transform;
import solid.srp.correct.transformation.Transformation;

import java.util.Arrays;

public class Capitalize implements Transformation {
    private Transformation transformation;

    public Capitalize(Transformation transformation) {
        this.transformation = transformation;
    }




    @Override
    public String transform(String words) {
        String capitalize = Arrays.stream(words.split())
        return "";
    }
}
