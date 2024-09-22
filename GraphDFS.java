import java.util.*;

public class GraphDFS {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list for storing graph

    // Constructor
    public GraphDFS(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        
        // Initialize each adjacency list
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph (directed or undirected depending on your use case)
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        // Uncomment the following line if you want to make the graph undirected
        // adjacencyList[destination].add(source);
    }

    // Recursive DFS Helper Function
    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true; // Mark the vertex as visited
        System.out.print(vertex + " "); // Print the vertex

        // Visit all adjacent vertices
        for (int adjacent : adjacencyList[vertex]) {
            if (!visited[adjacent]) {
                dfsRecursive(adjacent, visited); // Recursively visit unvisited vertices
            }
        }
    }

    // Function to perform DFS traversal starting from a given vertex (recursive)
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Track visited vertices
        System.out.println("Recursive DFS Traversal:");
        dfsRecursive(startVertex, visited);
        System.out.println();
    }

    // Iterative DFS using a stack
    public void dfsIterative(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Track visited vertices
        Stack<Integer> stack = new Stack<>();
        
        stack.push(startVertex); // Start with the start vertex
        
        System.out.println("Iterative DFS Traversal:");
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            
            if (!visited[vertex]) {
                visited[vertex] = true; // Mark the vertex as visited
                System.out.print(vertex + " "); // Print the vertex
                
                // Push all adjacent vertices to the stack
                for (int adjacent : adjacencyList[vertex]) {
                    if (!visited[adjacent]) {
                        stack.push(adjacent);
                    }
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS(6); // Create a graph with 6 vertices (0 to 5)
        
        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        
        // Performing DFS traversal
        graph.dfs(0);           // Recursive DFS starting from vertex 0
        graph.dfsIterative(0);  // Iterative DFS starting from vertex 0
    }
}
