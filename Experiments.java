import java.util.ArrayList;
import java.util.HashMap;

public class Experiments {

    public static void main(String[] args) {

        // Key = solution depth from 2 to 24
        // Value = list of the num of nodes generated for boards at that depth
        HashMap<Integer, ArrayList<Integer>> finalMap =
                new HashMap<>();

        // Create an empty list to initialize the key which is every target depth
        for (int depth = 2; depth <= 24; depth += 2) {
            finalMap.put(depth, new ArrayList<Integer>());
        }

        // Keep generating boards until we have 100 boards at every target depth
        while (!allDepthsComplete(finalMap)) {

            Board board = new Board();
            board.shuffle(100);
            int[] result = AStar.solve(board);
            int depth = result[0];
            int nodesGenerated = result[1];

            // Track results for our target depths 
            if (depth >= 2 && depth <= 24 && depth % 2 == 0) {

                // Only add the result if this depth still needs more boards so cap it at 100
                if (finalMap.get(depth).size() < 100) {
                    finalMap.get(depth).add(nodesGenerated);
                }
            }
        }

        System.out.println("All depths 2 through 24 have reached 100 boards");

        MapTrack.calcAverages(finalMap);
    }

    // Checks whether every target depth has 100 boards
    public static boolean allDepthsComplete(HashMap<Integer, ArrayList<Integer>> finalMap) {

        for (Integer depth : finalMap.keySet()) {

            if (finalMap.get(depth).size() < 100) {
                return false;
            }
        }

        return true;
            }
}



