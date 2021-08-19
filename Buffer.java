import java.util.*;
/**
 * An object of the Buffer class generates an array list and max element of array list.
 * 
 * 
 * @author (Sugandh Singhal)
 * @version (26-10-2019)
 */
public class Buffer
{
    // instance variables - replace the example below with your own
    private ArrayList<Multiple> list;
    private int maxElements;

    /**
     * Default constructor for objects of class Buffer
     */
    public Buffer()
    {
        // initialise instance variables
        list = new ArrayList<Multiple>();
        maxElements = 0;
    }
    
    /**
     * Non default constructor for objects of class Buffer
     * @param newList ArrayList of multiple class to assign on list
     * @param newMaxElements integer to tell maximum element of arraylist
     */
    public Buffer(ArrayList<Multiple> newList, int newMaxElements)
    {
        // initialise instance variables
        list = newList;
        maxElements = newMaxElements;
    }
    
    /**
     * Method to display value of fields
     * 
     */
    public void displayList() 
    {
        
        for (int i = 0; i < list.size(); i++) 
        {
            System.out.print(list.get(i).getValue());
        }
        
    }
    
    /**
     * Accessor Method to get the arrayList of Multiple class 
     * 
     * @return A array list of multiple class 
     */ 
    public ArrayList<Multiple> getList()
    {
        
        return list;
        
    }
    
    /**
     * Accessor Method to get the max element that can be in array list
     * 
     * @return the max element that can be in array list
     */ 
    public int getMaxElement()
    {
        
        return maxElements;
        
    }
    
    /**
     * Mutator Method to set the max element that can be in array list
     * 
     * @param newList arraylist to define the list 
     */
    public void setList(ArrayList<Multiple> newList)
    {
        
        list = newList;
       
        
    }
    
    /**
     * Mutator Method to set the maximum element value
     * 
     * @param newMaxElement integer to define the the maximum value of arraylist 
     */
    public void setMaxElement(int newMaxElement)
    {
        if (newMaxElement < 0)
            throw new IllegalArgumentException("New Max element can not be negative.");
        maxElements = newMaxElement;
        
    }
}
