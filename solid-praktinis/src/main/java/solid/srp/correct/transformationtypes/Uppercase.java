package solid.srp.correct.transformationtypes;

import solid.srp.correct.transformation.Transformation;

public class Uppercase implements Transformation {
    private Transformation transformation;
    public Uppercase(Transformation transformation) {
        this.transformation = transformation;
    }


    @Override
    public String transform(String words) {
        String transformedText = transformation.transform(words);
        return transformedText.toUpperCase();
    }
}
