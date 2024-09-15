import java.util.*;

class Node {
  int data;
  Node left;
  Node right;

  Node(int val) {
    data = val;
    left = null;
    right = null;
  }
}

public class LevelOrderTraversal {

  public static List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans; // Added null check for root

    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int size = q.size();

      for (int i = 0; i < size; i++) {
        Node node = q.poll();
        level.add(node.data);

        if (node.left != null) q.add(node.left);
        if (node.right != null) q.add(node.right);
      }

      ans.add(level);
    }

    return ans;
  }

  public static void main(String[] args) {
    // Creating a sample binary tree
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    // Perform level-order traversal
    List<List<Integer>> result = levelOrder(root);

    System.out.println("Level Order Traversal of Tree:");

    // Printing the level order traversal result
    for (List<Integer> level : result) {
      for (int val : level) {
        System.out.print(val + " ");
      }
      System.out.println();
    }
  }
}

