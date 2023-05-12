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
    int res;
    
    public void dfs(TreeNode node, int curr){
        if (node == null){
            return;
        }
        
        curr = curr*10 + node.val;
        if (node.left==null && node.right==null){
            res += curr;
            return;
        }
        
        dfs(node.left, curr);
        dfs(node.right, curr);
    }
    
    public int sumNumbers(TreeNode root) {
        res = 0;
        dfs(root, res);
        return res;
    }
}