import java.util.*;

class BipartiteBFS {
  public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
    // Initialize color array with -1 (uncolored)
    int[] color = new int[V];
    Arrays.fill(color, -1);

    // Iterate over all vertices to handle disconnected graphs
    for (int i = 0; i < V; i++) {
      // If vertex is uncolored, perform BFS
      if (color[i] == -1) {
        if (!bfsCheck(i, adj, color)) {
          return false; // Not bipartite
        }
      }
    }

    return true; // All components are bipartite
  }

  private boolean bfsCheck(int start, ArrayList<ArrayList<Integer>> adj, int[] color) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    color[start] = 0; // Start coloring the first node with color 0

    while (!q.isEmpty()) {
      int node = q.poll();

      // Traverse all adjacent vertices
      for (int neighbor : adj.get(node)) {
        // If the neighbor has not been colored, assign it the opposite color
        if (color[neighbor] == -1) {
          color[neighbor] = 1 - color[node]; // Alternate colors
          q.add(neighbor);
        }
        // If the neighbor has the same color as the current node, it's not bipartite
        else if (color[neighbor] == color[node]) {
          return false;
        }
      }
    }

    return true; // Successfully colored the component
  }

  public static void main(String[] args) {
    int V = 4; // Number of vertices
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    // Adding edges to the graph
    adj.get(0).add(1);
    adj.get(1).add(0);
    adj.get(1).add(2);
    adj.get(2).add(1);
    adj.get(2).add(3);
    adj.get(3).add(2);
    adj.get(0).add(3);
    adj.get(3).add(0);

    BipartiteBFS obj = new BipartiteBFS(); // Corrected the class name
    boolean result = obj.isBipartite(V, adj);

    if (result) {
      System.out.println("Graph is Bipartite");
    } else {
      System.out.println("Graph is NOT Bipartite");
    }
  }
}
