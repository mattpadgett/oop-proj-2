package Main;


import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Hand;
import util.HTMLWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt
 */
public class Main {
    
    private Game game;
    
    /**
     *
     */
    public Main() {
        
        Scanner sc = new Scanner(System.in);
        
        int input = -1;
        
        System.out.println("\tUNO Exercise Generator");
        System.out.println("------------------------------------------------");
        
        while(true) {
        
            System.out.print("Choose your game mode.\n\t1. Normal Play\n\t2. Debug Mode (Test Cases)\n\t0. Exit\nChoice: ");

            try {

                input = sc.nextInt();
               
            } catch(InputMismatchException e) {

                System.out.println("\nInvalid input. Please try again.\n");
                sc.next();
                continue;

            }
            
            int numDecks = 0;
            boolean shuffleTogether = false;
            boolean actionCards = true;
            
            if(input == 0) {
            
                System.exit(0);
            
            }

            if(input == 1) {

                while(true) {
                    
                    System.out.print("How many decks would you like to use? (1 - 3) ");

                    try {

                        numDecks = sc.nextInt();

                    } catch(InputMismatchException e) {

                        System.out.println("Invalid input. Please try again.");
                        sc.next();
                        continue;

                    }
                
                    if(numDecks < 1 || numDecks > 3) {
                        
                        System.out.println("You must select either 1, 2, or 3 decks. Try again.");
                        continue;
                        
                    }
                    
                    break;
                    
                }              
                
                while(true) {
                    
                    System.out.print("Do you want to shuffle the cards together or seperate? 1 = Together. 0 = Seperate. ");

                    int tempInput = -1;
                    
                    try {

                        tempInput = sc.nextInt();

                    } catch(InputMismatchException e) {

                        System.out.println("Invalid input. Please try again.");
                        sc.next();
                        continue;

                    }
                
                    if(tempInput < 0 || tempInput > 1) {
                        
                        System.out.println("You must select either 1 or 0. Try again.");
                        continue;
                        
                    }
                    
                    shuffleTogether = (tempInput == 1);
                    break;
                    
                }
                
                while(true) {
                    
                    System.out.print("Would you like to include action cards? 1 = Yes. 0 = No. ");

                    int tempInput = -1;
                    
                    try {

                        tempInput = sc.nextInt();

                    } catch(InputMismatchException e) {

                        System.out.println("Invalid input. Please try again.");
                        sc.next();
                        continue;

                    }
                
                    if(tempInput < 0 || tempInput > 1) {
                        
                        System.out.println("You must select either 1 or 0. Try again.");
                        continue;
                        
                    }
                    
                    actionCards = (tempInput == 1);
                    break;
                    
                }
                
                this.game = new Game(actionCards, shuffleTogether, numDecks);
                
                
                File f = new File("HTMLOutput.html");
                HTMLWriter htmlWriter = new HTMLWriter(f, this);

                htmlWriter.beginOutputFile();

                while(true) {

                    Hand hand = game.getNextHand();

                    if(hand != null) {

                        htmlWriter.appendHand(hand);

                    } else {

                        htmlWriter.appendFinalStats(game.getStatTracker());
                        break;

                    }

                }

                htmlWriter.endOutputFile();
                System.out.println("Game complete. Resetting.\n\n");

            }

            if(input == 2) {
                
                int[] deckCounts = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
                int[] actionOpts = {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0};
                int[] shuffleOpts = {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0};
                
                //Run through all scenarios.
                                     
            }
            
            if(input < 0 || input > 2) {
                
                System.out.println("\nInvalid input. Please try again.\n");
                continue;
                
            }
        
        }
        
    }
    
    /**
     *
     * @return
     */
    public Game getGame() {
        
        return this.game;
                  
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        Main main = new Main();
        
    }
    
}
