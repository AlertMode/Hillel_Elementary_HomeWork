package edu.palmirov.hillel.special_task_1_with_jcf.cards;

import java.util.*;

public class CardDeck {

    private final int maxQuantity = 32;
    private LinkedList<Card> deck = new LinkedList<Card>();

    public CardDeck(DeckType deckType){
        if(deckType == DeckType.FULL) { this.fill(); }
    }

    public LinkedList<Card> getDeck(){
        return deck;
    }

    /**
     * Fills 'LinkedList' with Cards in raw.
     */
    private void fill(){
        Suit[] suits = new Suit[] {Suit.Hearts, Suit.Diamonds, Suit.Clubs, Suit.Spades};
        Rank[] ranks = new Rank[] {Rank.Seven, Rank.Eight, Rank.Nine, Rank.Ten,
                                    Rank.Jack, Rank.Queen, Rank.King, Rank.Ace};

        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 8; j++){
                this.deck.add(new Card(suits[i], ranks[j]));
            }
        }
    }

    /**
     * Adds only unique Cards to the 'LinkedList'.
     */
    public void add(Card card){
        this.deck.add(card);
    }

    /**
     * Returns the demanded card or 'null' value if there is no such card in the 'LinkedList' cell
     * with the input index.
     */
    public Card get(int index){
        if(isOutOfBoundaries(index)){ return null; }
        return this.deck.get(index);
    }

    /**
     * Returns the length of the 'LinkedList'.
     */
    public int getSize(){
        return this.deck.size();
    }

    /**
     * Checks the input index for being usable in the defined range.
     */
    private boolean isOutOfBoundaries(int index){
        return index >= this.maxQuantity || index < 0;
    }

    public enum DeckType{
        FULL,
        EMPTY;
    }
}