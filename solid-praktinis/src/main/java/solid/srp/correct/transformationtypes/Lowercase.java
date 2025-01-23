package solid.srp.correct.transformationtypes;

import solid.srp.correct.transformation.Transformation;

public class Lowercase implements Transformation {
    private Transformation transformation;

    public Lowercase(Transformation transformation) {
        this.transformation = transformation;
    }



    @Override
    public String transform(String words) {
        String lowercase = transformation.transform(words);
        return lowercase.toLowerCase();
    }
}
