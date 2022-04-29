package com.company;
import java.util.Arrays;

/*
Bellman Ford algorithm time complexity
Initialization takes O(V)
Relaxation steps takes O(E*V), because for each edge, we do relaxation V-1 times.
Check negative cycle takes O(E)
Overall time complexity is O(E*V)
 */
public class BellmanFord {
    /*
    This function uses Bellman-Ford's algorithm to find the single source shortest path.
    Parameter graph:two dimentional array that represents each edge in the graph
    for example if graph[[u,v,w]] means the graph has one edge from vertex u to vertex v with weight w

    Parameter numVertex is the total number of vertex
    Parameter E is the number of edges?
    Parameter source is the start vertex

     */
    static void BellmanFord(int graph[][], int numVertex, int E,
                            int source) {
        //Create an array distance to record distance from source.
        //Initialize all distance to infinite
        int[] distance = new int[numVertex];
        Arrays.fill(distance,Integer.MAX_VALUE);
        // distance of source as 0
        distance[source] = 0;

        //relaxation steps. relax all edges numVertex -1 times
        for (int i = 0; i < numVertex - 1; i++) {
            //for each edge in graph[[u,v,w]], check if distance[v] is greater than distance[u]+weight
            //if greater, update distance[v] to the sum of  distance[u] and weight
            for(int[] currentEdge: graph){
                if(distance[currentEdge[0]]!= Integer.MAX_VALUE && distance[currentEdge[0]] + currentEdge[2] < distance[currentEdge[1]]){
                    distance[currentEdge[1]] = distance[currentEdge[0]]+ currentEdge[2];
                }
            }
        }

        // To check for negative-weight cycles, run relaxation step one more time
        //for each edge in graph[[u,v,w]], check if distance[v] is greater than distance[u]+weight
        //if greater, there is a negative cycle
        for(int[] currentEdge: graph){
                if(distance[currentEdge[0]]!= Integer.MAX_VALUE && distance[currentEdge[0]] + currentEdge[2] < distance[currentEdge[1]]){
                    System.out.println("We found negative cycle. There is no shortest distance");
                    return;
                }
        }

        System.out.println("The distance from vertex "+source+" is:" );
        for (int i = 0; i < numVertex; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("The distance from vertex " + source + " to vertex " + i + " is infinity");
            } else {
                System.out.println("The distance from vertex " + source + " to vertex " + i + "\t" + distance[i]);
                //System.out.println(i + "\t\t" + distance[i]);
            }
        }
    }

    public static void main(String[] args) {
        //graph is problem 4.c
        //for each edge in graph[[u,v,w]],the graph has one edge from vertex u to vertex v with weight w
        int graph[][] = {{0,2,3},{0,3,5},{0,5,2},
                {1,2,-4},
                {2,7,4},
                {3,4,6},
                {4,3,-3},{4,7,8},
                {5,6,3},
                {6,5,-6}, {6,7,7}
        };
        int numVertex = 8; // Number of vertices in graph
        int numEdge = graph.length; // Number of edges in graph
        BellmanFord(graph, numVertex, numEdge, 0);
    }

}

//graph is problem 4.a
//for each edge in graph[[u,v,w]],the graph has one edge from vertex u to vertex v with weight w
//        int graph[][] = {{0, 1, 1}, {0, 4, 4}, {0, 5, 8},
//                {1,2,2}, {1,6,6},{1,5,6},
//                {2,3,1}, {2,6,2},
//                {3,7,4},{3,6,1},
//                {4,5,5},
//                {6,7,1},{6,5,1}
//        };
//        int numVertex = 8; // Number of vertices in graph
//        int numEdge = graph.length; // Number of edges in graph
//        BellmanFord(graph, numVertex, numEdge, 0);


//graph is problem 4.b
//for each edge in graph[[u,v,w]],the graph has one edge from vertex u to vertex v with weight w
//    int graph[][] = {{0,1,10}, {0,7,8},
//            {1,5,2},
//            {2,3,1},{2,1,1},
//            {3,4,3},
//            {4,5,-1},
//            {5,2,-2},
//            {6,5,-1}, {6,1,-4},
//            {7,6,1}
//    };
//    int numVertex = 8; // Number of vertices in graph
//    int numEdge = graph.length; // Number of edges in graph
//    BellmanFord(graph, numVertex, numEdge, 0);

    //graph is problem 4.c
    //for each edge in graph[[u,v,w]],the graph has one edge from vertex u to vertex v with weight w
//    int graph[][] = {{0,1,2},{0,3,7},
//            {1,2,5},{1,3,8}, {1,4,-4},
//            {2,1,-2},
//            {3,2,-3}, {3,4,9},
//            {4,2,7},{4,0,2}
//    };
//    int numVertex = 5; // Number of vertices in graph
//    int numEdge = graph.length; // Number of edges in graph
//    BellmanFord(graph, numVertex, numEdge, 0);