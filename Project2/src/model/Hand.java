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
    
    public Hand () {
        
        amount = 0;
        
    }
    
    public int getAmount () {
        
        return amount;
        
    }
    
    public void setAmount (int amount) {
        
        this.amount = amount;
        
    }
    
}
