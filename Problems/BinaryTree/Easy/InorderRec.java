
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

public class InorderRec {
  public static void funcInorder(Node root, List<Integer> ans) {
    if (root == null)
      return;
    funcInorder(root.left, ans);
    ans.add(root.data);
    funcInorder(root.right, ans);
  }

  public static List<Integer> inorder(Node root) {
    List<Integer> ans = new ArrayList<>();
    funcInorder(root, ans);
    return ans;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    List<Integer> result = inorder(root);
    System.out.println("Inorder traversal is : ");
    for (int val : result) {
      System.out.print(val + " ");
    }
    System.out.println();

  }
}
