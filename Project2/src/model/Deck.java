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

import Main.Game;
import java.awt.Color;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author matt
 */
public class Deck {
    
    //CREATE VARIABLES
    private int deckCardCount = 0, topDeckIndex = 0, numDecks = 0, deckSize = 0;
    private boolean connected = false, includeActionCards = false;
    private Card[] cards = null;
    private Game game = null;
    
    
    //CONSTRUCTOR   

    /**
     *
     * @param numDecks
     * @param connected
     * @param includeActionCards
     * @param game
     */
    public Deck (int numDecks, boolean connected, boolean includeActionCards, Game game){
       
        this.game = game;
        Color c = Color.WHITE;
        int arrayCounter = 0, rankIndex = 12;
        
        if (includeActionCards == false){
            
            rankIndex = 9; //LOWERS INDEX IF ACTION CARDS ARE TAKEN OUT
            this.cards = new Card[108 * numDecks - (32 * numDecks)];
            
        } else {
            
            this.cards = new Card[108 * numDecks];
            
        }
        
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
                    case 3:
                        c = Color.RED;
                        break;  
                        
                }
                
                cards[arrayCounter] = new Card (c, 0);//ZERO ONLY HAS ONE RANK
                arrayCounter++;  
                //System.out.println(includeActionCards);
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
                
                //shuffle();
                
            }
            
        }
        
        if(connected == true){
            
            shuffle();//SHUFFLES CARDS THAT WERE JUST CREATED
        
        }
        
        
        
        this.setDeckSize(arrayCounter);//METHOD OVERLOADING
        this.setDeckCardCount(arrayCounter);//METHOD OVERLOADING
        this.setTopDeckIndex(arrayCounter);
        
    }
    
    /**
     *
     * @param deck
     */
    public static void printDeck(Deck deck) {
        
        System.out.println("Color:\t\tValue:");
           
        for(int i = 0; i < deck.getTopDeckIndex(); i++) {
            
            System.out.println(deck.getDeck()[i].getColor().toString() + "\t" + deck.getDeck()[i].getValue());
            
        }
        
    }
    
    //GETTERS

    /**
     *
     * @return
     */
    public int getDeckCardCount(){
        
        return deckCardCount;
        
    }
    
    /**
     *
     * @return
     */
    public int getTopDeckIndex(){
        
        return topDeckIndex;
        
    }
    
    /**
     *
     * @return
     */
    public int getDeckSize(){
        
        return deckSize;
        
    }
    
    /**
     *
     * @return
     */
    public Card[] getDeck() {
        
        return cards;
        
    }
    
    //SETTERS

    /**
     *
     * @param deckCardCount
     */
    public void setDeckCardCount(int deckCardCount){
        
        this.deckCardCount = deckCardCount;
        
    }
    
    /**
     *
     * @param topDeckIndex
     */
    public void setTopDeckIndex(int topDeckIndex){
        
        this.topDeckIndex = topDeckIndex;
        
    }
    
    /**
     *
     * @param deckSize
     */
    public void setDeckSize(int deckSize){
        
        this.deckSize = deckSize;
        
    }
    
    
    //METHODS
    private void shuffle(){
        
        Random rand = new Random();
        
        if(connected && numDecks == 1) {
            
            for(int t = 0; t < cards.length; t++){
            
                int randomIndexSwap = rand.nextInt(cards.length);

                Card temp = cards[randomIndexSwap];
                cards[randomIndexSwap] = cards[t];
                cards[t] = temp;
            
            } 
            
            return;
            
        }
        
        if(numDecks > 0) {
            
            if(includeActionCards) {
                
                for(int t = 0; t < 108; t++){
            
                    int randomIndexSwap = rand.nextInt(108);

                    Card temp = cards[randomIndexSwap];
                    cards[randomIndexSwap] = cards[t];
                    cards[t] = temp;

                }
                
            } else {
                
                for(int t = 0; t < 76; t++){
            
                    int randomIndexSwap = rand.nextInt(76);

                    Card temp = cards[randomIndexSwap];
                    cards[randomIndexSwap] = cards[t];
                    cards[t] = temp;

                }
                
            } 
            
        }
            
        if(numDecks > 1) {
            
            if(includeActionCards) {
                
                for(int t = 108; t < 108+108; t++){
            
                    int randomIndexSwap = rand.nextInt(108) + 108;

                    Card temp = cards[randomIndexSwap];
                    cards[randomIndexSwap] = cards[t];
                    cards[t] = temp;

                }
                
            } else {
                
                for(int t = 76; t < 76+76; t++){
            
                    int randomIndexSwap = rand.nextInt(76)+76;

                    Card temp = cards[randomIndexSwap];
                    cards[randomIndexSwap] = cards[t];
                    cards[t] = temp;

                }
                
            }
            
        }
        
        if(numDecks > 2) {
            
            if(includeActionCards) {
                
                for(int t = 108+108; t < 108+108+108; t++){
            
                    int randomIndexSwap = rand.nextInt(108) + 108 + 108;

                    Card temp = cards[randomIndexSwap];
                    cards[randomIndexSwap] = cards[t];
                    cards[t] = temp;

                }
                
            } else {
                
                for(int t = 76+76; t < 76+76+76; t++){
            
                    int randomIndexSwap = rand.nextInt(76)+76+76;

                    Card temp = cards[randomIndexSwap];
                    cards[randomIndexSwap] = cards[t];
                    cards[t] = temp;

                }
                
            }
            
        }
        
    }
    
    /**
     *
     * @return
     */
    public Hand draw(){

        if(this.topDeckIndex == 0) {
            
            return null;
            
        }
        
        Card[] drawForHand;
        
        if(this.topDeckIndex > 6) {
            
            drawForHand = new Card[7];
            
        } else {
            
            //setTopDeckIndex(3);
            drawForHand = new Card[this.topDeckIndex % 7];
            //System.out.println(this.topDeckIndex % 7);
            
        }

        //Arrays.fill(drawForHand, null);
        
        for(int i = 0; i < drawForHand.length; i++){
            
            int index = getTopDeckIndex() - 1;
            
            drawForHand[i] = this.cards[index];
            this.cards[index] = null;
            //System.out.println(getTopDeckIndex());
            this.setTopDeckIndex(index);
            
        }
        
        Hand hand = new Hand(drawForHand, game);
        
        hand.printHand(hand);
        
    //    hand = Hand.sort(hand);
        
        return hand;
        
    }
    
    /**
     *
     * @param cardsToBottom
     */
    public void addToBottom(Card[] cardsToBottom){
        
        int sizeImport = cardsToBottom.length;
        //System.out.println(sizeImport);
        //Hand nhand = new Hand(cards, game);
        System.out.println("deck index: " + getTopDeckIndex() + "\t" + "sizeImport: "+ sizeImport);
        //nhand.printHand(nhand);
        for(int m = getTopDeckIndex(); m >= 0; m--){
            
            cards[m + sizeImport] = cards[m];
            
        }
        
        //nhand.printHand(nhand);
        
        for(int r = 0; r < sizeImport; r++){
            
            if(cardsToBottom[r] != null) {
                
                cards[r] = cardsToBottom[r];    
                setTopDeckIndex(getTopDeckIndex() + 1);
                
            }
            
        }
        
        //setTopDeckIndex(getTopDeckIndex() + sizeImport);
        
        
        
    }
    
}