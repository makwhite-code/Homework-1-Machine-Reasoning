import java.util.ArrayList;
import java.util.HashMap;

// Creates a hashmap and matches each of the nodes generated to its depth
public class MapTrack {

    public static void trackResult(
            HashMap<Integer, ArrayList<Integer>> finalMap,
            int[] result) {

        int depth = result[0];
        int nodesGenerated = result[1];

        if (!finalMap.containsKey(depth)) {
            finalMap.put(depth, new ArrayList<Integer>());
        }

        finalMap.get(depth).add(nodesGenerated);
    }

    // Calculates the average value of each depth
    public static void calcAverages(
            HashMap<Integer, ArrayList<Integer>> finalMap) {

        for (Integer depth : finalMap.keySet()) {

            ArrayList<Integer> nodes = finalMap.get(depth);

            int sum = 0;

            for (Integer nodeCount : nodes) {
                sum += nodeCount;
            }

            double average = (double) sum / nodes.size();

            System.out.println(
                    "Depth: " + depth +
                    ", Average nodes generated: " + average
            );
        }
    }
}