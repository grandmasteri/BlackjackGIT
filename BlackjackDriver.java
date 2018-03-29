package Blackjack;

import java.util.Scanner;
/**
 * Write a description of class BlackjackDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BlackjackDriver
{
    // instance variables - replace the example below with your own
    static Scanner scan = new Scanner(System.in);
    /**
     * Constructor for objects of class BlackjackDriver
     */
    public static void main(String[] args)
    {
        // initialise instance variables
        System.out.println("How many players will play? (Not counting dealer/)");
        int answer = scan.nextInt();
        Game game = new Game(answer);
    }
}
