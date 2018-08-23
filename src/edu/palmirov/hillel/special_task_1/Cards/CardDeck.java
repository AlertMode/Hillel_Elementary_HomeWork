package edu.palmirov.hillel.special_task_1.Cards;

public class CardDeck {

    private final int maxQuantity = 32;
    private Card []array;
    private int lastIndex =0;

    public CardDeck(DeckType deckType){
        this.array = new Card[maxQuantity];
        if(deckType == DeckType.FULL) { this.fill(); }

    }

    //Fills the card deck with Cards in raw.
    private void fill(){
        Suit[] suits = new Suit[] {Suit.Hearts, Suit.Diamonds, Suit.Clubs, Suit.Spades};
        Rank[] ranks = new Rank[] {Rank.Seven, Rank.Eight, Rank.Nine, Rank.Ten,
                                    Rank.Jack, Rank.Queen, Rank.King, Rank.Ace};

        int count = 0;
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 8; j++){
                this.array[count++] = new Card(suits[i], ranks[j]);
            }
        }
    }

    //Adds only unique Cards to the array.
    //If there already is a similar card, the 'false' value will be returned.
    public void add(Card card){
        int index = hasNull();
        if(index != -1){
            this.array[index] = card;
        } else {
            this.array[this.lastIndex++] = card;
        }
    }

    //Returns the demanded card or 'null' value if there is no such card in the array's cell
    // with the input index.
    public Card get(int index){
        if(isOutOfBoundaries(index)){ return null; }
        return this.array[index];
    }

    //Returns the index if class array already has the input card.
    //Otherwise, '-1' will be returned.
    public int hasSame(Card card){
        for (int i = 0; i < this.array.length; i++) {
            if(this.array[i] == null){
                continue;
            } else if(this.array[i].equals(card)){ return i; }
        }
        return -1;
    }

    //Returns the length of the class array.
    public int getSize(){
        return this.array.length;
    }

    //Returns the index of the 'null' value in the array,
    //otherwise, the negative value '-1' will be returned.
    private int hasNull(){
        for (int i = 0; i < this.array.length; i++) {
            if(this.array[i] == null){ return i;}
        }
        return -1;
    }

    //Checks the input index for being usable in the array's range.
    //Returns 'true' value if the index points on nonexistent array's cell or has negative value.
    private boolean isOutOfBoundaries(int index){
        return index >= this.array.length || index < 0;
    }

    public enum DeckType{
        FULL,
        EMPTY;
    }
}