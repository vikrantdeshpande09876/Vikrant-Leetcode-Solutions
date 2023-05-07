/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean dfsRecCheck(TreeNode l, TreeNode r){
        if (l==null && r==null)
            return true;
        if (l==null || r==null || l.val != r.val)
            return false;
        
        return dfsRecCheck(l.left, r.right) && dfsRecCheck(l.right, r.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        return dfsRecCheck(root, root);
    }
}