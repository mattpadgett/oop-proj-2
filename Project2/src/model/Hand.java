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

import java.awt.Color;

public class Hand {
    
    //Attribute initialization
    private int amount;
    private int id;
    private Card[] cards;
    
    //Constructor
    public Hand (int id, int amount, Card[] cards) {
        
        this.amount = amount;
        this.id = id;
        this.cards = cards;
    }
    
    //Getters
    public int getAmount() {
        
        return amount;
        
    }
    
    public Card[] getCards() {
        
        return cards;
        
    }
    
    public int getId() {
        
        return id;
        
    }
    
    //Setters
    public void setAmount(int amount) {
        
        this.amount = amount;
        
    }
    
    public void setCards(Card cards[]) {
        
        this.cards = cards;
        
    }
    
    //Sorts hand by color and rank
    public static Hand sort(Hand sortHand) {
        
        int i = 0;
        int replaceCount = 0;
        Card temp = null;
        
        while (i < sortHand.amount - 1) {
             
            for (int j = i + 1; j < sortHand.amount - 1; j++) {
                
                if (sortHand.cards[i].getColor().equals(sortHand.cards[j].getColor())) {
                    
                    temp = sortHand.cards[j];
                    sortHand.cards[j] = sortHand.cards[i + replaceCount + 1];
                    sortHand.cards[i + replaceCount + 1] = temp;
                    replaceCount++;
                    
                }
                    
            }
            
            i = i + replaceCount + 1;
                  
        }
        
        for (int j = 0; j < sortHand.amount - 1; j++) {
            
            if (sortHand.cards[j].getColor().equals(sortHand.cards[j + 1].getColor())) {
                
                if (sortHand.cards[j].getValue() > sortHand.cards[j + 1].getValue()) {
                    
                    Card temp2 = null;
                    
                    temp2 = sortHand.cards[j];
                    sortHand.cards[j] = sortHand.cards[j +1];
                    sortHand.cards[j + 1] = temp2;
                    
                }
                
            }
            
        }
        
        System.out.println("Color:\t\tValue:");
           
        for (int j = 0; j < sortHand.amount; j++) {
            
            if (sortHand.cards[j].getColor() == Color.black) {
                
                System.out.print("Black\t\t");
                
            } else if (sortHand.cards[j].getColor() == Color.blue) {
                
                System.out.print("Blue\t\t");
                
            } else if (sortHand.cards[j].getColor() == Color.red) {
                
                System.out.print("Red\t\t");
                
            } else if (sortHand.cards[j].getColor() == Color.yellow) {
                
                System.out.print("Yellow\t\t");
                
            } else {
            
                System.out.print("Green\t\t");
            
            }
            
            System.out.println(sortHand.cards[j].getValue());
            
        }
        
        return sortHand;
        
    }
    
}