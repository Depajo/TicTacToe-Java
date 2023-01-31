

/**
*
* This class contains tools for using a check who wins the tictactoe game.
*
*@author Joonatan De Pascale
*
*/


public class WinCheck extends GameMachin {
    
    /** 
    *
    * Prints the winner and returns a boolean value of true if the winner is found otherwise false.
    *
    * Takes a parameter 2d-array and a turn. Checks the number of consecutive characters with the win() method.
    * If the win is a player will be printed: "CONGRATULATION YOU WIN!!".
    * If the win is a computr will be printed: "Ai palyer WIN, Try again!.
    * If the win is a draw will be printed: "It is draw!".
    *
    *@param gb String 2d-aaray.
    *@param turn Boolean value true or false.
    *@return Retrun boolean value.
    */
    public boolean printWin(String [][] gb, boolean turn) {
        if (win(gb, "[O]", sideBySide)) {
            System.out.println("CONGRATULATION YOU WIN!!");
            return true;
        } else if (win(gb, "[X]", sideBySide)) {
            System.out.println("Ai palyer WIN, Try again!");
            return true;
        } else if (draw(gb)){
            System.out.println("It is draw!");
            return true;
        }

        return false;

    }

    /** 
    *
    * Return true if character is as much as needed to win.
    *
    * The method requests that the chips be check from each direction.
    * If there are enough consecutive similar chips to win, the return is true otherwise false.
    *
    *@param array String 2d-array.
    *@param playerChar String which is the player's character.
    *@param countWin the integer number of consecutive tokens required to win.
    *@return Retrun boolean value.
    */
    public boolean win(String [][] array, String playerChar, int countWin) {
        
        for (int line = 0; line < array.length; line++) {
            if (widthheightWin(array, line, playerChar) == countWin) {
                return true;
            }

            if (backslashWin(array, line, playerChar) == countWin) {
                return true;
            }
            
            if (slashWin(array, line, playerChar) == countWin) {
                return true;
            }
        }
        return false;
    }

    /** 
    *
    * This checks the position of the playerChar horizontally and vertically.
    * 
    * If on the line is playerChar then the counter is plus one 
    * and if next one is same playerChar then the counter is plus one.
    * Otherwise counter reset back to zero.
    * If somewhere is playerChar enough to win, return the counter number. 
    * Otherwise retrun higher couner number. 
    *
    *@param array String 2d-taulukko.
    *@param line Integer value.
    *@param playerChar String which is a player chip on game board.
    *@return Integer value.
    */

    public int widthheightWin(String [][] array, int line, String playerChar) {
        int counth = 0;
        int countw = 0;
        for(int place = 0; place < array.length; place++) {

            // horizontally
            if (array[place][line].equals(playerChar)) {
                counth++;
            } else {
                counth = 0;
            }
            
            // vertically
            if (array[line][place].equals(playerChar)) {
                countw++;
            } else {
                countw = 0;
            }

            if (counth == sideBySide || countw == sideBySide){
                break;
            }
        }
        
        if (counth < countw) {
            return countw;
        } else {
            return counth;
        }
    }

    /** 
    *
    * This checks the position of the playerChar on the from top right to down left.
    *
    * If on the line is playerChar then the counter is plus one 
    * and if next one is same playerChar then the counter is plus one.
    * Otherwise counter reset back to zero.
    * If somewhere is playerChar enough to win, return the counter number. 
    * Otherwise retrun higher couner number. 
    *
    *@param array String 2d-taulukko.
    *@param line Integer value.
    *@param playerChar String which is a player chip on game board.
    *@return Integer value.
    */

    public int backslashWin(String [][] array, int line, String playerChar) {
        int countw = 0;
        int counth = 0;
        for(int place = line; place < array.length; place++) {
            
            int  x = place-line;
            
            // horizontally
            if (array[place][x].equals(playerChar)) {
                countw++;
            } else {
                countw = 0;
            }

            // vertically
            if (array[x][place].equals(playerChar)) {
                counth++;
            } else {
                counth = 0;
            }

            

            if (counth == sideBySide || countw == sideBySide){
                break;
            }
        }
        if (counth < countw) {
            return countw;
        } else {
            return counth;
        }
    }
    
    /** 
    *
    * This checks the position of the playerChar on the from top left to down right.
    * 
    * If on the line is playerChar then the counter is plus one 
    * and if next one is same playerChar then the counter is plus one.
    * Otherwise counter reset back to zero.
    * If somewhere is playerChar enough to win, return the counter number. 
    * Otherwise retrun higher couner number. 
    *
    *@param array String 2d-taulukko.
    *@param line Integer value.
    *@param playerChar String which is a player chip on game board.
    *@return Integer value.
    */
    public int slashWin(String [][] array, int line, String playerChar) {
        int countw = 0;
        int counth = 0;
        
        for(int place = array.length-1; line <= place; place--) {   
            

            int x = Math.abs((place+1)-array.length); 
            // horizontally
            if (array[x+line][place].equals(playerChar)) {
                counth++;
            } else {
                counth = 0;
            }
            
            // vertically
            if (array[x][place-line].equals(playerChar)) {
                countw++; 
            } else {
                countw = 0;
            }
        
            
            if (counth == sideBySide || countw == sideBySide){
                break;
            }
        }
        if (counth < countw) {
            return countw;
        } else {
            return counth;
        }
    }

    /** 
    *
    * Returns true if the game is a draw otherwise false.
    *
    * Cheks that in 2d-array doon't have empty places. 
    * If in 2d-array is empty place return false and if the 2d-aray is full return true.
    * If the 2d-array is full it is meen that game is draw.
    *
    *@param array String 2d-array
    *@return retutn boolean value true or false 
    */
    public boolean draw(String [][] array) {
        for (int h = 0; h < array.length; h++) {
            for (int w = 0; w < array.length; w++) {
                if (array[h][w].equals("[ ]")) {
                    return false;
                }
            }
        }
        return true;
    }

    
}