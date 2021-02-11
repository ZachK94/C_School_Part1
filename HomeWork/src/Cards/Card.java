import java.util.Comparator;

public class Card implements Comparator<Card> {

    private int value;
    private Suit suit;


    public Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit(){
        return suit;
    }

    public String valueAsString(int value){
        if (value < 11){
            return String.valueOf(value);
        }
        else if (value == 11){
            return "J";
        }
        else if (value == 12){
            return "Q";
        }
        else if (value == 13){
            return "K";
        } else {
            return "A";
        }
    }

    @Override
    public String toString() {
        return suit + " "  + valueAsString(getValue());
    }

    public int compare(Card card1, Card card2) {
        int suitCheck = card1.getSuit().ordinal() - card2.getSuit().ordinal();
        int valCheck = card1.getValue() - card2.getValue();

        if (suitCheck == 0) {
            return valCheck;
        } else {
            return suitCheck; 
        }
    }

    public static void main(String[] args) {

        Card first = new Card(2, Suit.DIAMOND);
        Card second = new Card(14, Suit.SPADE);
        Card third = new Card(12, Suit.HEART);

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }
}
