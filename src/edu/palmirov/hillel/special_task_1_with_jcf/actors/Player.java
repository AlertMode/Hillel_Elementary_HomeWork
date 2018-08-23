package edu.palmirov.hillel.special_task_1_with_jcf.actors;

import edu.palmirov.hillel.special_task_1_with_jcf.cards.*;

import java.util.*;

public class Player extends Actor {

    private final int size = 32;
    private LinkedList<Card> cards = new LinkedList<>();
    private int roundScores = 0;

    public Player(String name) {
        super(name);
    }

    public Card getCard(int index){
        if(index > this.cards.size()){
            return null;
        }

        return this.cards.get(index);
    }

    public int getRoundScores(){
        return this.roundScores;
    }

    public void takeCard(Card card){
        if(this.cards.size() > this.size) {
            this.roundScores += card.getRank().getValue();
            this.cards.add(card);
        }
    }

    public String showCards(){
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < this.cards.size() && this.cards.get(i) != null; i++) {
            StringBuilder temp = new StringBuilder("Card #" + (i + 1) + " : " + this.cards.get(i).getName()
                    + ". Scores: " + this.cards.get(i).getRank().getValue() + "\n");
            info.append(temp);
        }
        return info.toString();
    }

    public void resetCards(){
        this.cards.clear();
        this.roundScores = 0;
    }
}