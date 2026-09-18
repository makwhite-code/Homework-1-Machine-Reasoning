public class Main {
    public static void main(String[] args) {

        int[] nums = {0, 1, 2,
            3, 4, 5,
            6, 7, 8};
        Board start = new Board(nums);

        AStar.solve(start);
    }
}
