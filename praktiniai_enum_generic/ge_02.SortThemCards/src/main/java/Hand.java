import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }
    public void add(Card card) {
        if (cards.stream().anyMatch(x -> x.getSuit().equals(card.getSuit()) && x.getValue() == card.getValue())) {

            throw new IllegalArgumentException("Card cannot be same suit and value");
        }
        cards.add(card);
    }

    public void print() {
        if(cards.isEmpty()) {
            System.out.println("Empty hand");
            return;
        }
        cards.forEach(System.out::println);
    }

    public void sort() {
        Collections.sort(cards);
    }
    public void sortBySuit() {
        SortBySuit s = new SortBySuit();
        cards.sort(s);
    }

    @Override
    public int compareTo(Hand o) {
        int thisValue = cards.stream().mapToInt(Card::getValue).sum();
        int oValue = o.cards.stream().mapToInt(Card::getValue).sum();

        return Integer.compare(thisValue,oValue);
    }
}
