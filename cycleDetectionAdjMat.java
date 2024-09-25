public class cycleDetectionAdjMat{
    // cycle detection for a graph represented as adj matrix
    private int vertices;
    private int[][] adjMatrix;

    //constructor that takes input as vertex
    public cycleDetectionAdjMat(int vertices){
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    //add edge weight to adjacency matrix
    public void addEdge(int src, int dest, int weight){
        
    }
}