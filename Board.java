public class Board {
    private int[] tiles;

    // Initializes a board object
    public Board(int[] tiles) {
        // TODO: initialize tiles
        int[] startState = {0,1,2,3,4,5,6,7,8};
        this.tiles = startState;
    }

    // Returns the tile at the specified row and column
    public int getTile(int row, int col) {
        // TODO: implement
        return tiles[row * 3 + col];
    }

    // Returns the empty tile
    public int getEmpty() {
        // TODO: implement
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col ++){
                if (tiles[row * 3 + col] == 0) {
                    return tiles[row * 3 + col];
                }
            }
        }
        return 0;
    }

    // returns the neighboring tiles of a specific row and col 

    // Randomizes the board
    public void shuffle() {
        // TODO: implement
        //Find empty space
        // Determine where empty space is
        // depending on the locaion of the empty tile, find its valud neighbors
        // pick a random neighbor and move the tile to the empty tile
        // repeat for some number of times
        
        // Call getEmpty function to get empty tile
        // grab dimensions of that tile

        // for (int i= 0; i < 20; i++) {
        //     Tile emptyTile = getEmpty();
        //     int row = emptyTile.getRow()
        //     int col = emptyTile.getCol()
        //     Tile[] neighbors = board.getNeighbors(row, col)
        // }
        // Tile emptyTile = getEmpty();
        // int row = emptyTile.getRow()
        // int col = emptyTile.getCol()
        //

        


    }
}
