/* CS 2365 Object-Oriented Programming - Spring 2020
 * Project 2 - UNO Excercises
 * File: Hand.java
 * Date: 2/15/2020
 * Author: Coby Kromis - cobykromis - R11567402
 * 
 * Description: Class for sorting the hand and determining how many excercises will be done and skipped
 */
package model;

import Main.Game;
import java.awt.Color;
import java.util.Random;

/*
Blue - PushUps
Yellow - Squat
Red - SitUps
Green - Lunges
Black - Burpees
0 - 1 Minute Break
1-9 - Integer value
10 - Skip (exercise num = 0)
11 - Draw 2 (double exercise num)
12 - Reverse (exercise num = 0, return cards of the color to bottom of the deck)
13 - +10 burpees
14 - +10 burpees and all exercises times 4
*/

/**
 *
 * @author matt
 */


public class Hand {
    
    //Attribute initialization
    private static int nextId = 1;
    private int id;
    private Card[] cards;
    private Game game;
    
    //Constructor

    /**
     *
     * @param cards
     * @param game
     */
    public Hand(Card[] cards, Game game) {
        
        this.id = nextId;
        this.nextId++;
        this.cards = cards;
        this.game = game;
        
    }
    
    //Getters

    /**
     *
     * @return
     */
    
    public Card[] getCards() {
        
        return cards;
        
    }
    
    /**
     *
     * @return
     */
    public int getId() {
        
        return id;
        
    }
    
    /**
     *
     * @param printHand
     */
    public static void printHand(Hand printHand) {
        
        System.out.println("\nHand ID: " + printHand.id);
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
        
    }
    
    //Sorts hand by color and rank

    /**
     *
     * @param sortHand
     * @return
     */
    public static Hand sort(Hand sortHand) {
        
        int i = 0;
        int replaceCount = 0;
        Card temp = null;
        
        while (i < sortHand.getCards().length) {
            
            for (int j = i + 1; j < sortHand.getCards().length; j++) {                
                
                if (!sortHand.cards[i].getColor().equals(sortHand.cards[j].getColor())) {
                    
                    for (int k = j; k < sortHand.getCards().length; k++) {
                        
                        if (sortHand.cards[i].getColor().equals(sortHand.cards[k].getColor())) {
                            
                            temp = sortHand.cards[j];
                            sortHand.cards[j] = sortHand.cards[k];
                            sortHand.cards[k] = temp;
                            j++;
                            replaceCount++;
                            
                        }
                    
                    }
                    
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
    
    /**
     *
     * @return
     */
    public int[] interpret() {
        
        int[] exerciseNum = new int[9];
        Card[] botPile = new Card[6];
        int sitUp = 0, lunge = 0, squat = 0, pushUp = 0, burpee = 0, wildCount = 0, wild4Count = 0;
        int PushUpSkipNum = 0, SitUpSkipNum = 0, SquatSkipNum = 0, LungeSkipNum = 0, count = 0;
        int PushUpBreakNum = 0, SitUpBreakNum = 0, SquatBreakNum = 0, LungeBreakNum = 0;
        
        sort(this);
        
        for (int i = 0; i < cards.length; i++) {
            
            if (cards[i].getColor() == Color.black) {
                
                if (cards[i].getValue() == 13) {
                    
                    wildCount++;
    
                } else if (cards[i].getValue() == 14) {
                    
                    wild4Count++;
                    
                }
                
            }
            
            if (cards[i].getValue() == 0) {
                
                if (cards[i].getColor() == Color.red) {
                    
                    PushUpBreakNum++;
                    
                }
                
                if (cards[i].getColor() == Color.yellow) {
                    
                    SquatBreakNum++;
                    
                }
                
                if (cards[i].getColor() == Color.blue) {
                    
                    SitUpBreakNum++;
                    
                }
                
                if (cards[i].getColor() == Color.green) {
                    
                    LungeBreakNum++;
                    
                }
                
            }
            
            if (cards[i].getValue() < 10 && cards[i].getValue() > 0) {
                
                if (cards[i].getColor() == Color.red) {

                    sitUp = sitUp + cards[i].getValue();
                    
                } else if (cards[i].getColor() == Color.blue) {

                    pushUp = pushUp + cards[i].getValue();
                    
                } else if (cards[i].getColor() == Color.yellow) {

                    squat = squat + cards[i].getValue();
                    
                } else if (cards[i].getColor() == Color.green) {

                    lunge = lunge + cards[i].getValue();
                    
                }
                    
            } else if (cards[i].getValue() == 10) {
                
                if (cards[i].getColor() == Color.red) {

                    SitUpSkipNum = SitUpSkipNum + sitUp;
                    sitUp = 0;
                    
                } else if (cards[i].getColor() == Color.blue) {

                    PushUpSkipNum = PushUpSkipNum + pushUp;
                    pushUp = 0;
                    
                } else if (cards[i].getColor() == Color.yellow) {

                    SquatSkipNum = SquatSkipNum + squat;
                    squat = 0;
                    
                } else if (cards[i].getColor() == Color.green) {

                    LungeSkipNum = LungeSkipNum + lunge;
                    lunge = 0;
                    
                }
                
            } else if (cards[i].getValue() == 11) {
                
                if (cards[i].getColor() == Color.red) {

                    sitUp = sitUp * 2;
                    
                } else if (cards[i].getColor() == Color.blue) {

                    pushUp = pushUp * 2;
                    
                } else if (cards[i].getColor() == Color.yellow) {

                    squat = squat * 2;
                    
                } else if (cards[i].getColor() == Color.green) {

                    lunge = lunge * 2;
                    
                }
                
            } else if (cards[i].getValue() == 12) {
                
                if (cards[i].getColor() == Color.red) {

                    SitUpSkipNum = SitUpSkipNum + sitUp;
                    sitUp = 0;
                    
                    for (int j = 0; j < cards.length; j++) {
                        
                        if (cards[j].getColor() == Color.red && cards[j].getValue() != 12) {
                            
                            botPile[count] = cards[j];
                            count++;
                            
                        }
                        
                    }
                    
                    game.getDeck().addToBottom(botPile);
                    
                } else if (cards[i].getColor() == Color.blue) {

                    PushUpSkipNum = PushUpSkipNum + pushUp;
                    pushUp = 0;
                    
                    for (int j = 0; j < cards.length; j++) {
                        
                        if (cards[j].getColor() == Color.blue && cards[j].getValue() != 12) {
                            
                            botPile[count] = cards[j];
                            count++;
                            
                        }
                        
                    }
                    
                    game.getDeck().addToBottom(botPile);
                    
                } else if (cards[i].getColor() == Color.yellow) {

                    SquatSkipNum = SquatSkipNum + squat;
                    squat = 0;
                    
                    for (int j = 0; j < cards.length; j++) {
                        
                        if (cards[j].getColor() == Color.yellow && cards[j].getValue() != 12) {
                            
                            botPile[count] = cards[j];
                            count++;
                            
                        }
                        
                    }
                    
                    game.getDeck().addToBottom(botPile);
                    
                } else if (cards[i].getColor() == Color.green) {

                    LungeSkipNum = LungeSkipNum + lunge;
                    lunge = 0;
                    
                    for (int j = 0; j < cards.length; j++) {
                        
                        if (cards[j].getColor() == Color.green && cards[j].getValue() != 12) {
                            
                            botPile[count] = cards[j];
                            count++;
                            
                        }
                        
                    }
                    
                    game.getDeck().addToBottom(botPile);
                    
                }
                
            }
                
        }        
        
        int multiFactor = 4 * wild4Count;
        burpee = (10 * wildCount) + (10 * wild4Count);
        
        if (multiFactor != 0) {
            
            sitUp = sitUp * multiFactor;
            pushUp = pushUp * multiFactor;
            squat = squat * multiFactor;
            lunge = lunge * multiFactor;
        
        }
        
        exerciseNum[0] = pushUp;
        exerciseNum[1] = squat;
        exerciseNum[2] = sitUp;
        exerciseNum[3] = lunge;
        exerciseNum[4] = burpee;
        exerciseNum[5] = PushUpBreakNum;
        exerciseNum[6] = SquatBreakNum;
        exerciseNum[7] = SitUpBreakNum;
        exerciseNum[8] = LungeBreakNum;
        
        int[] skips = new int[4];
        skips[0] = PushUpSkipNum;
        skips[1] = SquatSkipNum;
        skips[2] = SitUpSkipNum;
        skips[3] = LungeSkipNum;
        
        this.game.getStatTracker().updateStats(exerciseNum, skips);
        
        return exerciseNum;
        
    }
    
    /**
     *
     * @param exerciseNum
     */
    public static void printReps(int[] exerciseNum) {
        
        System.out.println("Push Ups:\t" + exerciseNum[0]);
        System.out.println("Squats:\t\t" + exerciseNum[1]);
        System.out.println("Sit Ups:\t" + exerciseNum[2]);
        System.out.println("Lunges:\t\t" + exerciseNum[3]);
        System.out.println("Burpees:\t" + exerciseNum[4]);
        System.out.println("Push Up Breaks:\t" + exerciseNum[5]);
        System.out.println("Squat Breaks:\t" + exerciseNum[6]);
        System.out.println("Sit Ups Breaks:\t" + exerciseNum[7]);
        System.out.println("Lunge Breaks:\t" + exerciseNum[8]);
        
    }
    
}