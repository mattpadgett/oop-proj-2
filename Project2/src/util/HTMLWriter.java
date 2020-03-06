/* CS 2365 Object-Oriented Programming - Spring 2020
 * Project 2 - UNO Exercises
 * File: HTMLWriter.java
 * Date: 02/15/2020
 * Author: Matthew Padgett - matpadge - R11564420
 * Contributors: None.
 *
 * Description: A grouping of static methods to append to an output HTML file. This does not include styling.
 */

package util;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Card;
import model.Hand;

/**
 *
 * @author matt
 */
public class HTMLWriter {
    
    private Main.Main main;
    private File outputFile;
    
    /**
     * HTMLWriter constructor to initialize any objects and variables needed.
     * @param outputFile File object for storing the output of the code.
     * @param main Reference to the Main object.
     */
    public HTMLWriter(File outputFile, Main.Main main) {
        
        this.outputFile = outputFile;
        this.main = main;
        
        outputFile.delete();
        
    }
    
    /**
     * Function to append a Hand from the Game class to the HTML output file.
     * @param hand Hand object from the Game class.
     */
    public void appendHand(Hand hand) {
        
        FileWriter o = null;
        
        int[] reps = hand.interpret();
        
        try {
            
            o = new FileWriter(this.outputFile, true);
         
            o.write("<div class = 'hand'>");
                                                 
            o.write("<h2>Hand " + hand.getId()  + "</h2>");
            o.write("<p>Cards Remaining: " + this.main.getGame().getDeck().getTopDeckIndex() + "</p><hr/>");
            
            for(int i = 0; i < hand.getCards().length; i++) {

                String output = "";

                if(hand.getCards()[i].getColor().equals(Color.BLACK)) {

                    output = "<div class = 'card'><div class = 'inner black'><span class = 'number'>[NUM]</span></div></div>";

                }

                if(hand.getCards()[i].getColor().equals(Color.BLUE)) {

                   output = "<div class = 'card'><div class = 'inner blue'><span class = 'number'>[NUM]</span></div></div>";

                }

                if(hand.getCards()[i].getColor().equals(Color.RED)) {

                    output = "<div class = 'card'><div class = 'inner red'><span class = 'number'>[NUM]</span></div></div>";

                }

                if(hand.getCards()[i].getColor().equals(Color.YELLOW)) {

                    output = "<div class = 'card'><div class = 'inner yellow'><span class = 'number'>[NUM]</span></div></div>";

                }

                if(hand.getCards()[i].getColor().equals(Color.GREEN)) {

                    output = "<div class = 'card'><div class = 'inner green'><span class = 'number'>[NUM]</span></div></div>";

                }

                if(hand.getCards()[i].getValue() < 10) {

                    output = output.replace("[NUM]", String.valueOf(hand.getCards()[i].getValue()));

                }

                if(hand.getCards()[i].getValue() == 10) {

                    output = output.replace("span class = 'number'>", "span class = 'number' style = 'top: 50%'>");
                    output = output.replace("[NUM]", "\u20E0");

                }

                if(hand.getCards()[i].getValue() == 11) {

                    output = output.replace("span class = 'number'>", "span class = 'number' style = 'font-size: 50px; top: 80%;'>");
                    output = output.replace("[NUM]", "D2");

                }

                if(hand.getCards()[i].getValue() == 12) {

                    output = output.replace("span class = 'number'>", "span class = 'number' style = 'top: 50%'>");
                    output = output.replace("[NUM]", "\u27F2");

                }

                if(hand.getCards()[i].getValue() == 13) {

                    output = output.replace("[NUM]", "W");

                }

                if(hand.getCards()[i].getValue() == 14) {

                    output = output.replace("span class = 'number'>", "span class = 'number' style = 'font-size: 50px; top: 80%;'>");
                    output = output.replace("[NUM]", "W4");

                }

                o.write(output);

            }
            
            o.write("<ul><li>Pushups: " + reps[0] + "</li>");
            o.write("<li>Squats: " + reps[1] + "</li>");
            o.write("<li>Situps: " + reps[2] + "</li>");
            o.write("<li>Lunges: " + reps[3] + "</li>");
            o.write("<li>Burpees: " + reps[4] + "</li></ul>");
            
            o.write("</div>");
            
            
            o.close();
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
    /**
     * Function to append the final statistics to the HTML file before closing the output.
     * @param stats StatTracker object from Game.
     */
    public void appendFinalStats(StatTracker stats) {
        
        FileWriter output = null;
        
        try {
            
            output = new FileWriter(this.outputFile, true);
            
            output.write("<div class = 'hand' id = 'final'><h2>Final Statistics</h2>");
            output.write("<a href = '#top' id = 'topButton'>Jump to Top</a>");
            output.write("<hr/>");
            output.write("<p>Repetitions per Exercise</p>");
            output.write("<ul>");
            output.write("<li>Pushups: " + stats.getReps()[0] + "</li>");
            output.write("<li>Squats: " + stats.getReps()[1] + "</li>");
            output.write("<li>Situps: " + stats.getReps()[2] + "</li>");
            output.write("<li>Lunges: " + stats.getReps()[3] + "</li>");
            output.write("<li>Burpees: " + stats.getReps()[4] + "</li>");            
            output.write("</ul>");
            
            output.write("<ul>");
            output.write("<p>Total Repetitions per Execise Skipped</p>");
            output.write("<li>Pushups: " + stats.getSkips()[0] + "</li>");
            output.write("<li>Squats: " + stats.getSkips()[1] + "</li>");
            output.write("<li>Situps: " + stats.getSkips()[2] + "</li>");
            output.write("<li>Lunges: " + stats.getSkips()[3] + "</li>");
            output.write("<li>Burpees: " + stats.getSkips()[4] + "</li>");       
            output.write("</ul>");
            
            output.write("<ul>");
            output.write("<p>Biggest Repetitions per Execise per Hand</p>");
            output.write("<li>Pushups: " + stats.getBiggestReps()[0] + "</li>");
            output.write("<li>Squats: " + stats.getBiggestReps()[1] + "</li>");
            output.write("<li>Situps: " + stats.getBiggestReps()[2] + "</li>");
            output.write("<li>Lunges: " + stats.getBiggestReps()[3] + "</li>");
            output.write("<li>Burpees: " + stats.getBiggestReps()[4] + "</li>");       
            output.write("</ul>");
            output.write("</div>");
            
            output.close();
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
    /**
     * Function to begin the output file with the required header information.
     */
    public void beginOutputFile() {
        
        FileWriter output = null;
        
        try {
            
            output = new FileWriter(this.outputFile, true);
            
            output.write("<html>");
            output.write("<head>");
            output.write("<link rel='stylesheet' type='text/css' href='style.css'>");
            output.write("<link href = 'https://fonts.googleapis.com/css?family=Roboto&display=swap\' rel = 'stylesheet'>");
            output.write("<title>UNO Exercise Game</title>");
            output.write("</head>");
            output.write("<body>");
            
            output.write("<div class = 'hand' id = 'top'>");
            output.write("<h1>UNO Exercise Game</h1>");
            output.write("<a href = '#final' id = 'finalButton'>Jump to Final Statistics</a>");
            output.write("</div>");
            
            output.close();
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
    /**
     * Function to end the HTML output file with the required ending and footers.
     */
    public void endOutputFile() {
        
        FileWriter output = null;
        
        try {
            
            output = new FileWriter(this.outputFile, true);
            
            output.write("</body>");
            output.write("</html>");
            
            output.close();
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
        
    }

}
