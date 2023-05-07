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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        
        boolean leftToRight = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0){
            List<Integer> currLevel = new ArrayList<>();
            int n = q.size();
            for (int i=0; i<n; i++){
                TreeNode node = q.poll();
                currLevel.add(node.val);
                if (node.left != null)          q.offer(node.left);
                if (node.right != null)         q.offer(node.right);
            }
            
            if (leftToRight){
                res.add(currLevel);
                leftToRight = false;
            }
            else {
                Collections.reverse(currLevel);
                res.add(currLevel);
                leftToRight = true;
            }
        }
        return res;
    }
}