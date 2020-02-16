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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Hand;

public class HTMLWriter {
    
    public static void appendHand(Hand hand) {
        
        //hand.getId();
        
        FileWriter output = null;
        File outputFile = new File("HTMLOutput.html");
        
        try {
            
            output = new FileWriter(outputFile, true);
            
            
            
            output.close();
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
}
