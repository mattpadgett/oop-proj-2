/* CS 2365 Object-Oriented Programming - Spring 2020 - Section 002
 * Project 2 - UNO Exercises
 * File: StatTracker.java
 * Date: 02/15/2020
 * Author: Brent Williams - wil94836 - R11630670
 * Contributors: None.
 *
 * Description: A ultility to keep tracker of data gathered from the game.
*/
package util; // part of util package
import model.Hand; // importing the hand class

public class StatTracker { // start of StatTracker class
    
    // Use 2 integer arrays for reps and skips.
    private int reps[] = new int[5]; // INDEX LABELS: 0 - Pushups, 1 - Squat, 2 - Situp, 3 - Lunges, 4 - Burpees
    private int skips[] = new int[5];
    private int biggestSkips[] = new int[5];
    
    
    public StatTracker(boolean hasAction) // Stat Tracker Constructor
    {
        for(int i = 0; i < 5; i++)
        {
            reps[i] = 0;
            skips[i] = 0;
            biggestSkips[i] = 0;
        }
    }
     // Getters/Accesor
    public int []getReps() // gets the array of reps
    {
        return reps;
    }
    public int []getSkips() // gets the array of skips
    {
        return skips;
    }
    public int []getBiggestSkips() // gets the array of biggest skips
    {
        return biggestSkips;
    }
    // Setters/Mutators
    public void setReps(int value, int index) // sets a value in the reps array at a specified index
    {
        reps[index] = value;
    }
    public void setSkips(int value, int index) // sets a value in the skips array at a specified index
    {
        skips[index] = value;
    }
    public void setBiggestSkips(int value, int index) // sets a value in the biggestSkips array at a specified index
    {
        biggestSkips[index] = value;
    }
} // end of StatTracker class