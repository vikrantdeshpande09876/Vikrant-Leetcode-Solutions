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
        
        
        return dfsRecCheck(l.left, r.right) && dfsRecCheck(l.right, r.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> st = new Stack();
        st.push(root);
        st.push(root);
        while (st.size() > 0){
            TreeNode l = st.pop();
            TreeNode r = st.pop();
            if ((l==null && r!=null) || (l!=null && r==null))
                return false;
            if (l!=null & r!=null){
                if (l.val != r.val)
                    return false;

                st.push(l.left);
                st.push(r.right);
                st.push(l.right);
                st.push(r.left);
            }
        }
        return true;
    }
}