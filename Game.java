package Blackjack;
import java.util.Scanner;

/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    // instance variables - replace the example below with your own
    Player[] players;
    Deck gameDeck = new Deck();
    Dealer dealer = new Dealer();
    Scanner scan = new Scanner(System.in);
    int numPlayers = 0;
    boolean anotherGame = true;
    /**
     * Constructor for objects of class Game
     */
    public Game(int np)
    {
        // initialise instance variables
        numPlayers = np;
        players = new Player[numPlayers + 1];
        players[0] = dealer;
        initializePlayers();
        while (anotherGame) {
            initializeHands();
            playGame();
            System.out.println("Play another round? (Y/N)");
            String answer = scan.next();
            if (answer.equals("N")) {
                anotherGame = false;
            }
        }
    }
    public void initializePlayers() {
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("What is the name of Player " + (i+1) + "?");
            String name = scan.next();
            System.out.println("How much money does Player " + (i+1) + " have? (use double)");
            double money = scan.nextDouble();
            Player p = new Player(name, money); 
            players[i+1] = p;
        }
    }
    public void initializeHands() {
        for (int index1 = 0; index1 < numPlayers; index1++) {
            for (int index2 = 0; index2 < 2; index2++) {
                players[index1].hit(gameDeck);
            }
        }
        //Dealer hand
        players[0].hit(gameDeck);
        players[0].hit(gameDeck);
        System.out.println("The dealer has a " + players[0].getCard(1) + ".");
    }
    public void playGame() {
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("It's " + players[i+1].getName() + "'s turn.");
            System.out.println("How much would you like to bet? (double/)");
            double inDaPot = scan.nextDouble();
            players[i+1].bet(inDaPot);
        }
        System.out.println("The dealer bets 50");
        players[0].bet(50);
        while (continueGame()) {
            for (int i = 0; i < numPlayers; i++) {
                if (!players[i+1].bust()) {
                    System.out.println("It's " + players[i+1].getName() + "'s turn. " +
                    "Your hand total is " + players[i+1].getHandTotal() + ".");
                    System.out.println("Would you like to hit? (Y/N)");
                    String answer = scan.next();
                    if (answer.equals("Y")) {
                        players[i+1].hit(gameDeck);
                    }
                }
            }
            if (dealer.Ace1HandTotal() < 17) {
                dealer.hit(gameDeck);
            }
        }
        endGame();
    }
    public void endGame() {
        if (players[0].bust()) {
            System.out.println("The dealer lost, congratulations!");
            for (int i = 0; i < numPlayers; i++) {
                if (!players[i+1].bust()) {
                    players[i+1].addMoney(2.0 * players[i+1].getBetMoney());
                }
                players[i+1].resetBetMoney();
            }
         }
        else {
            System.out.println("The dealer won, lol thet soocks");
            for (int i = 0; i < numPlayers; i++) {
                players[i+1].resetBetMoney();
            }
        }
    }
    
    public boolean continueGame() {
        if (players[0].bust()) {
            return false;
        }
        for (int i = 0; i < numPlayers; i++) {
            if (!players[i+1].bust()) {
                return true;
            }
        }
        return false;
    }
}

