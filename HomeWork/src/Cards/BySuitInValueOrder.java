import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BySuitInValueOrder extends SortBySuit implements Comparator<Card>{

    @Override
    public int compare(Card c1, Card c2) {
        if (super.compare(c1, c2) == 0){
            return c1.getValue()-c2.getValue();
        } else {
            return super.compare(c1, c2);
        }
    }

    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(3, Suit.SPADE));
        cards.add(new Card(2, Suit.DIAMOND));
        cards.add(new Card(14, Suit.SPADE));
        cards.add(new Card(12, Suit.HEART));
        cards.add(new Card(2, Suit.SPADE));

        BySuitInValueOrder sortByValueSorter = new BySuitInValueOrder();
        Collections.sort(cards, sortByValueSorter);

        cards.stream().forEach(c -> System.out.println(c));
    }
}
