/** 
 * A Board class that implements the 8-Tile puzzle game. Includes functions to calculate the heuristic of the board
 * 
 */
import java.util.Random;

public class Board {
    private int[] tiles;
    private int emptyRow;
    private int emptyCol;

    
    /**
     * Initializes a board with the solved start state. Sets the empty tile location
     */
    public Board() {
        // TODO: initialize tiles
        int[] startState = {0,1,2,3,4,5,6,7,8};
        this.tiles = startState;
        emptyRow = 0;
        emptyCol = 0;
    }

    /**
     * Initializes a board with a given start state
     * 
     * @param nums  The given start state of the board
     */
    public Board(int[] nums) {
        // TODO: initialize tiles
        this.tiles = nums;
        emptyRow = 0;
        emptyCol = 0;
    }

    /**
     * Gets the tile from the specified (row, col) location on the board
     * 
     * @param row   Integer value of the row
     * @param col   Integer value of the column
     * @return      The tile value at the specified (row, col)
     */
    public int getTile(int row, int col) {
        return tiles[row * 3 + col];
    }

    /**
     * Gets the row where the empty tile is located
     * 
     * @return  Integer value of the row
     */
    public int getEmptyRow() {
        return emptyRow;
    }

    /**
     * Gets the column where the empty tile is located
     * 
     * @return  Integer value of the column
     */
    public int getEmptyCol() {
        return emptyCol;
    }

    /**
     * Chekcs if the specified tile (row, col) is adjacent with the empty tile.
     */
    public boolean isAdjacent(int row, int col) {

        int valrow = row;
        int valcol = col;

        // Optional: search isAdjacent by value rather than tile location
        // for (int i = 0; i < 3; i++){
        //     for (int j = 0; j < 3; j++){
        //         if (tiles[i * 3 + j] == value){
        //             valrow = i;
        //             valcol = j;
        //         }
        //     }
        // }

        if (valrow == emptyRow){
            if(valcol == emptyCol + 1 || valcol == emptyCol - 1){
                return true;
            }
            
        }
        if (valcol == emptyCol){
            if(valrow == emptyRow + 1 || valrow == emptyRow - 1){
                return true;
            }
        
        }

        return false;
    }

    /**
     * Checks if the tile at a specified location is in the bounds of the board
     * @param row   Integer value of the row
     * @param col   Integer value of the column
     * @return      A true or false whether the tile is in the board bounds
     */
    public boolean inBounds(int row, int col) {
        if (row >= 3 || row < 0 || col >= 3 || col < 0) {
            return false;
        }
        return true;
    }

    // Moves tile(row, col) with the empty tile. If move is successful, returns true. Otherwise returns false.
    /**
     * 
     */
    public boolean moveTile(int row, int col) {
        if (inBounds(row, col) == false) {
            return false;
        }

        if (isAdjacent(row, col)) {
            // swap the tiles
            // int valrow = -1;
            // int valcol = -1;

            // Optional: moveTile() by value instead of (row, col)
            // for (int i = 0; i < 3; i++){
            //     for (int j = 0; j < 3; j++){
            //         if (tiles[i * 3 + j]== value){
            //             valrow = i;
            //             valcol = j;
            //         }
            //     }
            // }
            
            int temp = tiles[emptyRow * 3 + emptyCol]; // should be 0
            tiles[emptyRow * 3 + emptyCol] = tiles[row * 3 + col];
            tiles[row * 3 + col] = temp;
            emptyRow = row;
            emptyCol = col;
            return true;

            }

        return false;
    } 

    // Shuffles the board by randomly moving tiles by a set number of steps
    public void shuffle(int numSteps) {
        Random random = new Random();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < numSteps; i++) {
            int[] dir = directions[random.nextInt(4)];
            while (moveTile((emptyRow + dir[0]), (emptyCol + dir[1])) == false) { // if a chosen direction is out of bounds, choose another random direction
                dir = directions[random.nextInt(4)];
            }    
        }
    }

    // Checks if the current state of the board is solved
    public boolean isSolved() {
        int expectedValue = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int tileValue = tiles[row * 3 + col];
                if (tileValue != expectedValue){
                    return false;
                }
                expectedValue++;
            }
        }
        return true;
    }

    // optional function to print board to help visualize
    public void printClean() {
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++) {
                System.out.print(tiles[row * 3 + col]);
            }
            System.out.println();
        }
    }

    public String toString() {
    String result = "";

    for (int i = 0; i < tiles.length; i++) {
        result += tiles[i];
    }

    return result;
}

    // returns the number of misplaced tiles
    public int calculateh1() {
        if (isSolved() == true) {
            return 0;
        }

        int numMisplaced = 0;
        int expectedValue = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int tileValue = tiles[row * 3 + col];
                if (tileValue != expectedValue && tileValue != 0) {
                    numMisplaced = numMisplaced + 1;
                }
                expectedValue++;
            }
        }
        return numMisplaced;
    }

    // returns the total manhattan distance of each misplaced tile
    public int calculateh2() {
        if (isSolved() == true) {
            return 0;   
        }

        int manhattanVal = 0;
        int expectedValue = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int tileValue = tiles[row * 3 + col];
                if (tileValue != expectedValue && tileValue != 0) {
                    int expectedRow = tileValue/3;
                    int expectedCol = tileValue%3;
                    manhattanVal = manhattanVal + (Math.abs(row - expectedRow) + Math.abs(col - expectedCol));
                }
                expectedValue++;
            }
        }
        return manhattanVal;
    }
}
