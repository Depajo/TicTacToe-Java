/**
*
* This class includes tools that allow the Ai player to make their own moves in the Tictactoe game.
*
*@author Joonatan De Pascale
*
*/

public class AiLogic extends WinCheck {

    /** 
    *
    * Makes a computer move on the game board.
    *
    * Go through all the empty spaces in the 2d-array. If a human player can win the game Ai player trying block it with Ai player's own move. 
    * If Ai player's is no chance of winning, Ai player's look's for in own chip and try to build own profit.
    *
    *@param gameboard Give string 2d-array.
    *@return return string 2d-array.
    */    

    public String [][] moveLogic(String [][] gameboard) {
        int h = -1;
        int w = -1;
        
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {
                if (checkLocationIsStirng(gameboard, i, j, "[ ]")) {
                    if(h == -1 || w == -1) {
                        gameboard[i][j] = "[O]";
                        if (win(gameboard, "[O]", sideBySide)) {
                            h = i;
                            w = j;
                            gameboard[i][j] = "[ ]";
                            break;
                        } else {
                            gameboard[i][j] = "[ ]";
                            
                        }
                    }
                    gameboard[i][j] = "[X]";
                    if (win(gameboard, "[X]", sideBySide)) {
                        h = i;
                        w = j;
                        gameboard[i][j] = "[ ]";
                        break;
                    } else {
                        gameboard[i][j] = "[ ]";
                    }
                }
            }
        }   
        if(h == -1 || w == -1) {    
            for (int i = 0; i < gameboard.length; i++) {
                for (int j = 0; j < gameboard.length; j++) {
                    if (checkLocationIsStirng(gameboard, i, j, "[ ]")) {
                        gameboard[i][j] = "[X]";
                        if (win(gameboard, "[X]", 1)) {
                            h = i;
                            w = j;
                            gameboard[i][j] = "[ ]";
                            
                        } else {
                            gameboard[i][j] = "[ ]";
                        }
                    }
                }
            }
        }
        
        if (turn){ 
            gameboard = turn(gameboard, h, w, turn);
        }
        return gameboard;
    }

    /** 
    *
    * Lottery between min and max
    *
    *@param min Enter the minimum integer value
    *@param max Enter the maximum integer value
    *@return Integer value
    */
    public int getRandom(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
}