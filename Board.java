import java.util.Random;

public class Board {
    //private int[] tiles;
    private Tile[] tiles2;

    // Initializes a board object
    public Board(int[] tiles) {
        // TODO: initialize tiles
        //int[] startState = {0,1,2,3,4,5,6,7,8};
        Tile[] startState2 = new Tile[9];

        for (int i = 0; i < 9; i++) {
            Tile temp = new Tile(i, i/3, i%3);
            startState2[i] = temp;
        }

        this.tiles2 = startState2;
    }

    // Returns the tile at the specified row and column
    public Tile getTile(int row, int col) {
        return tiles2[row * 3 + col];
    }

    // Returns the empty tile
    public Tile getEmpty() {
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col ++){
                if (tiles2[row * 3 + col].getData() == 0) {
                    return tiles2[row * 3 + col];
                }
            }
        }
        return null;
    }

    public boolean isAdjacent(int value) {
    // TODO:
    // 1. Find the tile with this value
    // 2. Find the empty tile
    // 3. Check if they are adjacent
    // 4. If they are adjacent, swap them
    // 5. Update row/col for both tiles
    // 6. Return true
    // 7. Otherwise return false

    int valrow = -1;
    int valcol = -1;
    int emptyrow = -1;
    int emptycol = -1;

    for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (tiles2[i * 3 + j].getData()== value){
                valrow = i;
                valcol = j;
            }
            if (tiles2[i * 3 + j].getData() == 0){
                emptyrow = i;
                emptycol = j;
            }
        }
    }
    if (valrow == emptyrow){
        if(valcol == emptycol + 1 || valcol == emptycol - 1){
            return true;
        }
        
    }
    if (valcol == emptycol){
        if(valrow == emptyrow + 1 || valrow == emptyrow - 1){
            return true;
        }
    
    }

    return false;
    }

    public boolean moveTile(int value) {
    if (isAdjacent(value)) {
        // swap the tiles
        int valrow = -1;
        int valcol = -1;
        int emptyrow = -1;
        int emptycol = -1;

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (tiles2[i * 3 + j].getData()== value){
                    valrow = i;
                    valcol = j;
                }
                if (tiles2[i * 3 + j].getData() == 0){
                    emptyrow = i;
                    emptycol = j;
                }
            }
        }
        
        Tile temp = tiles2[emptyrow * 3 + emptycol];
        // do make sure the row and col information of these tiles are correct as they switch positions?
        temp.setPosition(valrow, valcol);
        tiles2[valrow * 3 + valcol].setPosition(emptyrow, emptycol);
        tiles2[emptyrow * 3 + emptycol] = tiles2[valrow * 3 + valcol];
        tiles2[valrow * 3 + valcol] = temp;
        return true;

        }

    return false;
    } 

    // Shuffles the board by randomly moving tiles by a set number of steps
    public void shuffle(int numSteps) {
        Random random = new Random();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < numSteps; i++) {
            Tile emptyTile = getEmpty();
            int row = emptyTile.getRow();
            int col = emptyTile.getCol();
            int[] dir = directions[random.nextInt(4)];
            moveTile(tiles2[(row + dir[0]) * (col + dir[1])].getData());     
        }
    }

    // Checks if the current state of the board is solved
    public boolean isSolved() {
        int expectedValue = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Tile currentTile = tiles2[row * 3 + col];
                int tileValue = currentTile.getData();
                if (tileValue != expectedValue){
                    return false;
                }
                expectedValue++;
            }
        }
        return true;
    }
}
