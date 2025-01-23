package solid.srp.correct.transformationtypes;

import solid.srp.correct.transformation.Transformation;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Split implements Transformation {
    private Transformation transformation;

    public Split(Transformation transformation) {
        this.transformation = transformation;
    }

    @Override
    public String transform(String words) {
        return Arrays.stream(words.split("")).collect(Collectors.joining(" "));
    }
}
