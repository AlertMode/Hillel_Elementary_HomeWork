package edu.palmirov.hillel.special_task_1.Cards;

public enum Rank {
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Jack(2),
    Queen(3),
    King(4),
    Ace(11);

    private int value;

    Rank(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}