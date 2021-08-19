
/**
 * An object of the Multiple class generates a integer value.
 * 
 * 
 * @author (Sugandh Singhal)
 * @version (26-10-2019)
 */
public class Multiple
{
    // instance variables - replace the example below with your own
    private int value;

    /**
     * Default Constructor for objects of class Multiple
     */
    public Multiple()
    {
        // initialise instance variables
        value = 0;
    }
    /**
     * Non default Constructor for objects of class Multiple
     * @param newValue integer to assign new value to value
     * 
     */
    public Multiple(int newValue)
    {
        // initialise instance variables
        value = newValue;
    }

    /**
     * Method to display value of fields
     * 
     * @return A single string which contains the integer value
     */
    public String displayMultiple()
    {
        // put your code here
        return value + "" ;
    }
    
    /**
     * Accessor Method to get the value 
     * 
     * @return A integer which contains the value 
     */
    public int getValue()
    {
        
        return value;
        
    }
    
    /**
     * Mutator Method to set the value
     * 
     * @param newValue integer to define the the value
     */
    public void setValue(int newValue)
    {
        
         value = newValue;
         
    }
}
