public class TestHeuristicCalculations {
    public static void main(String[] args) {
        int[] startState = {7, 2, 4, 5, 0, 6, 8, 3, 1};
        Board board = new Board(startState);
        board.printClean();
        int manhattanVal = board.calculateh2();
        System.out.println("Manhattan Distance: " + manhattanVal);
        int misplacedVal = board.calculateh1();
        System.out.println("Misplaced Tiles: " + misplacedVal);
    }
}
