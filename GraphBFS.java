import java.util.*;

public class GraphBFS {
    
    // Graph representation using an adjacency list
    private LinkedList<Integer>[] adjList;
    private int numVertices;

    // Constructor to initialize the graph
    public GraphBFS(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph (undirected graph)
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);  // Remove this line for a directed graph
    }

    // BFS traversal from a given start node
    public void bfs(int startVertex) {
        // Array to track visited nodes
        boolean[] visited = new boolean[numVertices];

        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Start with the startVertex
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            // Dequeue a vertex and process it
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            // Get all adjacent vertices of the dequeued vertex
            for (int neighbor : adjList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // Main method to demonstrate BFS traversal
    public static void main(String[] args) {
        // Create a graph with 6 vertices
        GraphBFS graph = new GraphBFS(6);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        // Perform BFS traversal starting from vertex 0
        System.out.println("BFS traversal starting from vertex 0:");
        graph.bfs(0);
    }
}
