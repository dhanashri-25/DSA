//using recursion
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root==null) return null;
      int curr=root.val;
      // If both nodes are less than root, then LCA lies in left subtree
      if(curr>p.val && curr>q.val){
          return lowestCommonAncestor(root.left,p,q);
      }
      // If both nodes are greater than root, then LCA lies in right subtree
      if(curr<p.val && curr<q.val){
          return lowestCommonAncestor(root.right,p,q);
      }
      // If one node is less and the other is greater, then root is the LCA
      return root;
  }
}