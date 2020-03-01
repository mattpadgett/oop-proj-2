/* CS 2365 Object-Oriented Programming - Spring 2020
 * Project 2 - UNO Exercieces
 * File: Deck.Java
 * Date: 02/15/2020
 * Author: Jason Luckow - jluckow - R11560069
 * Contributors: Matt Padgett - matpadge - R11564420 (Deck constructor)
 *
 * Description: To initialize and shuffle the deck, and to draw from the deck
 */

package model;

import java.awt.Color;
import java.util.Random;
import java.util.Arrays;

public class Deck {
    
    //CREATE VARIABLES
    private int deckCardCount, topDeckIndex, numDecks, deckSize;
    private boolean connected, includeActionCards;
    private Card[] cards;
    
    
    //CONSTRUCTOR   
    public Deck (int numDecks, boolean connected, boolean includeActionCards){
        
        Color c = Color.WHITE;
        int arrayCounter = 0, rankIndex = 12;
        
        if (includeActionCards == false)
            rankIndex = 9; //LOWERS INDEX IF ACTION CARDS ARE TAKEN OUT
        
        this.cards = new Card[108 * numDecks];
        
//        switch(numDecks) {
//            
//            case 1:
//                this.cards = new Card[108];
//                break;
//            case 2:
//                this.cards = new Card[216];
//                break;
//            case 3:
//                this.cards = new Card[324];
//                break;
//            
//        }
        
        Arrays.fill(cards, new Card(Color.MAGENTA, -1));
        
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
                
                if(includeActionCards == true){
                    
                    cards[arrayCounter] = new Card (Color.BLACK, 13);//WILD
                    arrayCounter++;
                    cards[arrayCounter] = new Card (Color.BLACK, 14);//WILD DRAW FOUR
                    arrayCounter++;
                    
                }

                for (int k = 0; k < 2; k++){//EACH COLOR HAS TWO RANKS

                    for (int i = 1; i <= rankIndex; i++){//RANK LOOP

                        cards[arrayCounter] = new Card(c,i);
                        arrayCounter++;
                        
                    }    
                }    
            }  
            
            if(connected == false){
                
                shuffle(cards);
                
            }
        }
        if(connected == true){
            
            shuffle(cards);//SHUFFLES CARDS THAT WERE JUST CREATED
        
        }
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
    
    public Card[] getDeck() {
        
        return cards;
        
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
            //System.out.println(cards[t].getValue());
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
            
            drawForHand[h] = cards[getTopDeckIndex() - 1];
            cards[getTopDeckIndex() - 1] = null;
            this.setTopDeckIndex(getTopDeckIndex() - 1);
            
        }
    
        return new Hand(drawForHand);
        
    }
    
    public void addToBottom(Card[] cardsToBottom){
        
        int sizeImport = cardsToBottom.length;
        
        for(int m = getTopDeckIndex(); m >= 0; m--){
            
            cards[m + sizeImport] = cards[m];
            
        }
        
        for(int r = 0; r < sizeImport; r++){
            
            cards[r] = cardsToBottom[r];
            
        }
        
    }
    
    public static void main(String[] args) {
        
        Deck deck = new Deck(1, false, true);
        
        deck.draw();
        
        for(int i = 0; i < deck.getTopDeckIndex(); i++) {

            System.out.print(deck.getDeck()[i].getValue() + ", ");
            
        }
        
        System.out.println();
        
        Card[] botCard = {new Card(Color.RED, 9), new Card(Color.BLUE, 9)};
        
        deck.addToBottom(botCard);
        
        for(int i = 0; i < deck.getTopDeckIndex(); i++) {
            
            System.out.print(deck.getDeck()[i].getValue());
            
        }
        
    }
    
}