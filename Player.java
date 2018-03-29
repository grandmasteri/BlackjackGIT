package Blackjack;


/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private String name;
    private double money;
    private double betMoney;
    private Card[] hand = new Card[2];
    private int handTotal;
    /**
     * Constructor for objects of class Player
     */
    public Player(String nm, Double mny)
    {
        // initialise instance variables
        name = nm;
        money = mny;
        handTotal = 0;
    }
    
    public void addCardToHand(Card newCard) {
        Card[] cardArray = new Card[hand.length+1];
        for (int i = 0; i < hand.length; i++) {
            cardArray[i] = hand[i];
        }
        
        cardArray[hand.length] = newCard;
        hand = cardArray;
        handTotal += newCard.getValue();
    }
    
    public Card getCard(int index) {
        return hand[index];
    }
    
    public String getName() {
        return name;
    }
    
    public void bet( double theBet) {
        money -= theBet;
        betMoney = theBet;
    }
    
    public double getBetMoney() {
        return betMoney;
    }
    
    public void addMoney( double m) {
        money += m;
    }
    
    public void resetBetMoney() {
        betMoney = 0;
    }
    public int Ace1HandTotal() {
        return handTotal;
    }
    public String getHandTotal() {
        int aceAmount = 0;
        for (Card c : hand) {
            if (c.getValue() == 1) {
                aceAmount+=1;
            }
            
        }
        if (aceAmount > 0) {
            return Ace1HandTotal() + " or " + (Ace1HandTotal()-aceAmount+aceAmount*11);
        }
        else {
            return "" + Ace1HandTotal();
        }
    }
    
    public void hit(Deck theDeck) {
        addCardToHand(theDeck.draw());
    }
    
    public boolean bust() {
        if (handTotal >= 21) {
            return true;
        }
        else {
            return false;
        }
            
    }
    
    public String toString() {
        return name;
    }
}

