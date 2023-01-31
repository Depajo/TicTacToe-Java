import java.io.Console;

/**
*
* This class contains tools for using the Java io Console class.
*
*@author Joonatan De Pascale
*
*/

public class MyConsole {

    /** 
    *
    * Asks the user the question given by the parameter,
    * where the user must enter an integer between min-max
    *
    * Reads user input with Java io Console class. Prompts the user for a number using 
    * the while-loop until the user enters an integer between min-max. If the user enters
    * an incorrect value that is outside the min-max numbers it will print an error message
    * "Your answer is not valid, pleas try agen!", 
    * if the user enters anything other than numbers the error message will be printed,
    * "Your answer is not number, please try agen!",
    * when the user enters an integer between min-max, the while loop stops the query and 
    * the value is stored in the int answer variable and the value entered by the user is returned.
    *
    *@param min Minimum value as an integer
    *@param max Maximum value as an integer
    *@param question A question that is presented to the user
    *@return Returns an integer entered by the user
    */
    public int askInt(int min, int max, String question) {
        Console c = System.console();
        int answer;
        while(true) {
            System.out.print(question);
            try {    
                answer =Integer.parseInt(c.readLine());
                if (answer >= min && answer <= max) {
                    break;
                } else {
                    System.out.println("Your answer is not valid, pleas try agen!");
                }
            } catch (Exception e) {
                System.out.println("Your answer is not number, please try agen!");
            }
            
        }
        return answer;
    }
}