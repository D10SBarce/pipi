import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-05-25
 * Time: 19:59
 */
class Card {
    public int rank; // 数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Card)) {
            return false;
        }
        Card tmp = (Card) obj;
        if(this.rank == tmp.rank && this.suit.equals(tmp.suit)) {
            return true;
        }
        return false;
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Card card1 = new Card(5,"♥");
        Card card2 = new Card(5,"♥");
        System.out.println(card1 == card2);
        System.out.println(card1.equals(card2));
    }
}
