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
 * @author matt
 */
public class Card {
    
    private Color cardColor;
    private int cardValue;
    
    /**
     *
     * @param cardColor
     * @param cardValue
     */
    public Card (Color cardColor, int cardValue){
        this.cardColor = cardColor;
        this.cardValue = cardValue;
    }
        
    /**
     *
     * @return
     */
    public Color getColor() {
        return cardColor;
    }
    
    /**
     *
     * @return
     */
    public int getValue(){
        return cardValue;
    }
    
}
