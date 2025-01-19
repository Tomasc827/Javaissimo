import java.util.Comparator;

public class SortBySuit implements Comparator<Card> {

    public int compare(Card one, Card two) {
        return one.getSuit().ordinal() - two.getSuit().ordinal();
    }

}
