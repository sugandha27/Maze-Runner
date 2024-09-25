public class cycleDetectionAdjMat{
    // cycle detection for a graph represented as adj matrix using DFS
    private int vertices; //total number of vertices
    private int[][] adjMatrix;
    private boolean[] visited;

    //constructor that takes input as vertex
    public cycleDetectionAdjMat(int vertices){
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
        visited = new boolean[vertices];
    }

    //add edge weight to adjacency matrix
    public void addEdge(int src, int dest, int weight){
        
        adjMatrix[src][dest] = weight;
        adjMatrix[dest][src] = weight; // for undirected graph 
    }

    // helper function for recursive dfs 
    private boolean dfs(int vertex, int parent){
        //mark the called vertex as visited
        visited[vertex] = true;

        for (int i = 0; i < vertices; i++ ){
            if(adjMatrix[vertex][i] != 0){
                if(!visited[i]){
                    if(dfs(i,vertex))
                    return true;
                }
                else if(i!=parent)
                return true;  //cycle detected
            }
        }
        return false;
    }

    //check cycles for entire graph
    // Checks each vertex of the graph to ensure all components are covered.
    public boolean hasCycle(){
        for(int i = 0; i< vertices; i++){
            if(!visited[i]){
                if(dfs(i, -1)){
                    return true;
                }
            }
            // For each unvisited vertex i, dfs(i, -1) is called, where -1 indicates no parent for the initial call.
        }
        return false;
    }
    public static void main(String[] args) {
        int vertices = 4;
        cycleDetectionAdjMat graph = new cycleDetectionAdjMat(vertices);
    
        graph.addEdge(0, 1, 4);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 6);
        graph.addEdge(3, 0, 7);
    
        if (graph.hasCycle()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
    
}

