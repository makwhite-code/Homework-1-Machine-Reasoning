//Tracks and creates nodes for each board

public class Node implements Comparable<Node> {

    private Board board;
    private Node parent;

    private int g;
    private int h;
    private int f;

    // Starting node which is just the starting board
    public Node(Board board) {
        this.board = board;
        this.parent = null;

        this.g = 0;

        this.h = board.calculateh3();

        this.f = g + h;
    }

    // Neighbor node (possible moves) of parent node
    public Node(Board board, Node parent) {
        this.board = board;
        this.parent = parent;

        // Calculate g using the parent's g
        this.g = parent.getG() + 1;

        // Calculate h using this board
        this.h = board.calculateh3();

        // Calculate total f
        this.f = g + h;
    }

    @Override
    public int compareTo(Node other) {

    return Integer.compare(this.f, other.f);

    }

    public Board getBoard() {
        return board;
    }

    public Node getParent() {
        return parent;
    }

    public int getG() {
        return g;
    }

    public int getH() {
        return h;
    }

    public int getF() {
        return f;
    }
}

