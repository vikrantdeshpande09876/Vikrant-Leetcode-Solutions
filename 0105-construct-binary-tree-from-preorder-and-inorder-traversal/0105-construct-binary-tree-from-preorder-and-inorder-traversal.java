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
    Map<Integer, Integer> hmap;
    int k = 0;

    public TreeNode dfs(int[] preorder, int[] inorder, int l, int r){
        if (l > r)
            return null;
        
        TreeNode node = new TreeNode(preorder[k]);
        int pos = hmap.get(preorder[k++]);
        node.left = dfs(preorder, inorder, l, pos-1);
        node.right = dfs(preorder, inorder, pos+1, r);
        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hmap = new HashMap<>();
        int n = inorder.length;
        for (int i=0; i<n; i++)
            hmap.put(inorder[i], i);
        
        return dfs(preorder, inorder, 0, n-1);
    }
}