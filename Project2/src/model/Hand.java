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
    
    //Attribute initialization
    private int amount;
    private int id;
    private Card[] cards = new Card[amount];
    
    //Constructor
    public Hand (int id) {
        
        amount = 0;
        this.id = id;
        
    }
    
    //Getters
    public int getAmount () {
        
        return amount;
        
    }
    
    public Card[] getCards () {
        
        return cards;
        
    }
    
    public int getId () {
        
        return id;
        
    }
    
    //Setters
    public void setAmount (int amount) {
        
        this.amount = amount;
        
    }
    
    public void setCards (Card cards[]) {
        
        this.cards = cards;
        
    }
    
    //Sorts hand by color and rank
    public Card[] sort(Card cards[], int amount) {
        
        int i = 0;
        int replaceCount = 0;
        Card temp = null;
        
        while (i < amount - 1) {
             
            for (int j = i + 1; j < amount - 1; j++) {
                
                if (cards[i].getColor().equals(cards[j].getColor())) {
                    
                    temp = cards[j];
                    cards[j] = cards[i + replaceCount + 1];
                    cards[i + replaceCount + 1] = temp;
                    replaceCount++;
                    
                }
                    
            }
            
            i = i + replaceCount + 1;
                  
        }
        
        for (int k = 0; i < amount; i++) {
            
            System.out.println(cards[i].getColor());
            
        }
        
        return cards;
        
    }
    
}
