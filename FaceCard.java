package Blackjack;


/**
 * Write a description of class FaceCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FaceCard extends Card {
    private String title;
    
    /**
     * Constructor for objects of class FaceCard
     */
    public FaceCard(String titilating,String professionalGown)
    {
        super(10, professionalGown);
        if (titilating.equals("Ace")) {
            setValue(1);
        }
       
        title = titilating;
    }
    
    public String getTitle() {
        return title;
    }
    public String toString() {
        return title + " of " + super.suit + ".";
    }
}
