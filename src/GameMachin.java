/**
*
* This class is built on the tictactoe game.
* The class includes methods related to game functions. 
* For example, to create a game area,
* to check a specific location and change turn. 
*
*
*@author Joonatan De Pascale
*
*/

public class GameMachin {
    static int gameboardsize = 3;
    static int sideBySide = 3;
    static boolean turn = false;
    static boolean run = true;

    /** 
    *
    * If the 2d-array location is given a string method returns true
    *
    * The method is called first checkNumberitMinMax checking that the height and width do not exceed the size of the array.
    * If the height and width do not exceed the size of the 2d-array, the method takes a string from the 2d-array and compares them.
    * If the strings is same then returned true and if the strings is not same returned false.
    *
    *@param array Get String 2d-aaray
    *@param height Enter the integer height of the String 2d-array
    *@param widht Enter the integer width of the String 2d-array
    *@param string Enter a string to compare
    *@return return true or false
    */
    public boolean checkLocationIsStirng(String [][] array, int height, int widht, String string) {
        if (checkNumberItMinMax(height, 0, array.length-1) == true && checkNumberItMinMax(widht, 0, array.length-1) == true){
            if (array[height][widht].equals(string)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    
    }

    /** 
    *
    * If the number between min and max is returned true and otherwise false
    *
    * This method checks that the given number is between min-max.
    * If the user allows the number to exceed the maximum or
    * is less than the minimum then the method returns false.
    * If the given number is between the min-max, the method returns true.
    *
    *@param number Intege value to check
    *@param min Minimum integer allowed
    *@param max Maximum integer allowed 
    *@return return true or false
    */
    public boolean checkNumberItMinMax(int number, int min, int max) {
        if (number < min || number > max) {
            return false;
        } else {
            return true;
        }
    }


    /** 
    *
    * Returns the inverse of truth
    *
    * If the user sets the parameter true, the user returns false or
    * if the user sets the parameter false, the user returns true
    *
    *@param b Give true or false
    *@return palauttaa true tai false
    */
    public boolean changeTurn(boolean b) {
        if (b) {
            return false;
        } else {
            return true;
        }
    }
    
    /** 
    *
    * Returns the finished game area to the user
    *
    * First, create 2d-array is made whose size is obtained from the user as a parameter.
    * The string is placed in each position in the table using two for loops: "[ ]".
    * Example printed from a 3x3 2d-array:
    *   [ ][ ][ ]
    *   [ ][ ][ ]
    *   [ ][ ][ ]
    *
    *@param size Integer value
    *@return String 2d-array
    */
    public String [][] gameboard(int size) {
        String [][] gameboard = new String[size][size];
        for (int height = 0; height < gameboard.length; height++) {
            for (int widht = 0; widht < gameboard[height].length; widht++) {
                gameboard[height][widht] = "[ ]";
            }
        }
        return gameboard;
    }
    /** 
    *
    * Sets the character X or O depending on the value of the t variable.
    * X if the t variable given by the parameter is true, O if the t variable given by the parameter is false.
    * 
    * The method sets the X or O character. If the variable t given in the parameter is true, set setChar to the variable X,
    * if, on the other hand, the variable t is false, set it to the setChar variable O. Before setting the character, check that the position
    * where the character is placed is blank.
    * If the place is empty, the character set in the setChar variable is placed in the 2d array. 
    * Then turn is changed by calling method changeTurn and save the last move in the lastMoved attribute of this class.
    * If a location has already been placed an error message will be printed: "Is not empty, try again!".
    *
    *@param array String 2d-array 
    *@param height Enter the integer height of the String 2d-array
    *@param widht Enter the integer width of the String 2d-array
    *@param t The player's turn is a boolean value
    *@return String 2d-aaray
    */
    public String [][] turn(String [][] array, int height, int widht, boolean t) {
        String setChar;
        
        if (t) {
            setChar = "[X]";
        } else {
            setChar = "[O]";
            height -=1;
            widht -=1;
        }   

        if (checkLocationIsStirng(array, height, widht, "[ ]")) {
            array[height][widht] = setChar;
            turn = changeTurn(turn);
        } else {
            if (!(turn)) {    
                System.out.println("Is not empty, try again!");
            }

        }

        return array;
    }

}