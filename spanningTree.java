import java.util.Arrays;

public class spanningTree {
    public static int prim(int[][] graph) {
        int numVertices = graph.length;
        boolean[] selected = new boolean[numVertices]; // Track selected vertices
        Arrays.fill(selected, false);
        selected[0] = true; // Start from the first vertex
        int totalCost = 0;
        int numEdges = 0;

        while (numEdges < numVertices - 1) {
            int minimum = Integer.MAX_VALUE;
            int x = 0, y = 0;

            // Find the minimum weight edge
            for (int i = 0; i < numVertices; i++) {
                if (selected[i]) {
                    for (int j = 0; j < numVertices; j++) {
                        if (!selected[j] && graph[i][j] != 0) { // Check for valid edge
                            if (minimum > graph[i][j]) {
                                minimum = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            selected[y] = true; // Add the new vertex to the MST
            totalCost += graph[x][y]; // Add the edge weight to total cost
            numEdges++;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        int mstCost = prim(graph);
        System.out.println("Minimum Spanning Tree Cost (Prim's Algorithm): " + mstCost);
    }
}
