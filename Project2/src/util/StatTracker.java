/* CS 2365 Object-Oriented Programming - Spring 2020 - Section 002
 * Project 2 - UNO Exercises
 * File: StatTracker.java
 * Date: 02/15/2020
 * Author: Brent Williams - wil94836 - R11630670
 * Contributors: None.
 *
 * Description: A utility to keep tracker of data gathered from the game.
*/
package util; // part of util package
import model.Hand; // importing the hand class

/**
 *
 * @author matt
 */
public class StatTracker { // start of StatTracker class
    
    // Use 3 integer arrays for reps, biggest amount of reps in one hand and skips.
    private int reps[] = new int[5]; // INDEX LABELS: 0 - Pushups, 1 - Squat, 2 - Situp, 3 - Lunges, 4 - Burpees
    private int skips[] = new int[5];
    private String name[] = new String[5];
    private int biggestReps[] = new int[5];
    
    /**
     *
     */
    public StatTracker() // Stat Tracker Constructor to intialize attributes
    {
        
        this.name[0] = "Pushups";
        this.name[1] = "Squats";
        this.name[2] = "Situps";
        this.name[3] = "Lunges";
        this.name[4] = "Burpees";
        
        for(int i = 0; i < 5; i++)
        {
            this.reps[i] = 0;
            this.skips[i] = 0;
            this.biggestReps[i] = 0;
        }
        
    }
   
     // Getters/Accesor

    /**
     *
     * @return
     */
    public int[] getReps() // gets the array of reps
    {
        return this.reps;
    }

    /**
     *
     * @return
     */
    public String[] getName() // gets the array of names for the reps
    {
        return this.name;
    }

    /**
     *
     * @return
     */
    public int[] getSkips() // gets the array of skips
    {
        return skips;
    }

    /**
     *
     * @return
     */
    public int[] getBiggestReps() // gets the array of biggest skips
    {
        return biggestReps;
    }
    // Setters/Mutators

    /**
     *
     * @param value
     * @param index
     */
    public void setReps(int value, int index) // sets a value in the reps array at a specified index
    {
        this.reps[index] = value;
    }

    /**
     *
     * @param name
     * @param index
     */
    public void setName(String name, int index) // sets a name into the name array of strings
    {
        this.name[index] = name;
    }

    /**
     *
     * @param value
     * @param index
     */
    public void setSkips(int value, int index) // sets a value in the skips array at a specified index
    {
        this.skips[index] = value;
    }

    /**
     *
     * @param value
     * @param index
     */
    public void setBiggestReps(int value, int index) // sets a value in the biggestSkips array at a specified index
    {
        this.biggestReps[index] = value;
    }
    
    // Methods

    /**
     *
     * @param newReps
     * @param newSkips
     */
    public void updateStats(int [] newReps, int [] newSkips)
    {
        // For newReps, go through 0-4 if new reps has a bigger value than biggest reps is found, assign it to biggestReps
        for(int i = 0; i < 5; i++)
        {
            if(newReps[i] > biggestReps[i])
            {
                biggestReps[i] = newReps[i];
            }
            reps[i] += newReps[i]; // accumulates reps total
            
        }
        
        for(int i = 0; i < 4; i++) {
            
            skips[i] += newSkips[i]; // accumulates skips total
            
        }
    } // end of updateStats
} // end of StatTracker class