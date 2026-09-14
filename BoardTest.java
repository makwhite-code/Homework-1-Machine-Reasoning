public class BoardTest {
    public static void main(String[] args) {
        testDefaultBoard();
        testInBounds();
        testIsAdjacent();
        testMoveTile();
        testShuffle();
        testIsSolved();
        testPrintClean();
        System.out.println("All Board tests passed.");
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void checkEquals(int actual, int expected, String message) {
        if (actual != expected) {
            throw new AssertionError(message + " Expected: " + expected + " Actual: " + actual);
        }
    }

    private static void testDefaultBoard() {
        Board board = new Board();
        check(board.isSolved(), "New board should start solved.");
        checkEquals(board.getTile(0, 0), 0, "Top-left tile should be 0.");
        checkEquals(board.getTile(0, 1), 1, "Tile at (0,1) should be 1.");
        checkEquals(board.getTile(2, 2), 8, "Bottom-right tile should be 8.");
    }

    private static void testInBounds() {
        Board board = new Board();
        check(board.inBounds(0, 0), "(0,0) should be in bounds.");
        check(board.inBounds(2, 2), "(2,2) should be in bounds.");
        check(!board.inBounds(3, 0), "Row 3 should be out of bounds.");
        check(!board.inBounds(-1, 1), "Negative row should be out of bounds.");
        check(!board.inBounds(1, -1), "Negative column should be out of bounds.");
        check(!board.inBounds(3, 3), "(3,3) should be out of bounds.");
    }

    private static void testIsAdjacent() {
        Board board = new Board();
        check(board.isAdjacent(0, 1), "Tile at (0,1) is adjacent to empty tile.");
        check(board.isAdjacent(1, 0), "Tile at (1,0) is adjacent to empty tile.");
        check(!board.isAdjacent(0, 2), "Tile at (0,2) should not be adjacent to empty tile.");
        check(!board.isAdjacent(2, 2), "Far tile should not be adjacent to empty tile.");
        check(!board.isAdjacent(0, 0), "Empty tile itself should not be considered adjacent.");
    }

    private static void testMoveTile() {
        Board board = new Board();

        check(board.moveTile(0, 1), "Moving an adjacent tile should succeed.");
        checkEquals(board.getTile(0, 0), 1, "Tile 1 should move into the empty slot.");
        checkEquals(board.getTile(0, 1), 0, "Empty space should move to (0,1).");
        check(!board.moveTile(2, 2), "Non-adjacent tile move should fail.");
        check(!board.moveTile(3, 0), "Out-of-bounds move should fail.");
        check(!board.moveTile(-1, 0), "Negative row move should fail.");

        Board board2 = new Board();
        check(board2.moveTile(0, 1), "Adjacent move should return true.");
        check(board2.isSolved() == false, "Board should not be solved after a valid move.");
    }

    private static void testShuffle() {
        Board board = new Board();
        board.shuffle(0);
        check(board.isSolved(), "Shuffling 0 steps should leave the board solved.");

        Board board2 = new Board();
        board2.shuffle(20);
        check(board2.inBounds(0, 0) == true, "Shuffle should keep the board in bounds.");
        check(board2.getTile(0, 0) >= 0 && board2.getTile(0, 0) <= 8, "Tile values after shuffle should remain valid.");
    }

    private static void testIsSolved() {
        Board board = new Board();
        check(board.isSolved(), "Solved board should return true.");

        board.moveTile(0, 1);
        check(!board.isSolved(), "Board should no longer be solved after one move.");

        Board solved = new Board();
        solved.moveTile(0, 1);
        solved.moveTile(0, 0);
        check(solved.isSolved(), "Undoing a move should make the board unsolved again.");
    }

    private static void testPrintClean() {
        Board board = new Board();
        board.printClean();
        check(board.isSolved(), "Printing the board should not change its state.");
    }
}
