package edu.palmirov.hillel.special_task_1.Actors;

import edu.palmirov.hillel.special_task_1.Cards.*;

public class Banker extends Actor {

    private CardDeck cardDeck = new CardDeck(CardDeck.DeckType.FULL);
    private int lastIndex = 0;

    public Banker(String name) {
        super(name);
    }

    //Shuffles the array of 'Cards'.
    public void shuffleDeck() {
        CardDeck shuffledDeck = new CardDeck(CardDeck.DeckType.EMPTY);
        int randIndex;

        for(int i = 0; i < this.cardDeck.getSize(); i++){
            do{
                randIndex = (int)(Math.random() * this.cardDeck.getSize());
            }while(shuffledDeck.hasSame(this.cardDeck.get(randIndex)) != -1);
            shuffledDeck.add(this.cardDeck.get(randIndex));
        }
        this.cardDeck = shuffledDeck;
    }

    //Returns one 'Card' object per call.
    public Card giveCard(){
        return this.cardDeck.get(lastIndex++);
    }

    public void resetDeck(){
        this.cardDeck = new CardDeck(CardDeck.DeckType.FULL);
        this.lastIndex = 0;
    }
}