package Main;

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

import model.Deck;
import model.Hand;
import util.StatTracker;

/**
 *
 * @author matt
 */
public class Game {
    
    private Deck deck;
    private StatTracker statTracker;
    
    /**
     *
     * @param hasAction
     * @param shuffleTogether
     * @param deckNum
     */
    public Game(boolean hasAction, boolean shuffleTogether, int deckNum) {
        
        statTracker = new StatTracker();
        this.deck = new Deck(deckNum, shuffleTogether, hasAction, this);
        Hand.resetHandIds();
        
    }
    
    /**
     *
     * @return
     */
    public Hand getNextHand() {
        
        if (this.deck != null) {
            
            return this.deck.draw();
            
        } else {
            
            return null;
            
        }
        
    }
    
    /**
     *
     * @return
     */
    public StatTracker getStatTracker() {
        
        return statTracker;
        
    } 
    
    /**
     *
     * @return
     */
    public Deck getDeck() {
        
        return deck;
        
    }
    
}
