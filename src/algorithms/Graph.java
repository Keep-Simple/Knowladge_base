package algorithms;

import java.util.LinkedList;

public class Graph {

    private int numOfNodes;
    //storing graph
    private LinkedList<Integer>[] ar;
    //Constructor
    public Graph (int numOfNodes) {
        this.numOfNodes = numOfNodes;
        this.ar = new LinkedList[numOfNodes];
        for(int i = 0; i < this.numOfNodes; i++) {
            this.ar[i] = new LinkedList();
        }
    }
    //adding edge for DIRECTED GRAPH
    public void addEdge(int a, int m) {
        ar[a].add(m);
       // ar[m].add(a); //To use with regular graph
    }

    public int getNumOfNodes() {
        return numOfNodes;
    }

    public LinkedList<Integer>[] getAr() {
        return ar;
    }
}
