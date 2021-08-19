 import java.util.*;
 import java.io.*; 
/**
 * An object of the Game class will help user to play game 
 * 
 * 
 * @author (Sugandh Singhal)
 * @version (26-10-2019)
 */
public class Game
{
    // instance variables - replace the example below with your own
    private String playerName;
    private int gameTotal;
    
    /**
     * Default Constructor for objects of class Game
     */
    public Game()
    {
        // initialise instance variables
        playerName = "";
        gameTotal = 0;
    }

    /**
     * Non Default Constructor for objects of class Game
     * 
     * @param newPlayerName String to register the player name.
     * @param newGameTotal int to register new game total
     */
    public Game(String newPlayerName, int newGameTotal )
    {
        // initialise instance variables
        playerName = newPlayerName;
        gameTotal = newGameTotal;
    }
    
    /**
     * Method to display value of fields
     * 
     * @return A single string that display the player name and game total
     */
    public String display()
    {
        // put your code here
        return "Player Name:" +playerName + "\n Player GameTotal:" +gameTotal ;
    }
    
    
    /**
     * Accessor Method to get the player name
     * 
     * @return A String that contains player name
     */ 
    public String getPlayerName()
    {
        
        return playerName;
        
    }
    
    /**
     * Accessor Method to get the game total 
     * 
     * @return A integer that return game total
     */ 
    public int getGameTotal()
    {
        
        return gameTotal;
        
    }
    
    /**
     * Mutator Method to set the player name
     * 
     * @param newPlayerName String to set player name
     */
    public void setPlayerName(String newPlayerName)
    {
        
        playerName = newPlayerName;
        
    }
    
    /**
     * Mutator Method to set the game total
     * 
     * @param newGameTotal integer to define the game total
     */
    public void setMaxElement(int newGameTotal)
    {
        
        gameTotal = newGameTotal;
        
    }
    
    /**
     * readFile Method to read from file
     * 
     * @param digit integer to select the type of number list
     */
    private int readFile(int digit)
    {
        FileIO fileIo = new FileIO("multiples.txt");
        String content = fileIo.readFile();
        String []multipleContent = content.split("\n");
        String []firstMultiple = multipleContent[0].split(",");
        String []secondMultiple = multipleContent[1].split(",");
        String []thirdMultiple = multipleContent[2].split(",");
        if (digit == 1)
        {
            int x = Integer.parseInt(firstMultiple[rngMethod()].trim());
            return x;
        }
        else if (digit == 2)
        {
            int x = Integer.parseInt(secondMultiple[rngMethod()].trim());
            return x;
        }
        else if (digit == 3)
        {
            int x = Integer.parseInt(thirdMultiple[rngMethod()].trim());
            return x;
        }
        else
           return 0;
    }
    
    /**
     * rngMethod Method to generate random number
     *
     */
    private int rngMethod()
    {
    
        RNG rng = new RNG(2, 0);
        int x = (int)(Math.random() * ((rng.getMaximumValue() - rng.getMinimumValue()) + 1)) + rng.getMinimumValue();
        return x;
       
    }
    
    /**
     * splits Method to add element to buffer list
     * 
     * @param newList Buffer to have multiple class value
     */
    private void splits(Buffer newList)
    {
        Multiple m = new Multiple(gameTotal);
        newList.getList().add(m);
        
    }
    
    /**
     * merge Method to remove elements from arraylist
     * 
     * @param newList Buffer to have multiple class value
     */
    private void merge(Buffer newList)
    {
        for (int i = 0 ; i < newList.getList().size() ; i++)
        {
            if(newList.getList().get(i).getValue() == gameTotal)
            {
                newList.getList().remove(i);
                System.out.println();
                gameTotal = 2 * gameTotal;
            }
        }
        
    }
    
    /**
     * conditionCheck to compare game total to array lists
     * 
     * @param newList1 Buffer to have multiple class value
     * @param newList2 Buffer to have multiple class value
     * @param gameLimit integer to show game limit
     */
    private boolean conditionCheck(Buffer newList1, Buffer newList2 ,int gameLimit)
    {
        if (newList1.getList().size() < 6 && 
            gameTotal < gameLimit && 
            newList2.getList().size() < 4)
        {
            return true;
        }
        else
        {
            for (int i = 0 , j = 0; i < newList1.getList().size() || j < newList2.getList().size() ; i++, j++)
            {
                    if(newList1.getList().get(i).getValue() == gameTotal 
                    || newList2.getList().get(i).getValue() == gameTotal)
                    {
                        return true;
                        
                    }
                
            }
        return false;
        }
    }
  
    /**
     * writeFile Method to write in file
     * 
     * @param gameLimit integer that user enter
     */
    private void writeFile(int gameLimit)
    {
        FileIO fileIo = new FileIO("outcome.txt");
        String content = "";
        if(gameTotal >= gameLimit)
        {
            System.out.println("congratulations you have reached the game total " + gameTotal);
            content = playerName + " has won the game,with the highest achieved score of " + gameTotal;
            fileIo.writeFile(content);
        }
        else
        {
            System.out.println("Player has loss");
            content = playerName + " has loss the game, with the score of " + gameTotal;
            fileIo.writeFile(content);
            
        }
    }

    /**
     * starMethod Method to play the game
     * 
     * 
     */
    public void starMethod()
    {
        int n = 0;
        int select = 0;
        int gameTotalLimit = 0;
        int multipleOption = 0;
        int gamePlay = 0;
        do
        {

            System.out.println("please select from the following options");
            System.out.println("Press 1 to register a player");
            System.out.println("Press 2 to start a new game");
            System.out.println("Press 3 to view a help menu");
            System.out.println("press 4 to exit");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            sc.nextLine(); 
            switch(n)
            {
                
                case 1:
                    int validUser = 0;
                    int validTotal = 0;
                    int success = 0;
                    
                    while(validUser == 0)
                    {
                        System.out.println("Please enter the player name:");
                        Scanner sc1 = new Scanner(System.in);
                        playerName = sc1.nextLine().trim();

                        if ((2 < playerName.length()) && 
                           (playerName.length() < 11))
                        {
                            System.out.println("player name is " +playerName);
                            System.out.println("player is registered...");
                            while(validTotal == 0)
                            {
                                System.out.println("Please enter the game total to play unit:");
                                Scanner sc2 = new Scanner(System.in);
                                gameTotalLimit = sc2.nextInt();
        
                                if (gameTotalLimit > 32 && 
                                    gameTotalLimit % 8 == 0 )
                                {
                                while (success == 0)
                                {
                                    System.out.println("Please select from the following list of multiples:");
                                    System.out.println("Press 1 to select the multiple  2 4 8");
                                    System.out.println("Press 2 to select the multiple  3 9 27");
                                    System.out.println("Press 3 to select the multiple  4 16 64");
                                    System.out.println("Please select a multiple set:");
                                    Scanner sc3 = new Scanner(System.in);
                                    multipleOption = sc3.nextInt();
                                    if (multipleOption == 1 || multipleOption == 2 || multipleOption == 3)
                                    {
                                        success = 1;
                                    }
                                    else
                                    {
                                        System.out.println("Please enter the correct user input");
                                        success = 0;
                                    }   
                                }
                                    validTotal = 1;
                                }
                                else
                                {
                                    System.out.println("Please enter the game total that is greater than 32 and divisible by 8");
                                    gameTotalLimit = 0;
                                    validTotal = 0;
                                }
                            }
                            validUser = 1;
                        }
                        else
                        {
                            System.out.println("please enter valid name");
                            playerName = "";
                            validUser = 0;
                        }
                    }

                    break;
              
                case 2:
                    gameTotal = 0;
                    int validInput = 0;
                    if(playerName.length() > 0)
                    {
                        Buffer newList = new Buffer();
                        Buffer newList1 = new Buffer();
                        do
                        {
                            System.out.print("Right Buffer has maximum of 5 elements. Buffer Elements: {");
                            for (int i = 0 ; i < newList.getList().size() ; i++)
                            {
                               System.out.print(newList.getList().get(i).getValue()+ ", ");
                            }
                            System.out.println("}");
                            System.out.println();
                            System.out.println(); 
                            if(gamePlay == 0)
                            { 
                                gameTotal = readFile(multipleOption);
                                System.out.println("Randomly Generated No: " +gameTotal);
                            }
                            else
                                 System.out.println("Randomly Generated No: " +gameTotal);
                            System.out.println();
                            System.out.println();
                            System.out.print("Left Buffer has maximum of 3 elements. Buffer Elements: {");
                            for (int i = 0 ; i < newList1.getList().size() ; i++)
                            {
                               System.out.print(newList1.getList().get(i).getValue()+ ", ");
                            }
                            System.out.println("}");
                            System.out.println();
                            System.out.println(); 
                            System.out.println("The following are the actions which can be performed");
                            System.out.println("Press 1 to Split Right -->");
                            System.out.println("Press 2 to Merge Right <-- <--");
                            System.out.println("Press 3 to Split Left <--");
                            System.out.println("Press 4 to Merge Left --> -->");
                            System.out.println("Press 5 to go back to the main menu");
                            System.out.println("Please select an option:");
                            Scanner scan = new Scanner(System.in);
                            select = scan.nextInt();

                            switch(select)
                            {
                                case 1:
                                     System.out.println("Split");
                                     splits(newList);
                                     gamePlay = 0;
                                     break;   
                                case 2:
                                     System.out.println("Merge");
                                     merge(newList);
                                     gamePlay = -1;
                                     break; 
                                case 3:
                                     System.out.println("Split");
                                     splits(newList1);
                                     gamePlay = 0;
                                     break;   
                                case 4:
                                     System.out.println("Merge");
                                     merge(newList1);
                                     gamePlay = -1;
                                     break; 
                                case 5:
                                     break;
                                default:
                                     System.out.println("Please enter the correct option");
                            }
                        
                        }while(select != 5 && 
                               newList.getList().size() < 6 && 
                               gameTotal < gameTotalLimit && 
                               newList1.getList().size() < 4);
                        writeFile(gameTotalLimit);
                    }
                    else
                        System.out.println("please register the player first...");
                    break;
              
                case 3:
                    System.out.println("Help");
                    System.out.println("Game Rules");
                    System.out.println("The playrer start the game by registering himself after which he must add the game limit");
                    System.out.println("Three buffer list are provided out of which one has to be selected");
                    System.out.println("game can be played by pressing one.");
                    System.out.println("press one to split right");
                    System.out.println("press two to merge right.");
                    System.out.println("press three to split left");
                    System.out.println("press four to merge left.");
                    System.out.println("player win when the game total reaches the player limit otherwise player losses");
                    System.out.println();
                    break;
                  
                case 4:
                    System.out.println("Thanks for playing game...");
                    System.out.println("Game Exit...");
                    break;
              
                default:
                    System.out.println("enter correct option");

            
          }
          
        }while(n != 4);

    }
}
