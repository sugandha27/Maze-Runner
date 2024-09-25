import java.util.*;

public class adjacencyList {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    public adjacencyList(int vertices){
        this.vertices = vertices;
        adjList = new LinkedList[vertices];

        //initialise each list in adjacency list
        for(int i =0; i < vertices; i++){
            adjList[i] = new LinkedList<>();
        }
    }


    
}
