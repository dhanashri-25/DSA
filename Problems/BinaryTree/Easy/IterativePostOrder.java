import java.util.*;
class Node {
  Node left;
  Node right;
  int data;

  public Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}
public class IterativePostOrder {
  public List<Integer> postOrder(Node root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null)
      return ans;
    Stack<Node> st = new Stack<>();
    st.push(root);
    while (!st.isEmpty()) {
      Node node = st.pop();
      ans.add(node.data);
      if (node.left != null)
        st.push(node.left);
      if (node.right != null)
        st.push(node.right);
    }
    Collections.reverse(ans);
    return ans;
  }

  public static void main(String[] args) {
    IterativePostOrder sol = new IterativePostOrder();
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    List<Integer> ans = sol.postOrder(root);
    System.out.println("Postorder is : ");
    for (int val : ans) {
      System.out.print(val + " ");
    }
    System.out.println();
  }
}
