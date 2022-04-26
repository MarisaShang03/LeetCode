package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Time complexity is O(V+E). When we construct the hashmap,the time complexity is O(E). When traverse the graph using dfs,
if the graph is a DAG, we traverse only once for each node and each vertex in the graph. so time complexity is O(V+E).
Thus, the overall time complexity is O(V+E)
Space complexity
When we initiate the adjacency list, the space
 */
public class LC210 {
    //we declare three static variable to trace the status of each node
    //White means nodes are not discovered, Gray means nodes are discovered but not finished, Black means nodes are finished
    static int white = 1;
    static int gray = 2;
    static int black = 3;

    //boolean isDAG variable tracks if the graph has cycle
    //color is to record the color status of each node
    //order records the finish sequence
    boolean isDAG;
    int[] color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> order;

    private void initialization(int numCourses) {
        isDAG = true;
        color =new int[numCourses];
        adjList = new HashMap<Integer, List<Integer>>();
        order = new ArrayList<Integer>();

        // Before traversal, all nodes are white
        for (int i = 0; i < numCourses; i++) {
            color[i]= white;
        }
    }

    //dfs conduct a dfs traversal starting from the parameter node
    private void dfs(int node) {

        //if the graph has cycle, return without further recursion
        if (!isDAG) {
            return;
        }
        //if the node does not have any neighbor, then mark the node back, add to order from head and return
        if(!adjList.containsKey(node)){
            color[node]= black;
            order.add(0,node);
            return;
        }
        // Start the traversal by marking node gray
        color[node]= gray;

        // Traverse on all neighbors
//!     //   for (Integer neighbor : adjList.getOrDefault(node, new ArrayList<Integer>())) {
            for (Integer neighbor : adjList.get(node)) {
            if (color[neighbor]== white) {
                dfs(neighbor);
            } else if (color[neighbor]== gray) {
                // if neighbor is gray, which means we have traversed the node before, then there is a cycle
                isDAG = false;
            }
        }

        //after traversing all neighbors, we mark the node back, add to order from head
        color[node]= black;
        order.add(0,node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        initialization(numCourses);

        // to form the hashmap using the given two dimensional array
        //if hashmap already contain the key, then add to the arraylist of that key
        //if hashmap does not contain the key, put the course pair to hashmap
        for (int[] pair:prerequisites) {
            if(adjList.containsKey(pair[1])){
                adjList.get(pair[1]).add(pair[0]);
            }else{
                List<Integer> l=new ArrayList<>();
                l.add(pair[0]);
                adjList.put(pair[1],l);
            }
        }

        // call dfs on each node if the node is white
        for (int i = 0; i < numCourses; i++) {
            if (color[i] == white) {
                dfs(i);
            }
        }

        //change ArrayList<Integer> order to int[] result to return
        int[] result;
        //if no cycle
        if (isDAG) {
            result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = order.get(i);
            }
        } else {
            result = new int[0];
        }
        return result;
    }
}
