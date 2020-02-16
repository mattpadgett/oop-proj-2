/*
 * CS 2365 Object-Oriented Programming - Spring 2020
 * Project 2 - UNO Excercises
 * File: Hand.java
 * Date: 2/15/2020
 * Author: Coby Kromis - cobykromis - R11567402
 * 
 * Description: Class for sorting the hand and determining how many excercises while be done and skipped.
 */
package model;

public class Hand {
    
    private int amount;
    private int ID;
    
    public Hand () {
        
        amount = 0;
        ID = 0;
        
    }
    
    public int getAmount () {
        
        return amount;
        
    }
    
    public int getID () {
        
        return ID;
        
    }
    
    public void setAmount (int amount) {
        
        this.amount = amount;
        
    }
    
    public void setID (int ID) {
        
        this.ID = ID;
        
    }
   
    public Card[] sort(Card cards[], int amount) {
        
        for (int i = 0; i < amount; i++) {
            
            if (cards[i].getColor() != cards[i + 1].getColor()) {
                
                Card temp = cards[i + 1];
                cards[i + 1] = cards[i + 2];
                cards[i + 2] = temp;
                temp = null;
              
            }
            
        }
        
        return cards;
        
    }
    
}
