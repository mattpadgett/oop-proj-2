/*
 * CS 2365 Object-Oriented Programming - Spring 2020
 * Project 2 - UNO Excercises
 * File: Hand.java
 * Date: 2/15/2020
 * Author: Coby Kromis - cobykromis - R11567402
 * 
 * Description: Class for sorting the hand and determining how many excercises while be done and skipped
 */
package model;

public class Hand {
    
    private int amount;
    private int id;
    private Card[] cards = new Card[amount];
    
    public Hand () {
        
        amount = 0;
        id = 0;
        
    }
    
    public int getAmount () {
        
        return amount;
        
    }
    
    public Card[] getCards () {
        
        return cards;
        
    }
    
    public int getId () {
        
        return id;
        
    }
    
    public void setAmount (int amount) {
        
        this.amount = amount;
        
    }
    
    public void setId (int id) {
        
        this.id = id;
        
    }
    
    public void setCards (Card cards[]) {
        
        this.cards = cards;
        
    }
   
    public Card[] sort(Card cards[], int amount) {
        
        for (int i = 0; i < amount - 1; i++) {
                
            for (int j = 1; j < amount - 1; j++) {
                
                if (!cards[i].getColor().equals(cards[i + 1])) {
                
                    Card temp = cards[i + 1];
                    cards[i + 1] = cards[j + 1];
                    cards[j] = temp;
                    temp = null;
              
                }
                
            }    
                  
        }
        
        return cards;
        
    }
    
}
