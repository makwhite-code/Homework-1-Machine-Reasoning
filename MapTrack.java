import java.util.ArrayList;
import java.util.HashMap;

// Creates a hashmap and matches each of the nodes generated to its depth
public class MapTrack {

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
                    "& Average nodes generated: " + average
            );
        }
    }
}