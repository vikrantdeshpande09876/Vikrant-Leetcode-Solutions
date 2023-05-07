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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        
        List<Integer> currLevel;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (q.size() > 0) {
            currLevel = new ArrayList<>();
            int n = q.size();
            for (int i=0; i<n; i++){
                TreeNode node = q.poll();
                currLevel.add(node.val);
                if (node.left!=null)        q.offer(node.left);
                if (node.right!=null)       q.offer(node.right);
            }
            res.add(currLevel);
        }
        return res;
    }
}