/*
 * CS 2365 Object-Oriented Programming - Spring 2020
 * Project 2 - UNO Excercises
 * File: Hand.java
 * Date: 2/15/2020
 * Author: Coby Kromis - cobykromis - R11567402
 * 
 * Description: Class for sorting the hand and determining how many excercises will be done and skipped
 */
package model;

import java.awt.Color;

public class Hand {
    
    //Attribute initialization
    private int id;
    private Card[] cards;
    
    //Constructor
    public Hand (int id, Card[] cards) {
        
        this.id = id;
        this.cards = cards;
        
    }
    
    //Getters
    
    public Card[] getCards() {
        
        return cards;
        
    }
    
    public int getId() {
        
        return id;
        
    }
    
    public static void printHand(Hand printHand) {
        
        System.out.println("Color:\t\tValue:");
           
        for (int j = 0; j < printHand.getCards().length; j++) {
            
            if (printHand.cards[j].getColor() == Color.black) {
                
                System.out.print("Black\t\t");
                
            } else if (printHand.cards[j].getColor() == Color.blue) {
                
                System.out.print("Blue\t\t");
                
            } else if (printHand.cards[j].getColor() == Color.red) {
                
                System.out.print("Red\t\t");
                
            } else if (printHand.cards[j].getColor() == Color.yellow) {
                
                System.out.print("Yellow\t\t");
                
            } else if (printHand.cards[j].getColor() == Color.green) {
            
                System.out.print("Green\t\t");
            
            }
            
            System.out.println(printHand.cards[j].getValue());
            
        }
        
        System.out.println("");
        
    }
    //Sorts hand by color and rank
    public static Hand sort(Hand sortHand) {
        
        int i = 0;
        int replaceCount = 0;
        Card temp = null;
        
        while (i < sortHand.getCards().length - 1) {
            
            for (int j = i + 1; j < sortHand.getCards().length; j++) {                
                
                if (sortHand.cards[i].getColor().equals(sortHand.cards[j].getColor())) {
                    
                    for (int k = i; k < sortHand.getCards().length; k++) {
                        
                        if (!sortHand.cards[i].getColor().equals(sortHand.cards[k].getColor())) {
                            
                            temp = sortHand.cards[j];
                            sortHand.cards[j] = sortHand.cards[k];
                            sortHand.cards[k] = temp;
                        
                        }
                    
                    }
                    
                    replaceCount++;
                    
                }
                
            }
            
            i = i + replaceCount + 1;
            replaceCount = 0;
                  
        }
        
        for (int j = 0; j < sortHand.getCards().length - 1; j++) {
            
            if (sortHand.cards[j].getColor().equals(sortHand.cards[j + 1].getColor())) {
                
                if (sortHand.cards[j].getValue() > sortHand.cards[j + 1].getValue()) {
                    
                    Card temp2 = null;
                    
                    temp2 = sortHand.cards[j];
                    sortHand.cards[j] = sortHand.cards[j +1];
                    sortHand.cards[j + 1] = temp2;
                    
                }
                
            }
            
        }
        
        return sortHand;
        
    }
    
    public static int[] interpret(Hand interpretHand) {
        
        int[] exerciseNum = new int[5];
        int sitUp = 0, lunge = 0, squat = 0, pushUp = 0, burpee = 0, wildCount = 0, wild4Count = 0;
        
        for (int i = 0; i < interpretHand.getCards().length; i++) {
            
            if (interpretHand.cards[i].getColor() == Color.black) {
                
                if (interpretHand.cards[i].getValue() == 13) {
                    
                    wildCount++;
    
                } else if (interpretHand.cards[i].getValue() == 14) {
                    
                    wild4Count++;
                    
                }
                
            }
            
            if (interpretHand.cards[i].getValue() < 10) {
                
                if (interpretHand.cards[i].getColor() == Color.red) {

                    sitUp = sitUp + interpretHand.cards[i].getValue();
                    
                } else if (interpretHand.cards[i].getColor() == Color.blue) {

                    pushUp = pushUp + interpretHand.cards[i].getValue();
                    
                } else if (interpretHand.cards[i].getColor() == Color.yellow) {

                    squat = squat + interpretHand.cards[i].getValue();
                    
                } else if (interpretHand.cards[i].getColor() == Color.green) {

                    lunge = lunge + interpretHand.cards[i].getValue();
                    
                }
                    
            }
            
            else if (interpretHand.cards[i].getValue() == 10) {
                
                if (interpretHand.cards[i].getColor() == Color.red) {

                    sitUp = 0;
                    
                } else if (interpretHand.cards[i].getColor() == Color.blue) {

                    pushUp = 0;
                    
                } else if (interpretHand.cards[i].getColor() == Color.yellow) {

                    squat = 0;
                    
                } else if (interpretHand.cards[i].getColor() == Color.green) {

                    lunge = 0;
                    
                }
                
            } else if (interpretHand.cards[i].getValue() == 11) {
                
                if (interpretHand.cards[i].getColor() == Color.red) {

                    sitUp = sitUp * 2;
                    
                } else if (interpretHand.cards[i].getColor() == Color.blue) {

                    pushUp = pushUp * 2;
                    
                } else if (interpretHand.cards[i].getColor() == Color.yellow) {

                    squat = squat * 2;
                    
                } else if (interpretHand.cards[i].getColor() == Color.green) {

                    lunge = lunge * 2;
                    
                }
                
            } else if (interpretHand.cards[i].getValue() == 12) {
                
                if (interpretHand.cards[i].getColor() == Color.red) {

                    sitUp = 0;
                    
                } else if (interpretHand.cards[i].getColor() == Color.blue) {

                    pushUp = 0;
                    
                } else if (interpretHand.cards[i].getColor() == Color.yellow) {

                    squat = 0;
                    
                } else if (interpretHand.cards[i].getColor() == Color.green) {

                    lunge = 0;
                    
                }
                
            }
                
        }
        
        int multiFactor = 4 * wild4Count;
        burpee = (10 * wildCount) + (10 * wild4Count);
        sitUp = sitUp * multiFactor;
        pushUp = pushUp * multiFactor;
        squat = squat * multiFactor;
        lunge = lunge * multiFactor;
        
        exerciseNum[0] = pushUp;
        exerciseNum[1] = squat;
        exerciseNum[2] = sitUp;
        exerciseNum[3] = lunge;
        exerciseNum[4] = burpee;
        return exerciseNum;
        
    }
    
}