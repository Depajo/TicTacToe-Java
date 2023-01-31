    
    /**
    *
    * This class is where the game run.
    *
    *@author Joonatan De Pascale
    *
    */
    
    public class Main extends GameMachin {
    
    static  private final int MAXSIZE = 30;

    static MyArray ma = new MyArray();
    static MyConsole c = new MyConsole();
    static GameMachin g = new GameMachin();
    static WinCheck w = new WinCheck();
    static AiLogic i = new AiLogic();

    public static void main(String[] args) {
        
        gameboardsize = c.askInt(3, MAXSIZE, "How big gamebord do you want?[3-"+ MAXSIZE +"] ");
        if (gameboardsize > 9) {
            sideBySide = c.askInt(5, gameboardsize, "How many char must be next to each other to win (5-" + gameboardsize +")? ");
        } else if (gameboardsize > 3) {
            sideBySide = c.askInt(3, gameboardsize, "How many char must be next to each other to win (3-" + gameboardsize +")? ");
        } else {
            sideBySide = 3;
        }
        
        String [][] gb = g.gameboard(gameboardsize);
        System.out.println("\nYou are O and comuputer is X! Your turn first.\nGoog luck for the game!");
        
        while(run) {
            System.out.println();
            ma.pirntArray(gb);
            if (w.printWin(gb, turn)) {
                run = false;
            } else if (!(turn)) {
                gb = humanPlayer(gb);
            } else {
                gb = AiPlayer(gb);
            }
        }
        ma.pirntArray(gb);
        
    }

    /** 
    *
    * The method asks the player move's.
    *
    * Frist cheks that it's player turn. If it's player turn the player is asked to enter two numbers, height and widht. 
    * Then the chip is placed on the 2d-array.
    *
    *@param array String 2d-array
    *@return String 2d-array
    */
    public static String [][] humanPlayer(String [][] array) {
        if (!(turn)) {    
            int h = c.askInt(1, gameboardsize, "Please, give number of height[1-"+gameboardsize+"]: ");
            int w = c.askInt(1, gameboardsize, "Please, give number of widht[1-"+gameboardsize+"]: ");
            array = g.turn(array, h, w, turn);
        }
        return array;
    }

    /** 
    *
    * This is computer turn.
    *
    * First look at where the player has placed the chip. 
    * Then call the method moveLogic() which makes a sensible move.
    *
    *@param array String 2d-array
    *@return String 2d-array
    */
    public static String [][] AiPlayer(String [][] array) {
        array = i.moveLogic(array);
        return array;
    }

}