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
    public int dfsHeight(TreeNode node, int ht){
        if (node == null)
            return ht;

        return 1+Math.max(dfsHeight(node.left, ht), dfsHeight(node.right, ht));
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        
        if (Math.abs(dfsHeight(root.left, 0) - dfsHeight(root.right, 0)) > 1)
            return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
}