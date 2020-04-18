package algorithms;

import java.util.*;

//shortest way
public class BFS {

   public static void bfs(int s, Graph graph, int key)
    {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[graph.getNumOfNodes()];
        int[] parent = new int[graph.getNumOfNodes()];

        // Create a queue for BFS
        Deque<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        int start = s;
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            // Dequeue a node from queue and print it
            s = queue.poll();
            // Get all adjacent vertices of the vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (int i : graph.getAr()[s]) {
                if (!visited[i]) {
                    parent[i] = s; //adding parent to node
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        //travers from start node to key(searched) node
        Stack<Integer> stack = new Stack();
            stack.push(key);
                while( parent[key] != start){
                 stack.push(parent[key]);
                 key = parent[key];
                }
        //printing lengths and travers itself
        System.out.println("Travers length is : " + (stack.size() + 1));

        System.out.print(start + " ");
        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");

    }
}


