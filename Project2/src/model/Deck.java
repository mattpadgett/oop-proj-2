/* CS 2365 Object-Oriented Programming - Spring 2020
 * Project 2 - UNO Exercieces
 * File: Deck.Java
 * Date: 02/15/2020
 * Author: Jason Luckow - jluckow - R11560069
 * Contributors: None
 * 
 * Description: To initialize deck and manipulate
 */

package model;

public class Deck {
    int count, topIndex, num, connected, deckSize;
    private Card[] cards;
    
    public Deck(){//CONSTRUCTOR
        
        this.count = 0;
        this.topIndex = 0;  
        this.deckSize = 180;
        this.cards = new Card();
    }
    
    public Deck(int num, boolean connected){
        deckSize *= num;
        int arrayCounter = 0;
        while(arrayCounter < deckSize){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 2; k++){
                    for(int i = 0; i < 12; i++){
                        cards[deckSize] = new Card(j,i);
                    }
                }
            }
        }
        
    }
    
    //GETTERS
    public int getCount(){
        
        return count;
        
    }
    public int getTopIndex(){
        
        return topIndex;
        
    }
    
    //SETTERS
    public void setCount(int count){
        
        this.count = count;
        
    }
    public void setTopIndex(int topIndex){
        
        this.topIndex = topIndex;
        
    }
    
    //METHODS
    public void shuffle(int Deck){
        
    }
    public void draw(){
        
    }
    public void removeActionCards(){
        
    }
}
