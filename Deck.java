package Blackjack;

/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Random;
public class Deck {
    // instance variables - replace the example below with your own
    private Card[] deck = new Card[52];
    private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private String[] titles = {"Jack", "Queen", "King", "Ace"};
    int deckIndex = 0;
    Random gen = new Random();
    /**
     * Constructor for objects of class Deck
     */
    public Deck()
    {
        makeNewDeck();
        
    }
   
    public void makeNewDeck() {
        //Spades Cards
        for (int i = 0; i < 8; i++) {
            Card newCard = new Card(i+2, "Spades");
            addCard(newCard);
        }
        for (int i = 0; i < 4; i++) {
            FaceCard newFaceCard = new FaceCard(titles[i], "Spades");
            addCard(newFaceCard);
        }
        //Hearts Cards
        for (int i = 0; i < 8; i++) {
            Card newCard = new Card(i+2, "Hearts");
            addCard(newCard);
        }
        for (int i = 0; i < 4; i++) {
            FaceCard newFaceCard = new FaceCard(titles[i], "Hearts");
            addCard(newFaceCard);
        }
        //Diamonds Cards
        for (int i = 0; i < 8; i++) {
            Card newCard = new Card(i+2, "Diamonds");
            addCard(newCard);
        }
        for (int i = 0; i < 4; i++) {
            FaceCard newFaceCard = new FaceCard(titles[i], "Diamonds");
            addCard(newFaceCard);
        }
        //Clubs Cards
        for (int i = 0; i < 8; i++) {
            Card newCard = new Card(i+2, "Clubs");
            addCard(newCard);
        }
        for (int i = 0; i < 4; i++) {
            FaceCard newFaceCard = new FaceCard(titles[i], "Clubs");
            addCard(newFaceCard);
        }
    }
    
    public void addCard(Card theCard) {
        deck[deckIndex] = theCard;
        deckIndex++;
    }
    
    public Card draw() {
        return deck[gen.nextInt(deck.length)];
    }
}

