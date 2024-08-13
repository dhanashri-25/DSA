//tc-O(N)
//sc-O(N)
class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] count = { 0 };// to store no of nodes
        // func to count nodes
        inorder(root, count);
        return count[0];
    }

    public void inorder(TreeNode root, int[] count) {
        // base case
        if (root == null)
            return;
        count[0]++;// increment count for current node
        inorder(root.left, count);
        inorder(root.right, count);
    }
}


class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lh=findLeftHeight(root);
        int rh=findRightHeight(root);
        if(lh==rh){
            return (1<<lh)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public int findLeftHeight(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    public int findRightHeight(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.right;
        }
        return count;
    }
}
//tc-O(logn*logn)
//sc-O(n)