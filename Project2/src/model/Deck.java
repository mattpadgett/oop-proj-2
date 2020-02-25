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
import java.awt.Color;

public class Deck {
    int count, topIndex, num, deckSize;
    boolean connected, includeActionCards;
    private Card[] cards;
    
    public Deck (){//CONSTRUCTOR
        
        this.count = 0;
        this.topIndex = 0;  
        this.deckSize = 108;
        this.cards = new Card[324];
        this.includeActionCards = true;
        
    }
    
    public Deck (int numDecks, boolean connected, boolean includeActionCards){
        
        deckSize *= numDecks;
        Color c = Color.WHITE;
        int arrayCounter = 0;
        
        for (int m = 0; m <= numDecks; m++){

            for (int j = 0; j <= 4; j++){ //LOOP FOR EACH COLOR

                switch (j){

                    case 0:
                        c = Color.BLUE;
                        break;
                    case 1:
                        c = Color.GREEN;
                        break;
                    case 2:
                        c = Color.YELLOW;
                        break;
                    case 4:
                        c = Color.RED;
                        break;  
                        
                }

                cards[arrayCounter] = new Card (c, 0);//ZERO ONLY HAS ONE RANK
                arrayCounter++;
                
                if (includeActionCards == true){
                    
                    cards[arrayCounter] = new Card (Color.BLACK, 13);//WILD
                    arrayCounter++;
                    cards[arrayCounter] = new Card (Color.BLACK, 14);//WILD DRAW FOUR
                    arrayCounter++;
                    
                }

                for (int k = 0; k <= 2; k++){//EACH COLOR HAS TWO RANKS

                    for (int i = 1; i <= 12; i++){//RANK LOOP

                        cards[arrayCounter] = new Card(c,i);
                        arrayCounter++;
                        
                    }    
                }    
            }   
        }
    }
    
    //GETTERS
    public int getCount(){
        
        return count;
        
    }
    public int getTopIndex (){
        
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