package Enumy.Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortBySuit implements Comparator<Card> {

    public int compare(Card c1, Card c2) {
        return c1.getSuit().ordinal() - c2.getSuit().ordinal();
    }

    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(3, Suit.SPADE));
        cards.add(new Card(2, Suit.DIAMOND));
        cards.add(new Card(14, Suit.SPADE));
        cards.add(new Card(12, Suit.HEART));
        cards.add(new Card(2, Suit.SPADE));

//        SortBySuit sortBySuitSorter = new SortBySuit();
//        Collections.sort(cards, sortBySuitSorter);

        Collections.sort(cards, (c1, c2) -> c1.getSuit().ordinal() - c2.getSuit().ordinal());
        cards.stream().forEach(c -> System.out.println(c));
    }

}