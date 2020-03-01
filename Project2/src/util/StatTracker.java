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



public class StatTracker { // start of StatTracker class
    
    // Use 3 integer arrays for reps, biggest amount of reps in one hand and skips.
    private int reps[] = new int[5]; // INDEX LABELS: 0 - Pushups, 1 - Squat, 2 - Situp, 3 - Lunges, 4 - Burpees
    private int skips[] = new int[5];
    private String name[] = new String[5];
    private int biggestReps[] = new int[5];
    
    
    public StatTracker() // Stat Tracker Constructor to intialize attributes
    {
        for(int i = 0; i < 7; i++)
        {
            this.reps[i] = 0;
            this.skips[i] = 0;
            this.biggestReps[i] = 0;
            if(i == 0)
            {
                this.name[i] = "Pushups";
            }
            else if(i == 1)
            {
                this.name[i] = "Squats";
            }
            else if(i == 2)
            {
                this.name[i] = "Sit-ups";
            }
            else if(i == 3)
            {
                this.name[i] = "Lunges";
            }
            else if(i == 4)
            {
                this.name[i] = "Burpees";
            }
            else if(i == 5)
            {
                this.name[i] = "NumOf1MinBreaks";
            }
            else if(i == 6)
            {
                this.name[i] = "Skips";
            }
        }
    }
    public StatTracker(boolean hasAction) // Stat Tracker Constructor with hasAction as an arguement
    {
        if(!hasAction) // if deck of cards do not have action cards, set burpee stats to zero
        {
            this.reps[4] = 0;
            this.skips[4] = 0;
            this.biggestReps[4] = 0;
            this.name[4] = "Burpees";
        }
    }
   
     // Getters/Accesor
    public int[] getReps() // gets the array of reps
    {
        return this.reps;
    }
    public String[] getName() // gets the array of names for the reps
    {
        return this.name;
    }
    public int[] getSkips() // gets the array of skips
    {
        return skips;
    }
    public int[] getBiggestReps() // gets the array of biggest skips
    {
        return biggestReps;
    }
    // Setters/Mutators
    public void setReps(int value, int index) // sets a value in the reps array at a specified index
    {
        this.reps[index] = value;
    }
    public void setName(String name, int index) // sets a name into the name array of strings
    {
        this.name[index] = name;
    }
    public void setSkips(int value, int index) // sets a value in the skips array at a specified index
    {
        this.skips[index] = value;
    }
    public void setBiggestReps(int value, int index) // sets a value in the biggestSkips array at a specified index
    {
        this.biggestReps[index] = value;
    }
    
    // Methods
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
            skips[i] += newSkips[i]; // accumulates skips total
        }
    } // end of updateStats
} // end of StatTracker class