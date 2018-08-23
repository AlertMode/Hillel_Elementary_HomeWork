package edu.palmirov.hillel.special_task_1.Actors;

import edu.palmirov.hillel.special_task_1.Cards.*;

public class Player extends Actor{

    private final int size = 32;
    private Card[] cards = new Card[size];
    private int index = 0;
    private int roundScores = 0;

    public Player(String name) {
        super(name);
    }

    public Card getCard(int index){
        return this.cards[index];
    }

    public int getRoundScores(){
        return this.roundScores;
    }

    public void takeCard(Card card){
        if(this.cards.length > index) {
            this.roundScores += card.getRank().getValue();
            this.cards[this.index++] = card;
        }
    }

    public String showCards(){
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < this.cards.length && this.cards[i] != null; i++) {
            StringBuilder temp = new StringBuilder("Card #" + (i + 1) + " : " + this.cards[i].getName()
                    + ". Scores: " + this.cards[i].getRank().getValue() + "\n");
            info.append(temp);
        }
        return info.toString();
    }

    public void resetCards(){
        this.cards = new Card[size];
        this.roundScores = 0;
        this.index = 0;
    }
}