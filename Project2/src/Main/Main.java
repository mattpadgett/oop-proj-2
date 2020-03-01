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
    
    public static void main(String[] args) {
        
        File f = new File("HTMLOutput.html");
        f.delete();
        
        Scanner sc = new Scanner(System.in);
        
        int input = -1;
        
        /*while(input != 0) {
        
            System.out.println("\tUNO Exercise Generator!!");
            System.out.println("------------------------------------------------");

            System.out.println("Choose your game mode.\n  1. Normal Play\n  2. Debug Mode\n\n  0. Exit");

            try {

                input = sc.nextInt();

            } catch(InputMismatchException e) {

                System.out.println("Invalid input. Try again.");
                sc.next();
                continue;

            }
            
            break;
        
        }
        
        int numDecks = 0;
        boolean shuffleTogether = false;
        boolean actionCards = true;
        
        if(input == 1) {
            
            System.out.print("How many decks would you like to use? (1 - 3) ");
            numDecks = sc.nextInt();
            System.out.print("\nDo you want to shuffle the cards together or seperate? 1 = Together. 0 = Seperate. ");
            shuffleTogether = (sc.nextInt() == 1);
            System.out.print("\nWould you like to include action cards? 1 = Yes. 0 = No. ");
            actionCards = (sc.nextInt() == 1);
            
            
        }*/
        
        //Game game = new Game(actionCards, shuffleTogether, numDecks);
        Game game = new Game(true, true, 1);
        HTMLWriter.beginOutputFile();
        
        while(true) {
            
            Hand hand = game.getNextHand();
            
            if(hand != null) {
                
                HTMLWriter.appendHand(hand);
                
            } else {
                
                HTMLWriter.appendFinalStats(game.getStatTracker());
                break;
                
            }
            
        }
        
        HTMLWriter.endOutputFile();
        
    }
    
}