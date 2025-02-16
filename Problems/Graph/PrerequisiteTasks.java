import java.util.*;
class PrerequisiteTasks {
  public boolean isPossible(int N, int P, int[][] prerequisites) {
    // Step 1: Build the adjacency list and indegree array
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adj.add(new ArrayList<>());
    }

    int indegree[] = new int[N]; // indegree array for tasks

    // Step 2: Fill the adjacency list and calculate indegrees
    for (int i = 0; i < P; i++) {
      int u = prerequisites[i][0]; // task that is a prerequisite
      int v = prerequisites[i][1]; // task that depends on u
      adj.get(u).add(v); // add v to the adjacency list of u
      indegree[v]++; // increment the indegree of task v
    }

    // Step 3: Initialize the queue and add tasks with 0 indegree
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    // Step 4: Perform the topological sort
    ArrayList<Integer> topo = new ArrayList<>();
    while (!q.isEmpty()) {
      int node = q.poll(); // get a task with no prerequisites
      topo.add(node); // add it to the topological order

      // Decrease the indegree of dependent tasks
      for (int i : adj.get(node)) {
        indegree[i]--; // one less prerequisite for task i
        if (indegree[i] == 0) { // if no prerequisites left
          q.add(i); // add to the queue
        }
      }
    }

    // If the topological order size is equal to the number of tasks, return true
    return topo.size() == N;
  }

  public static void main(String[] args) {
    PrerequisiteTasks solution = new PrerequisiteTasks();
    int N = 4; // Number of tasks
    int P = 3; // Number of prerequisites
    int[][] prerequisites = { { 1, 0 }, { 2, 1 }, { 3, 2 } }; // Prerequisites

    boolean result = solution.isPossible(N, P, prerequisites);

    if (result) {
      System.out.println("Yes, all tasks can be completed.");
    } else {
      System.out.println("No, not all tasks can be completed.");
    }
  }
}
