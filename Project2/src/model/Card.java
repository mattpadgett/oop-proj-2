/* CS 2365 Object-Orientated Programming - Spring 2020
 * Project 2 - Uno Exercise
 * File: Card.java
 * Date: 02/12/2020
 * Author: Christian Pennington - R11445847
 * Contributors: None
 * 
 * Description: a collection of static methods to create the varying cards used in the project
 * 
 */

package model;

import java.awt.Color;

/**
 *
 * @author Christian Pennington - R11445847
 */
public class Card {
    
    private Color cardColor;
    private int cardValue;
    
    /**
     * Creates the Card class to be used in the project. 
     * @param cardColor - this parameter takes in the card color
     * @param cardValue - this parameter takes in the card value
     */
    public Card (Color cardColor, int cardValue){
        this.cardColor = cardColor;
        this.cardValue = cardValue;
    }
        
    /**
     * This is to get the color of the card
     * @return the color of the card
     */
    public Color getColor() {
        return cardColor;
    }
    
    /**
     * This is to get the value of the card
     * @return the value of the card
     */
    public int getValue(){
        return cardValue;
    }
    
}
