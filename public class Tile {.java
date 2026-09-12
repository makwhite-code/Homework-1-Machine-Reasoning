public class Tile {

    // Instance variables
    private int value;
    private int row;
    private int col;


    // Constructor
    public Tile(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }


    // Get the value/data associated with this tile
    public int getData() {
        return value;
    }


    // Get the row of this tile
    public int getRow() {
        return row;
    }


    // Get the column of this tile
    public int getCol() {
        return col;
    }


    // Move/switch this tile with the empty space
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
            if (board[i][j].getData()== value){
                valrow = i;
                valcol = j;
            }
            if (board[i][j].getData() == 0){
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
                if (board[i][j].getData()== value){
                    valrow = i;
                    valcol = j;
                }
                if (board[i][j].getData() == 0){
                    emptyrow = i;
                    emptycol = j;
                }
            }
        }

        Tile temp = board[emptyrow][emptycol].getData();
        board[emptyrow][emptycol].getData() = board[valrow][valcol].getData();
        board[valrow][valcol].getData() = temp;
        return true;

        }
    return false;
    }   



    // Optional: update the tile's position
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }


    // Optional: useful for printing/debugging
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}