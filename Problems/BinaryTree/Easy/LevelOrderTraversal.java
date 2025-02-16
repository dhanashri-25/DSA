
import java.util.*;

class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

public class LevelOrderTraversal {
  public static List<List<Integer>> level(Node root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null)
      return ans;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      List<Integer> level = new ArrayList<>();// initialize new level for adding
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Node node = q.remove();
        level.add(node.data);
        if (node.left != null)
          q.add(node.left);
        if (node.right != null)
          q.add(node.right);
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
    root.right.right=new Node(6);

    // Perform level-order traversal
    List<List<Integer>> result = level(root);

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
// dry run
// q=[1]
// itr=1 level=[1] add 2 3 to queue q=[2,3] ans=[[1]]
// itr=2 level=[2,3] q=[4,5,6] ans=[[1][2,3]]
// itr=3 level=[4,5,6] q=[] ans=[[1],[2,3],[4,5,6]]
