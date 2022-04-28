package com.company;

import java.util.Arrays;

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

        // Relax all edges |numVertex| - 1 times. A simple
        // shortest path from source to any other
        // vertex can have at-most |numVertex| - 1 edges

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

//        for (int i = 0; i < E; i++)
//        {
//            int x = graph[i][0];
//            int y = graph[i][1];
//            int weight = graph[i][2];
//            if (distance[x] != Integer.MAX_VALUE &&
//                    distance[x] + weight < distance[y])
//                System.out.println("Graph contains negative"
//                        +" weight cycle");
//        }

        for(int[] currentEdge: graph){
                if(distance[currentEdge[0]]!= Integer.MAX_VALUE && distance[currentEdge[0]] + currentEdge[2] < distance[currentEdge[1]]){
                    System.out.println("We found negative cycle. There is no shortest distance");
                }
        }

        System.out.println("The distance from vertex "+source+" is:" );
        for (int i = 0; i < numVertex; i++)
            System.out.println(i + "\t\t" + distance[i]);
    }

    // Driver code
    public static void main(String[] args)
    {
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph

        // Every edge has three values (u, v, w) where
        // the edge is from vertex u to v. And weight
        // of the edge is w.
        int graph[][] = { { 0, 1, -1 }, { 0, 2, 4 },
                { 1, 2, 3 }, { 1, 3, 2 },
                { 1, 4, 2 }, { 3, 2, 5 },
                { 3, 1, 1 }, { 4, 3, -3 } };

        BellmanFord(graph, V, E, 0);
    }
}

