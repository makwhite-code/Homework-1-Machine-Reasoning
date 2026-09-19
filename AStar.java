//Implements A star and returns the number of generated nodes and depth

import java.util.HashSet;
import java.util.PriorityQueue;

public class AStar {


    public static int[] solve(Board start) {

    

        //Create the starting node
        Node startNode = new Node(start);

        //Tracks how many nodes have been created
        int numNodes = 1;

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

            // Check if this board is the goal
            if (current.getBoard().isSolved()) {

                int depth = current.getG();
                return new int[]{depth, numNodes};
            }

            if (explored.contains(uniqueCombo)) {
                continue;
            }

            else{
               explored.add(uniqueCombo);

            }
            
            
            Board currentBoard = current.getBoard();
            int[][] neighbors = currentBoard.getNeighbors();

            for (int i = 0; i < neighbors.length; i++){
                int[] neighbor = neighbors[i];

                if (neighbor[0] != -1){

                    Board copy = new Board(currentBoard);
                    copy.moveTile(neighbor[0], neighbor[1]);
                    Node child = new Node(copy, current);
                    track.add(child);

                     numNodes += 1;
                }
            }
        
        }
        return new int[]{-1, numNodes};
    }
   
    
}

