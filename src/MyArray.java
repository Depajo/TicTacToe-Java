
/**
*
* This class contains tools for using a array.
*
*@author Joonatan De Pascale
*
*/

public class MyArray {
    
    /** 
    *
    * Method prints a 2d-array from each location.
    *
    * The method has two for-loops. The first for-loop takes the height of the 2d-array and the inner 
    * for-loop takes the value from each position in the 2d-array and prints it.
    * 
    *@param array Get String 2d-array
    */
    public void pirntArray(String [][] array) {
        for (int height = 0; height < array.length; height++) {
            for (int widht = 0; widht < array[height].length; widht++) {
                System.out.print(array[height][widht]);
            }
            System.out.println();
        }
    }
}