package algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class DFS {
/*
                             RECURSIVE

    private static void dfsUtil(int v, boolean visited[], Graph graph) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        for(int i : graph.getAr()[v])
            if (!visited[i])
                dfsUtil(i, visited, graph);
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()

    public static void dfs(int v, Graph graph) {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[graph.getNumOfNodes()];

        // Call the recursive helper function to print DFS traversal
        dfsUtil(v, visited, graph);
    }


*/
// NON RECURSIVE, THE SAME AS BFS EXCEPT  s = queue.pollLast(); INSTED pollFirst();
    public static void dfs (int s, Graph graph) {
        boolean[] visited = new boolean[graph.getNumOfNodes()];
        Deque<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.offer(s);
        while (!queue.isEmpty()) {
            s = queue.pollLast();
            System.out.print(s+" ");
            // Get all adjacent vertices of the vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (int i : graph.getAr()[s])
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
        }
    }



}

