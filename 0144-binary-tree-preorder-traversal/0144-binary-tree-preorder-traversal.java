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
 
            10
        9       11
      3   7    1   2
 
 st:  10
 res: 10, 9, 3
 */



class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        
        while (curr!=null || st.size()>0){
            while (curr!=null){
                res.add(curr.val);
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            curr = curr.right;
        }
        
        
        return res;
    }
}