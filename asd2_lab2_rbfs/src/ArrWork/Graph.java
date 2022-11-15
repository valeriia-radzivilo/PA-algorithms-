package ArrWork;

import java.util.*;
import java.util.LinkedList;

public class Graph {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    public int graph_size() {
        int size_gr=0;

        for (int i = 0; i < V; i++) {
            if (!adj[i].isEmpty())
                size_gr=i;
            else
                i=V;
        }
        return size_gr;
        }



    public LinkedList<Integer> get_adj(int V)
    {
        return adj[V];
    }


    public void print_graph()
    {
        for(int i =0; i< V;i++) {
            if(!adj[i].isEmpty())
                System.out.print(adj[i]);
            else
                i = V;
        }
        System.out.println();
    }

    // Constructor
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // prints BFS traversal from a given source s
    LinkedList<Integer> RBFS(int s, ArrayList<Boolean>visited, int i, int n) {
        int answer = 0;
        if(adj[i].size()!=n+1 && !ArrWork.check_in_arr(adj[i],s))
            {
                visited.add(i, true);
                i++;
                adj[answer] = RBFS(s,visited,i,n);
            }
            else {
                System.out.println(i+1);
                return adj[i];
            }

        return adj[answer];
    }
}