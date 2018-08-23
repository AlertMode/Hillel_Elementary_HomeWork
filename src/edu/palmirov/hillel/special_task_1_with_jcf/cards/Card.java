package edu.palmirov.hillel.special_task_1_with_jcf.cards;

public class Card implements Comparable<Card>{

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String getName(){
        return this.suit.toString() + " " + this.rank.toString();
    }

    //Checks an object for equality.
    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }

        if (!Card.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Card other = (Card) obj;
        return this.suit == other.suit && this.rank == other.rank;
    }

    @Override
    public int compareTo(Card card) {
        return Integer.compare(this.rank.getValue(), card.rank.getValue());
    }
}