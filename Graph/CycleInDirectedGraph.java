
import java.util.*;

public class CycleInDirectedGraph {
  private boolean dfscheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathvis[]) {
    vis[node] = 1;
    pathvis[node] = 1;

    // Traverse all adjacent nodes
    for (int i : adj.get(node)) {
      // when the node is not visited
      if (vis[i] == 0) {
        if (dfscheck(i, adj, vis, pathvis)) { // recursive DFS call
          return true; // cycle found
        }
      }
      // if the node has been previously visited
      // and it's part of the current path
      else if (pathvis[i] == 1) {
        return true; // cycle detected
      }
    }

    pathvis[node] = 0; // backtrack, remove the current node from path
    return false;
  }

  public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    int vis[] = new int[V];
    int pathvis[] = new int[V];

    // Run DFS from each unvisited node
    for (int i = 0; i < V; i++) {
      if (vis[i] == 0) {
        if (dfscheck(i, adj, vis, pathvis)) {
          return true; // cycle found
        }
      }
    }
    return false; // no cycle found
  }

  public static void main(String[] args) {
    int V = 11;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    // Define edges of the graph
    adj.get(1).add(2);
    adj.get(2).add(3);
    adj.get(3).add(4);
    adj.get(3).add(7);
    adj.get(4).add(5);
    adj.get(5).add(6);
    adj.get(7).add(5);
    adj.get(8).add(9);
    adj.get(9).add(10);
    adj.get(10).add(8);

    CycleInDirectedGraph obj = new CycleInDirectedGraph();
    boolean ans = obj.isCyclic(V, adj);

    if (ans) {
      System.out.println("True"); // cycle exists
    } else {
      System.out.println("False"); // no cycle exists
    }
  }
}