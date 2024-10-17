import java.util.*;

class Node {
  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

public class IterativePreOrder {
  // push into stack like 1)node 2)right 3)left
  public List<Integer> preorder(Node root) {
    List<Integer> inorder = new ArrayList<>();
    if (root == null)
      return inorder;
    Stack<Node> st = new Stack<>();
    st.push(root);
    while (!st.isEmpty()) {
      Node node = st.pop();
      inorder.add(node.data);
      if (node.right != null)
        st.push(node.right);
      if (node.left != null)
        st.push(node.left);
    }
    return inorder;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.right.right = new Node(5);
    IterativePreOrder sol = new IterativePreOrder();
    List<Integer> ans = sol.preorder(root);
    System.out.println("Preorder");
    for (int val : ans) {
      System.out.print(val + " ");
    }
    System.out.println();
  }
}
