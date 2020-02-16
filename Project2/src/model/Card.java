/* CS 2365 Object-Orientated Programming - Spring 2020
 * Project 2 - Uno Exercise
 * File: Card.java
 * Date: 02/12/2020
 * Author: Christian Pennington
 * Contributors: None
 * 
 * Description: a collection of static methods to create the varying cards used in the project
 * 
 */

package model;

import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;

public class Card {
    
    private Color cardColor;
    private String cardExercise;
    private int cardValue;
    
    //Exercise List
    private String pushups;
    private String squats;
    private String situps;
    private String lunges;
    private String burpees;
    
    Color [] unoColors = {RED, BLUE, GREEN, YELLOW, BLACK};
    int [] Value = {0,1,2,3,4,5,6,7,8,9};
    String [] Exercises = {pushups, squats, situps, lunges, burpees};
    
    
    public Card (Color cardColor, String cardExercise, int cardValue){
        this.cardColor = cardColor;
        this.cardExercise = cardExercise;
        this.cardValue = cardValue;
    }
    
    public void setColor(Color newColor){
        this.cardColor = newColor;
    }
    
    public Color getColor() {
        //cardColor.equals(Color.BLUE);
        return cardColor;
    }
    
    public void setExercise(String newExercise){
        this.cardExercise = newExercise;
    }
    
    public String getExercise(){
        return cardExercise;
    }
    
    public void setValue (int newValue){
        this.cardValue = newValue;
    }
    
    public int getValue(){
        return cardValue;
    }
    
}
