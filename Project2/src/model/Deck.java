/* CS 2365 Object-Oriented Programming - Spring 2020
 * Project 2 - UNO Exercieces
 * File: Deck.Java
 * Date: 02/15/2020
 * Author: Jason Luckow - jluckow - R11560069
 * Contributors: None
 *
 * Description: To initialize and shuffle the deck, and to draw from the deck
 */

package model;

import java.util.Random;
import java.awt.Color;

public class Deck {
    
    //CREATE VARIABLES
    int deckCardCount, topDeckIndex, numDecks, deckSize;
    boolean connected, includeActionCards;
    private Card[] cards;
    
    
    //CONSTRUCTOR
    public Deck (){
        
        this.deckCardCount = 0;
        this.topDeckIndex = 0;  
        this.numDecks = 1;
        this.deckSize = 108;
        this.cards = new Card[324];
        this.connected = true;
        this.includeActionCards = true;
        
    }
    
    
    //CLASS
    public Deck (int numDecks, boolean connected, boolean includeActionCards){
        
        Color c = Color.WHITE;
        int arrayCounter = 0, rankIndex = 12;
        
        if (includeActionCards == false)
            rankIndex = 9; //LOWERS INDEX IF ACTION CARDS ARE TAKEN OUT
        
        for (int m = 0; m < numDecks; m++){

            for (int j = 0; j < 4; j++){ //LOOP FOR EACH COLOR

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
                cards[arrayCounter] = new Card (Color.BLACK, 13);//WILD
                arrayCounter++;
                cards[arrayCounter] = new Card (Color.BLACK, 14);//WILD DRAW FOUR
                arrayCounter++;

                for (int k = 0; k < 2; k++){//EACH COLOR HAS TWO RANKS

                    for (int i = 1; i < rankIndex; i++){//RANK LOOP

                        cards[arrayCounter] = new Card(c,i);
                        arrayCounter++;
                        
                    }    
                }    
            }   
        }
         
        shuffle(cards);//SHUFFLES CARDS THAT WERE JUST CREATED
        this.setDeckSize(arrayCounter);//METHOD OVERLOADING
        this.setDeckCardCount(arrayCounter);//METHOD OVERLOADING
        this.setTopDeckIndex(arrayCounter);
        
    }
    
    
    //GETTERS
    public int getDeckCardCount(){
        
        return deckCardCount;
        
    }
    
    public int getTopDeckIndex(){
        
        return topDeckIndex;
        
    }
    
    public int getDeckSize(){
        
        return deckSize;
        
    }
    
    
    //SETTERS
    public void setDeckCardCount(int deckCardCount){
        
        this.deckCardCount = deckCardCount;
        
    }
    
    public void setTopDeckIndex(int topDeckIndex){
        
        this.topDeckIndex = topDeckIndex;
        
    }
    
    public void setDeckSize(int deckSize){
        
        this.deckSize = deckSize;
        
    }
    
    
    //METHODS
    public static void shuffle(Card[] cards){
        
        Random rand = new Random();
        
        for(int t = 0; t < cards.length; t++){
            
            int randomIndexSwap = rand.nextInt(cards.length);
            
            Card temp = cards[randomIndexSwap];
            cards[randomIndexSwap] = cards[t];
            cards[t] = temp;
            
        }
    }
    
    public Hand draw(){
        
        Card[] drawForHand;
        drawForHand = new Card[7];
        
        for (int h = 0; h < 7; h++){
            
            drawForHand[h] = cards[getTopDeckIndex()];
            this.setTopDeckIndex(getTopDeckIndex() - 1);
            
        }
        
    }
    
    return new Hand(drawForHand);
    
}