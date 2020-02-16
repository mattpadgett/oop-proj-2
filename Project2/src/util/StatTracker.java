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
    
    
    public StatTracker(boolean hasAction) // Stat Tracker Constructor
    {
        for(int i = 0; i < 5; i++)
        {
            reps[i] = 0;
            skips[i] = 0;
        }
    }
     // Getters/Accesor
    public int getReps(int index) // gets the amount of reps from the array at a specified index
    {
        return reps[index];
    }
    public int getSkips(int index) // gets the amount of skips from the array at a specified index
    {
        return skips[index];
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

} // end of StatTracker class