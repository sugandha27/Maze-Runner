import java.util.*;

public class cycleDetectionAdjList {



    private int vertices; // Number of vertices
    private List<List<Integer>> adjList; // Adjacency list for storing the graph
    private boolean[] visited; // Array to keep track of visited vertices
    private boolean[] recStack; // Recursion stack to detect back edges

    public cycleDetectionAdjList(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        visited = new boolean[vertices];
        recStack = new boolean[vertices];

        // Initialize adjacency list
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add an edge to the directed graph
    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    // Helper function for DFS cycle detection
    private boolean dfs(int vertex) {
        if (recStack[vertex]) {
            return true; // Cycle detected
        }

        if (visited[vertex]) {
            return false;
        }

        // Mark the current node as visited and add to recursion stack
        visited[vertex] = true;
        recStack[vertex] = true;

        for (int neighbor : adjList.get(vertex)) {
            if (dfs(neighbor)) {
                return true;
            }
        }

        // Remove the vertex from recursion stack
        recStack[vertex] = false;
        return false;
    }

    // Function to check if there is a cycle in the graph
    public boolean hasCycle() {
        // Check each component of the graph
        for (int i = 0; i < vertices; i++) {
            if (dfs(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        cycleDetectionAdjList graph = new cycleDetectionAdjList(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1); // Adding this edge creates a cycle

        if (graph.hasCycle()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}
