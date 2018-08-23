package edu.palmirov.hillel.special_task_1_with_jcf.actors;

import edu.palmirov.hillel.special_task_1_with_jcf.cards.*;
import java.util.*;

public class Banker extends Actor {

    private CardDeck cardDeck = new CardDeck(CardDeck.DeckType.FULL);
    private int lastIndex = 0;

    public Banker(String name) {
        super(name);
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cardDeck.getDeck());
    }

    /**
     * Returns one 'Card' object per call.
     */
    public Card giveCard(){
        return this.cardDeck.get(lastIndex++);
    }

    public void resetDeck(){
        this.cardDeck = new CardDeck(CardDeck.DeckType.FULL);
        this.lastIndex = 0;
    }
}