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

public class HTMLWriter {
    
    public static void appendHand(Hand hand) {
        
        FileWriter o = null;
        File outputFile = new File("HTMLOutput.html");
        
        int[] reps = hand.interpret();
        
        try {
            
            o = new FileWriter(outputFile, true);
            
            o.write("<div class = 'card'>");
            
            o.write("<h2>Hand " + hand.getId()  + "</h2><hr/><ul>");

                o.write("<li>Pushups: " + reps[0] + "</li>");
                o.write("<li>Squats: " + reps[1] + "</li>");
                o.write("<li>Situps: " + reps[2] + "</li>");
                o.write("<li>Lunges: " + reps[3] + "</li>");
                o.write("<li>Burpees: " + reps[4] + "</li>");    
            
            o.write("</ul></div>");
            
            
            o.close();
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
    public static void appendFinalStats(StatTracker stats) {
        
        FileWriter output = null;
        File outputFile = new File("HTMLOutput.html");
        
        try {
            
            output = new FileWriter(outputFile, true);
            
            output.write("<div class = 'card'><h2>Final Statistics</h2><hr/>");
            output.write("<p>Repetitions per Exercise</p>");
            output.write("<ul>");
            output.write("<li>Pushups: " + stats.getReps()[0] + "</li>");
            output.write("<li>Squats: " + stats.getReps()[1] + "</li>");
            output.write("<li>Situps: " + stats.getReps()[2] + "</li>");
            output.write("<li>Lunges: " + stats.getReps()[3] + "</li>");
            output.write("<li>Burpees: " + stats.getReps()[4] + "</li>");            
            output.write("</ul></div>");
            output.close();
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
    public static void beginOutputFile() {
        
        FileWriter output = null;
        File outputFile = new File("HTMLOutput.html");
        
        try {
            
            output = new FileWriter(outputFile, true);
            
            output.write("<html>");
            output.write("<head>");
            output.write("<link rel='stylesheet' type='text/css' href='style.css'>");
            output.write("<link href = 'https://fonts.googleapis.com/css?family=Roboto&display=swap\' rel = 'stylesheet'>");
            output.write("</head>");
            output.write("<body>");
            
            output.write("<div class = 'card'>");
            output.write("<h1>UNO Exercise Game</h1>");
            output.write("</div>");
            
            output.close();
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
    public static void endOutputFile() {
        
        FileWriter output = null;
        File outputFile = new File("HTMLOutput.html");
        
        try {
            
            output = new FileWriter(outputFile, true);
            
            output.write("</body>");
            output.write("</html>");
            
            output.close();
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
        
    }

    

}
