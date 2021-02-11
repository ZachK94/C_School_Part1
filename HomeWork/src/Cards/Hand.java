package Enumy.Cards;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Hand extends SortBySuit implements Comparable<Hand>{

    List<Card> cardList;

    public Hand(){
        cardList = new ArrayList<>();
    }

    public void add(Card card){
        cardList.add(card);
    }

    public void print(){
        cardList.stream().forEach(card -> System.out.println(card.toString()));
    }

    public void sort(){
        cardList.stream().sorted((c1, c2) -> {
            return c1.getValue() - c2.getValue();
        }).collect(Collectors.toList());
    }

    public int sumOfHand(List<Card> list){
        return list.stream().mapToInt(Card::getValue).sum();
    }

    @Override
    public int compareTo(Hand hand) {
        return this.sumOfHand(this.cardList) - hand.sumOfHand(hand.cardList);
    }

    public void sortBySuit(){
        BySuitInValueOrder bySuitInValueOrder = new BySuitInValueOrder();
        Collections.sort(this.cardList, bySuitInValueOrder);
    }

    public static void main(String[] args) {
        Hand hand = new Hand();

        hand.add(new Card(12, Suit.HEART));
        hand.add(new Card(4, Suit.SPADE));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(14, Suit.SPADE));
        hand.add(new Card(7, Suit.HEART));
        hand.add(new Card(2, Suit.SPADE));

        hand.sortBySuit();
        hand.print();
    }
}
