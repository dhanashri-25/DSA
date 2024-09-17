import java.util.*;

class CycleUndirected {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int idx, boolean vis[]) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(idx, -1));
        vis[idx] = true;

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int par = q.peek().second; // Parent of the current node
            q.remove();

            for (int i : adj.get(node)) {
                if (!vis[i]) { // If the neighbor has not been visited
                    vis[i] = true; // Mark it as visited
                    q.add(new Pair(i, node)); // Add neighbor with the current node as parent
                } else if (par != i) { // If the neighbor is visited and is not the parent
                    return true; // Cycle found
                }
            }
        }
        return false; // No cycle found
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V]; // Visited array

        for (int i = 0; i < V; i++) {
            if (!vis[i]) { // If the node is not visited
                if (bfs(adj, i, vis)) { // Call BFS for the component
                    return true; // Cycle found
                }
            }
        }
        return false; // No cycle found in any component
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // Initialize adjacency list for each vertex
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Define edges
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        
        CycleUndirected obj = new CycleUndirected();
        boolean ans = obj.isCycle(V, adj);
        if (ans)
            System.out.println("1"); // Cycle detected
        else
            System.out.println("0"); // No cycle detected
    }
}
