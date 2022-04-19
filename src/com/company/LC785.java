package com.company;

import java.util.Arrays;
import java.util.Stack;

public class LC785 {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] color = new int[len];
        Arrays.fill(color, -1);
        //create a stack
        Stack<Integer> stack = new Stack();

        //We need this loop bec if part of the graph is not connect to the rest, we will
        //still need to push the start.
        for (int start = 0; start < len; start++) {
            if (color[start] == -1) {
                stack.push(start);
                color[start] = 0;

                //while loop to pop if stack is not empty.
                while (!stack.empty()) {
                    Integer current = stack.pop();
                    //loop through to push all neighbor
                    for (int neighbor: graph[current]) {
                        //if neighbor -1, no color, then push neighbor and color it.
                        if (color[neighbor] == -1) {
                            stack.push(neighbor);

                            //color neighbor different from current.
                            if(color[current]==0){
                                color[neighbor]=1;
                            }else{
                                color[neighbor]=0;
                            }
                            //if neighbor and current node as the same color, return false.
                        } else if (color[neighbor] == color[current]) {
                            return false;
                        }
                    }
                }
            }
        }
        //only return true if we loop through all the vertex (stack is empty)
        return true;
    }
}
/**
 * Time and Splace complexity
 * Time and Space complexity Analysis: A graph is bipartie if the graph has no odd number cycles.
 * Two adjacent vertexes must be colored by different color. This means that the graph can be colored by 0 and 1.
 * We use DFS algorithm to color the graph.
 * The time complexity is O(V+E), because we first loop through all vertex, and then we loop through all neighbor for each vertex.
 * Thus time is O(V+E)
 * The space complexity is O(V), because we create a new array color[len] of size V to store the coloring status of each vertex.
 */
