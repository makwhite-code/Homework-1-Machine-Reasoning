public class Tile {


    private int value;
    private int row;
    private int col;



    public Tile(int value, int row, int col) {
        // Constructor
        this.value = value;
        this.row = row;
        this.col = col;
    }


   
    public int getData() {
        // Get the value/data associated with this tile
        return value;
    }



    public int getRow() {
        // Get the row of this tile
        return row;
    }


    
    public int getCol() {
        // Get the column of this tile
        return col;
    }


    /
    public boolean isAdjacent(int value) {
        //Checks if a value is adjacent to the empty tile
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
        //Switches tiles if adjacent
    if (isAdjacent(value)) {
    
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




    public void setPosition(int row, int col) {
        //Updates tile's position
        this.row = row;
        this.col = col;
    }
}