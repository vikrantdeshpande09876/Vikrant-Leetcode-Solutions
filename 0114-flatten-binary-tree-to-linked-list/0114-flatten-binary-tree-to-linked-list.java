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
    public TreeNode dfs(TreeNode node, TreeNode prev){
        if (node == null)
            return prev;

        prev = dfs(node.right, prev);
        prev = dfs(node.left, prev);
        node.right = prev;
        node.left = null;
        return node;
    }
    
    
    public void flatten(TreeNode root) {
        root = dfs(root, null);
    }
}