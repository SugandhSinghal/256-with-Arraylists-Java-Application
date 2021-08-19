//import libraries here
import java.util.*;
import java.io.*;
/**
 * An object of the FileIO class will help to read and write in file
 *
 * 
 * @author (Sugandh Singhal)
 * @version (26-10-2019)
 */
public class FileIO
{
    
    private String fileName;
    /**
     * Default constructor to initialize the object of the FileIO class
     * 
     */
    public FileIO()
    {
        fileName = "";
    } 
    
    /**
     * Non default constructor to initialize the object of the FileIO class
     * 
     * @param newFileName Name of the file to be read or written or read to a file
     */
    public FileIO(String newFileName)
    {
        fileName = newFileName;
    } 
    
    /**
     * Method to display value of fields
     * 
     * @return A single string that display the file name
     */
    public String displaFileName()
    {
        // put your code here
        return fileName + "" ;
    }
    
    /**
     * Accessor Method to get the filename
     * 
     * @return A single string which represents the file name being read or written to
     */
    public String getFileName()
    {
        return fileName;
    }
    
    /**
     * Method to read the contents from the file
     * 
     * @return A entire contents of the file represented as a single string. New lines are delimited with a \n
     */
    public String readFile()
    {
        // put your code here
        StringBuffer content = new StringBuffer("");
        try
        {
        FileReader fr = new FileReader(fileName);
        Scanner scanner = new Scanner(fr);
        while(scanner.hasNextLine())
        {
            content.append(scanner.nextLine()).append("\n") ;
            //content.append(scanner.nextLine() + "\n");
        }
        scanner.close();
        }
        catch (IOException e)
        {
            System.out.println("File not found exception");
        } 
        return content.toString();
    }
    
    /**
     * Mutator Method to set the filename
     * 
     * @param newFileName Name of the file to be read or written to
     */
        public void setFileName(String newFileName)
    {
        fileName = newFileName;
    }
    
    /**
     * Method to write the contents to a file
     * 
     * @param contents Complete string which is to be written to the file. New lines need to be delimited with a \n
     */
    public void writeFile(String contents)
    {
        // put your code here
        try
        {
        PrintWriter pw = new PrintWriter(fileName);
        pw.println(contents);
        pw.close();
        }
        catch (IOException e)
        {
            System.out.println("error");
            
        }   
    }

}
