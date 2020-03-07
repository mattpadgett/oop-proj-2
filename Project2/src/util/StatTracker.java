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
 * @author Brent Williams R11630670
 */
public class StatTracker { // start of StatTracker class
    
    // Use 3 integer arrays for reps, biggest amount of reps in one hand and skips.
    private int reps[] = new int[5]; // INDEX LABELS: 0 - Pushups, 1 - Squat, 2 - Situp, 3 - Lunges, 4 - Burpees
    private int skips[] = new int[5];
    private String name[] = new String[5];
    private int biggestReps[] = new int[5];
    
    /**
     * StatTracker Constructor to initialize attributes
     */
    public StatTracker()
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
     * Gets the array of reps.
     * @return the array of reps
     */
    public int[] getReps()
    {
        return this.reps;
    }

    /**
     * Gets the array of names for every type of rep.
     * @return the array of names
     */
    public String[] getName()
    {
        return this.name;
    }

    /**
     * Gets the array of reps skipped.
     * @return the array of skips
     */
    public int[] getSkips()
    {
        return skips;
    }

    /**
     * Gets the array of biggest reps skipped.
     * @return the array of biggest reps skipped
     */
    public int[] getBiggestReps()
    {
        return biggestReps;
    }
    // Setters/Mutators

    /**
     *  Sets the reps array a certain value at a specific index.
     * @param value - the number of a certain rep
     * @param index - to specify a certain rep
     */
    public void setReps(int value, int index)
    {
        this.reps[index] = value;
    }

    /**
     * Sets the name of a rep at a specified index within the name array
     * @param name - the name of a rep 
     * @param index - the index of the name array specified by the user
     */
    public void setName(String name, int index)
    {
        this.name[index] = name;
    }

    /**
     * Sets the number of skips at a specified index within the skips array
     * @param value - the number of skips for a certain exercise
     * @param index - the index of the skips array specified by the user
     */
    public void setSkips(int value, int index)
    {
        this.skips[index] = value;
    }

    /**
     * Sets the biggest number of skips of a certain rep given a specified index
     * @param value - the number of biggest skips for a certain exercise
     * @param index - the index of the biggestReps array specified by the user
     */
    public void setBiggestReps(int value, int index)
    {
        this.biggestReps[index] = value;
    }
    
    // Methods

    /**
     * Updates the statistics for the reps, skips, and biggestReps arrays
     * @param newReps - an array of integers to represent the list of reps
     * @param newSkips - an array of integers to represent the list of skips
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