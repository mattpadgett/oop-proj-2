/* CS 2365 Object-Oriented Programming - Spring 2020
 * Project 2 - UNO Exercises
 * File: Game.java
 * Date: 2/29/2020
 * Author: Coby Kromis - cobykromis - R11567402
 *         Matt Padgett - matpadge - R11564420
 *         Jason Luckow - jluckow - R11560069
 *         Brent Williams - wil94836 - R11630670
 *         Christian Pennington - chrpenni - R11445847
 * Description: Executes the game
 */

package Main;

import model.Deck;
import model.Hand;
import util.StatTracker;

/**
 * Class to control the game.
 * @author Matt Padgett (R11564420)
 * @author Coby Kromis (R11567402)
 * @author Jason Luckow (R11560069)
 * @author Brent Willaims (R11630670)
 * @author Christian Pennington (R11445847)
 */
public class Game {
    
    private Deck deck;
    private StatTracker statTracker;
    
    /**
     * Constructor for the Game class. This is used to control the game.
     * @param hasAction Determines whether the deck will have action cards.
     * @param shuffleTogether Determines whether the decks will be shuffled together or separately. 
     * @param deckNum Determines the number of decks to be used.
     */
    public Game(boolean hasAction, boolean shuffleTogether, int deckNum) {
        
        statTracker = new StatTracker();
        this.deck = new Deck(deckNum, shuffleTogether, hasAction, this);
        Hand.resetHandIds();
        
    }
    
    /**
     * Gets the next hand after drawing it from the deck of cards.
     * @return A hand with of cards from the deck.
     */
    public Hand getNextHand() {
        
        if (this.deck != null) {
            
            return this.deck.draw();
            
        } else {
            
            return null;
            
        }
        
    }
    
    /**
     * Gets the StatTracker object.
     * @return The StatTracker object.
     */
    public StatTracker getStatTracker() {
        
        return statTracker;
        
    } 
    
    /**
     * Gets the Deck object
     * @return The Deck object.
     */
    public Deck getDeck() {
        
        return deck;
        
    }
    
}
