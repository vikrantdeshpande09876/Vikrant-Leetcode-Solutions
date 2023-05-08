/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode recListToBST(ListNode start, ListNode end){
        if (start == null || start == end)
            return null;
        
        ListNode mid = start, right = start;
        while (right.next!=end && right.next.next!=end){
            mid = mid.next;
            right = right.next.next;
        }
        
        TreeNode root = new TreeNode(mid.val);
        root.left = recListToBST(start, mid);
        root.right = recListToBST(mid.next, end);
        
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        return recListToBST(head, null);
    }
}