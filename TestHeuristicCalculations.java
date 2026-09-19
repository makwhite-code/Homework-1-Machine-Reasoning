public class TestHeuristicCalculations {
    public static void main(String[] args) {
        int[] startState = {7, 2, 4, 5, 0, 6, 8, 3, 1};
        Board board = new Board(startState);
        
        board.printClean();
        System.out.println();

        // Testing neighbors
        int[][] neighbors = board.getNeighbors();
        System.out.println("Neighbors: ");
        for(int[] neighbor: neighbors) {
            System.out.println("[" + neighbor[0] + ", " + neighbor[1] + "]");
        }
        System.out.println();

        // Testing h2: Manhattan Distance
        int manhattanVal = board.calculateh2();
        System.out.println("Manhattan Distance: " + manhattanVal);

        // Testing h1: Misplaced tiles
        int misplacedVal = board.calculateh1();
        System.out.println("Misplaced Tiles: " + misplacedVal);

        //Testing h3: Relaxed Agency
        board.printClean();
        System.out.println();
        int relaxedVal = board.calculateh3();
        System.out.println("Relaxed Agency: " + relaxedVal);
        board.printClean();
    }
}
