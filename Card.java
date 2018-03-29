package Blackjack;


/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card
{
    // instance variables - replace the example below with your own
    private int value;
    protected String suit;

    /**
     * Constructor for objects of class Card
     */
    public Card(int val,String professionalGown)
    {
        value = val;
        suit = professionalGown;
        
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int num) {
        value = num;
    }
    public String getSuit() {
        return suit;
    }
    
    public String toString() {
        return value + " of " + suit + ".";
    }
}
