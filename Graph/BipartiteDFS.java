import java.util.*;

class BipartiteDFS {
  public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
    int color[] = new int[V];
    Arrays.fill(color, -1); // Initialize color array with -1 (uncolored)

    // Check each vertex
    for (int i = 0; i < V; i++) {
      if (color[i] == -1) {
        color[i] = 0; // Color the starting node
        if (!checkdfs(i, adj, color)) {
          return false; // If any component is not bipartite
        }
      }
    }
    return true; // All components are bipartite
  }

  // DFS to check if the graph can be bipartite
  public boolean checkdfs(int node, ArrayList<ArrayList<Integer>> adj, int[] color) {
    for (int neighbor : adj.get(node)) {
      if (color[neighbor] == -1) {
        // Color the neighbor with the opposite color
        color[neighbor] = 1 - color[node];
        if (!checkdfs(neighbor, adj, color)) {
          return false; // If the graph is not bipartite
        }
      } else if (color[neighbor] == color[node]) {
        return false; // If two adjacent nodes have the same color
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int V = 4;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    // Add edges to the graph
    adj.get(0).add(1);
    adj.get(1).add(0);
    adj.get(1).add(2);
    adj.get(2).add(1);
    adj.get(2).add(3);
    adj.get(3).add(2);
    adj.get(0).add(3);
    adj.get(3).add(0);

    BipartiteDFS obj = new BipartiteDFS();
    boolean result = obj.isBipartite(V, adj);

    if (result) {
      System.out.println("Graph is Bipartite");
    } else {
      System.out.println("Graph is NOT Bipartite");
    }
  }
}
