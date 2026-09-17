import java.util.HashSet;
import java.util.PriorityQueue;

public class AStar {


    public static void solve(Board start) {

    

        //Create the starting node
        Node startNode = new Node(start);

        //Create a priority queue
        PriorityQueue<Node> track = new PriorityQueue<>();

        // Add the starting node to the queue
        track.add(startNode);

        // New hashset to keep track of boards we've already explored
        HashSet<String> explored = new HashSet<>();
        

        // Continue search while there are boards to explore
        while (!track.isEmpty()) {

            // Get the node with the lowest f value
            Node current = track.poll();
            String uniqueCombo = current.getBoard().toString();

            if (explored.contains(uniqueCombo)) {
                continue;
            }

            explored.add(uniqueCombo);

            // Check if this board is the goal
            if (current.getBoard().isSolved()) {
                // TODO: reconstruct solution
                return;
            }

            // ToDo: generate neighboring boards
        }

        // No solution found???
    }
    
}

@Override
public String toString() {
    String result = "";

    for (int i = 0; i < tiles.length; i++) {
        result += tiles[i];
    }

    return result;
}